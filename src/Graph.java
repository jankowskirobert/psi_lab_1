
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// GRAFY NIESKIEROWANE
class Graph {
	// liczba krawedzi
	private int e;
	// liczba wierzcholkow
	private int v;
	// tablica list sasiedztwa danego wierzcholka
	private List<Integer>[] adjacencyList;

	/**
	 *
	 * @param v
	 *            ilosc wierzcholkow w grafie
	 */
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		this.e = 0;
		adjacencyList = (List<Integer>[]) new List[v];
		for (int i = 0; i < v; i++) {
			adjacencyList[i] = new ArrayList<Integer>();
		}
	}

	/**
	 * Dodaje krawedz v-w do grafu nieskierowanego.
	 *
	 * @param v
	 *            jeden z wierzcholkow krawedzi
	 * @param w
	 *            drugi z wierzcholkow krawedzi
	 */
	public void addEdge(int v, int w) {
		adjacencyList[v].add(w);
		adjacencyList[w].add(v);
		e++;
	}

	/**
	 *
	 * @return liczbe krawedzi
	 */
	public int getNumberOfEdges() {
		return e;
	}

	/**
	 * @return liczbe wierzcholkow
	 */
	public int getNumberOfVertices() {
		return v;
	}

	/**
	 * Zwraca liste sasiedztwa danego wierzcholka.
	 *
	 * @param v
	 *            indeks wierzcholka skierowanego
	 * @return zwraca iterowalna kolekcje wierzcholkow sasiadujacych
	 */
	public Iterable<Integer> getAdjacencyList(int v) {
		return adjacencyList[v];
	}

	/**
	 * @return opis grafu.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		s.append("wierzcholki: ").append(v).append("; krawedzie: ").append(e).append(newLine);
		for (int i = 0; i < v; i++) {
			s.append(i).append(": ");
			for (int w : adjacencyList[i]) {
				s.append(w).append(" ");
			}
			s.append(newLine);
		}
		return s.toString();
	}
}

class DFSPaths {
	// tablica krawedzi ktora jest
	// przechowuje wierzcholki z ktorych mozna sie dostac do biezacego
	// okreslonego indeksem tablicy
	private int[] edgeTo;
	// tablica odwiedzonych wierzcholkow
	private boolean[] marked;
	// wierzcholek zrodlowy, z ktorego rozpoczynamy przeszukiwanie
	private final int source;

	public DFSPaths(Graph graph, int source) {
		this.source = source;
		edgeTo = new int[graph.getNumberOfVertices()];
		marked = new boolean[graph.getNumberOfVertices()];
		dfs(graph, source);
	}

	/**
	 *
	 * @param vertex
	 *            indeks wierzcholka dla ktorego ma byc sprawdzenie istnienia
	 *            sciezki
	 * @return true jesli istnieje sciezka z wierzcholka zrodlowego danego w
	 *         konstruktorze do wierzcholka {@code vertex}
	 */
	public boolean hasPathTo(int vertex) {
		return marked[vertex];
	}

	/**
	 *
	 * @param vertex
	 *            docelowy wierzcholek
	 * @return stos wierzcholkow prowadzacych ze zrodal {@code source} do celu
	 *         {@code vertex} jesli sciezka nie istnieje zwracana jest pusta
	 *         kolekcja
	 */
	public Iterable<Integer> getPathTo(int vertex) {
		Deque<Integer> path = new ArrayDeque<Integer>();
		// jesli nie istnieje sciezka zwroc pusta sciezke
		if (!hasPathTo(vertex)) {
			return path;
		}
		// dopoki istnieje wierzcholek dodawaj go do stosu
		for (int w = vertex; w != source; w = edgeTo[w]) {
			path.push(w);
		}
		// dodaj na koniec krawedz zrodlowa
		path.push(source);
		return path;
	}

	private void dfs(Graph graph, int vertex) {
		// oznaczamy wierzcholek jako odwiedzony
		marked[vertex] = true;
		// dla kazdego sasiedniego wierzcholka jesli nie jest oznaczony
		// wywolujemy rekurencyjnie metode dfs, ktora odwiedzi wierzchoki i
		// zapisze trase
		for (int w : graph.getAdjacencyList(vertex)) {
			if (!marked[w]) {
				edgeTo[w] = vertex;
				dfs(graph, w);
			}
		}
	}
}

class BFSPaths {
	// tablica krawedzi ktora jest
	// przechowuje wierzcholki z ktorych mozna sie dostac do biezacego
	// okreslonego indeksem tablicy
	private int[] edgeTo;
	// tablica odwiedzonych wierzcholkow
	private boolean[] marked;
	// wierzcholek zrodlowy, z ktorego rozpoczynamy przeszukiwanie
	private final int source;
	private Queue<Integer> priorityQueue;

