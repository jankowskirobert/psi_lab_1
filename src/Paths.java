public class Paths {

	public static void main(String[] args) {
		// Przyklad ze strony
		// http://www.algorytm.org/algorytmy-grafowe/przeszukiwanie-grafu-wszerz-bfs-i-w-glab-dfs.html
		// UWAGA: graf skierowany zostal przerobiony na graf nieskierowany
		// stan na dzien 2013-04-08
		// grafy nieskierowane
		Graph graph = new Graph(6);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);

		graph.addEdge(1, 4);

		graph.addEdge(2, 3);
		graph.addEdge(2, 5);

		graph.addEdge(3, 0);

		graph.addEdge(4, 3);

		System.out.println("Graf nieskierowany: " + graph);

		System.out.println("\nDFS - sciezki nieskierowane");
		// droga z 1 do 5
		DFSPaths dfs1 = new DFSPaths(graph, 0);
		for (int it : dfs1.getPathTo(4)) {
			System.out.print(it + " ");
		}
		System.out.println("\n----------");

		// droga z 5 do 1
		DFSPaths dfs2 = new DFSPaths(graph, 4);
		for (int it : dfs2.getPathTo(0)) {
			System.out.print(it + " ");
		}

		System.out.println("\nBFS - sciezki nieskierowane");
		// droga z 1 do 5
		BFSPaths bfs1 = new BFSPaths(graph, 0);
		for (int it : bfs1.getPathTo(4)) {
			System.out.print(it + " ");
		}
		System.out.println("\n----------");

		// droga z 5 do 1
		BFSPaths bfs2 = new BFSPaths(graph, 4);
		for (int it : bfs2.getPathTo(0)) {
			System.out.print(it + " ");
		}
		// --------------------------------------------
		// grafy skierowane
		DirectedGraph digraph = new DirectedGraph(6);

		digraph.addEdge(0, 1);
		digraph.addEdge(0, 2);

		digraph.addEdge(1, 4);

		digraph.addEdge(2, 3);
		digraph.addEdge(2, 5);

		digraph.addEdge(3, 0);

		digraph.addEdge(4, 3);

		// Przyklad ze strony
		// http://www.algorytm.org/algorytmy-grafowe/przeszukiwanie-grafu-wszerz-bfs-i-w-glab-dfs.html
		// stan na dzien 2013-04-08
		System.out.println("\n\nGraf skierowany: " + digraph);

		System.out.println("\nDFS - sciezki skierowane");
		// droga z 1 do 5
		DFSDirectedPaths dfs3 = new DFSDirectedPaths(digraph, 0);
		for (int it : dfs3.getPathTo(4)) {
			System.out.print(it + " ");
		}
		System.out.println("\n----------");

		// droga z 5 do 1
		DFSDirectedPaths dfs4 = new DFSDirectedPaths(digraph, 4);
		for (int it : dfs4.getPathTo(0)) {
			System.out.print(it + " ");
		}

		System.out.println("\nBFS - sciezki skierowane");
		// droga z 1 do 5
		BFSDirectedPaths bfs3 = new BFSDirectedPaths(digraph, 0);
		for (int it : bfs3.getPathTo(4)) {
			System.out.print(it + " ");
		}
		System.out.println("\n----------");

		// droga z 5 do 1
		BFSDirectedPaths bfs4 = new BFSDirectedPaths(digraph, 4);
		for (int it : bfs4.getPathTo(0)) {
			System.out.print(it + " ");
		}
	}
}