	public BFSPaths(Graph graph, int source) {
		this.source = source;
		edgeTo = new int[graph.getNumberOfVertices()];
		marked = new boolean[graph.getNumberOfVertices()];
		priorityQueue = new PriorityQueue<Integer>(graph.getNumberOfVertices());
		priorityQueue.offer(source);
		bfs(graph, source);
	}

	/**
	 *
	 * @param vertex
	 *            indeks wierzcholka dla ktorego ma byc sprawdzenie istnienia
	 *            sciezki
	 * @return true jesli istnieje sciezka z wierzcholka zrodlowego danego w
	 *         konstruktorze do wierzcholka {@code vertex}
	 */
	public boolean hasPathTo(int vertex) {
		return marked[vertex];
	}

	/**
	 *
	 * @param vertex
	 *            docelowy wierzcholek
	 * @return stos wierzcholkow prowadzacych ze zrodal {@code source} do celu
	 *         {@code vertex} jesli sciezka nie istnieje zwracana jest pusta
	 *         kolekcja
	 */
	public Iterable<Integer> getPathTo(int vertex) {
		Deque<Integer> path = new ArrayDeque<Integer>();
		// jesli nie istnieje sciezka zwroc pusta sciezke
		if (!hasPathTo(vertex)) {
			return path;
		}
		// dopoki istnieje wierzcholek dodawaj go do stosu
		for (int w = vertex; w != source; w = edgeTo[w]) {
			path.push(w);
		}
		// dodaj na koniec krawedz zrodlowa
		path.push(source);
		return path;
	}

	private void bfs(Graph graph, int vertex) {
		// oznaczamy wierzcholek jako odwiedzony
		marked[vertex] = true;

		// dodajemy wierzcholek zrodlowy do kolejki
		priorityQueue.offer(vertex);

		// dopoki kolejka nie jest pusta, wybieramy krawedz o najnizszym
		// priorytecie
		// i oznaczamy jako odwiedzone wierzcholki z listy sasiedztwa usuwanego
		// wierzcholka
		// oraz dodajemy wierzcholki z listy sasiedztwa do kolejki
		while (!priorityQueue.isEmpty()) {
			int v = priorityQueue.remove();
			for (int w : graph.getAdjacencyList(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					priorityQueue.offer(w);
				}
			}
		}
	}
}

// GRAFY SKIEROWANE
class DirectedGraph {
	// liczba krawedzi
	private int e;
	// liczba wierzcholkow
	private int v;
	// tablica list sasiedztwa danego wierzcholka
	private List<Integer>[] adjacencyList;

	/**
	 *
	 * @param v
	 *            ilosc wierzcholkow w grafie
	 */
	@SuppressWarnings("unchecked")
	public DirectedGraph(int v) {
		this.v = v;
		this.e = 0;
		adjacencyList = (List<Integer>[]) new List[v];
		for (int i = 0; i < v; i++) {
			adjacencyList[i] = new ArrayList<Integer>();
		}
	}

	/**
	 * Dodaje krawedz v-w do grafu skierowanego.
	 *
	 * @param v
	 *            wierzcholek poczatkowy
	 * @param w
	 *            wierzcholek koncowy
	 */
	public void addEdge(int v, int w) {
		adjacencyList[v].add(w);
		e++;
	}

	/**
	 *
	 * @return liczbe krawedzi
	 */
	public int getNumberOfEdges() {
		return e;
	}

	/**
	 * @return liczbe wierzcholkow
	 */
	public int getNumberOfVertices() {
		return v;
	}

	/**
	 * Zwraca liste sasiedztwa danego wierzcholka.
	 *
	 * @param v
	 *            indeks wierzcholka skierowanego
	 * @return zwraca iterowalna kolekcje wierzcholkow sasiadujacych
	 */
	public Iterable<Integer> getAdjacencyList(int v) {
		return adjacencyList[v];
	}

	/**
	 * @return opis grafu.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		s.append("wierzcholki: ").append(v).append("; krawedzie: ").append(e).append(newLine);
		for (int i = 0; i < v; i++) {
			s.append(i).append(": ");
			for (int w : adjacencyList[i]) {
				s.append(w).append(" ");
			}
			s.append(newLine);
		}
		return s.toString();
	}
}

class DFSDirectedPaths {
	// tablica krawedzi ktora jest
	// przechowuje wierzcholki z ktorych mozna sie dostac do biezacego
	// okreslonego indeksem tablicy
	private int[] edgeTo;
	// tablica odwiedzonych wierzcholkow
	private boolean[] marked;
	// wierzcholek zrodlowy, z ktorego rozpoczynamy przeszukiwanie
	private final int source;

	public DFSDirectedPaths(DirectedGraph graph, int source) {
		this.source = source;
		edgeTo = new int[graph.getNumberOfVertices()];
		marked = new boolean[graph.getNumberOfVertices()];
		dfs(graph, source);
	}

	/**
	 *
	 * @param vertex
	 *            indeks wierzcholka dla ktorego ma byc sprawdzenie istnienia
	 *            sciezki
	 * @return true jesli istnieje sciezka z wierzcholka zrodlowego danego w
	 *         konstruktorze do wierzcholka {@code vertex}
	 */
	public boolean hasPathTo(int vertex) {
		return marked[vertex];
	}

	/**
	 *
	 * @param vertex
	 *            docelowy wierzcholek
	 * @return stos wierzcholkow prowadzacych ze zrodal {@code source} do celu
	 *         {@code vertex} jesli sciezka nie istnieje zwracana jest pusta
	 *         kolekcja
	 */
	public Iterable<Integer> getPathTo(int vertex) {
		Deque<Integer> path = new ArrayDeque<Integer>();
		// jesli nie istnieje sciezka zwroc pusta sciezke
		if (!hasPathTo(vertex)) {
			return path;
		}
		// dopoki istnieje wierzcholek dodawaj go do stosu
		for (int w = vertex; w != source; w = edgeTo[w]) {
			path.push(w);
		}
		// dodaj na koniec krawedz zrodlowa
		path.push(source);
		return path;
	}

	private void dfs(DirectedGraph graph, int vertex) {
		// oznaczamy wierzcholek jako odwiedzony
		marked[vertex] = true;
		// dla kazdego sasiedniego wierzcholka jesli nie jest oznaczony
		// wywolujemy rekurencyjnie metode dfs, ktora odwiedzi wierzchoki i
		// zapisze trase
		for (int w : graph.getAdjacencyList(vertex)) {
			if (!marked[w]) {
				edgeTo[w] = vertex;
				dfs(graph, w);
			}
		}
	}
}

class BFSDirectedPaths {
	// tablica krawedzi ktora jest
	// przechowuje wierzcholki z ktorych mozna sie dostac do biezacego
	// okreslonego indeksem tablicy
	private int[] edgeTo;
	// tablica odwiedzonych wierzcholkow
	private boolean[] marked;
	// wierzcholek zrodlowy, z ktorego rozpoczynamy przeszukiwanie
	private final int source;
	private Queue<Integer> priorityQueue;

	public BFSDirectedPaths(DirectedGraph graph, int source) {
		this.source = source;
		edgeTo = new int[graph.getNumberOfVertices()];
		marked = new boolean[graph.getNumberOfVertices()];
		priorityQueue = new PriorityQueue<Integer>(graph.getNumberOfVertices());
		priorityQueue.offer(source);
		bfs(graph, source);
	}

	/**
	 *
	 * @param vertex
	 *            indeks wierzcholka dla ktorego ma byc sprawdzenie istnienia
	 *            sciezki
	 * @return true jesli istnieje sciezka z wierzcholka zrodlowego danego w
	 *         konstruktorze do wierzcholka {@code vertex}
	 */
	public boolean hasPathTo(int vertex) {
		return marked[vertex];
	}

	/**
	 *
	 * @param vertex
	 *            docelowy wierzcholek
	 * @return stos wierzcholkow prowadzacych ze zrodal {@code source} do celu
	 *         {@code vertex} jesli sciezka nie istnieje zwracana jest pusta
	 *         kolekcja
	 */
	public Iterable<Integer> getPathTo(int vertex) {
		Deque<Integer> path = new ArrayDeque<Integer>();
		// jesli nie istnieje sciezka zwroc pusta sciezke
		if (!hasPathTo(vertex)) {
			return path;
		}
		// dopoki istnieje wierzcholek dodawaj go do stosu
		for (int w = vertex; w != source; w = edgeTo[w]) {
			path.push(w);
		}
		// dodaj na koniec krawedz zrodlowa
		path.push(source);
		return path;
	}

	private void bfs(DirectedGraph graph, int vertex) {
		// oznaczamy wierzcholek jako odwiedzony
		marked[vertex] = true;

		// dodajemy wierzcholek zrodlowy do kolejki
		priorityQueue.offer(vertex);

		// dopoki kolejka nie jest pusta, wybieramy krawedz o najnizszym
		// priorytecie
		// i oznaczamy jako odwiedzone wierzcholki z listy sasiedztwa usuwanego
		// wierzcholka
		// oraz dodajemy wierzcholki z listy sasiedztwa do kolejki
		while (!priorityQueue.isEmpty()) {
			int v = priorityQueue.remove();
			for (int w : graph.getAdjacencyList(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					priorityQueue.offer(w);
				}
			}
		}
	}
}

