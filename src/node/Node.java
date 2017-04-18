package node;

import point.Point;

public class Node<T> {

	private NodeElement<T> head;

	private static class NodeElement<T> {
		T value;
		private NodeElement<T> next;

		public NodeElement(T data, NodeElement<T> next) {
			this.value = data;
			this.next = next;
		}

		public void printValue() {
			System.out.println(value.toString());
			if (next != null) {
				next.printValue();
			}
		}
	}

	public void addFirst(T item) {
		head = new NodeElement<T>(item, head);
	}

	public void addLast(T item)
	{
	   if(head == null) addFirst(item);
	   else
	   {
		   NodeElement<T> tmp = head;
	      while(tmp.next != null) tmp = tmp.next;

	      tmp.next = new NodeElement<T>(item, null);
	   }
	}
	
	public void print() {
		head.printValue();
	}

	public static void main(String[] args) {
		Node n = new Node<Point>();
		n.addFirst(new Point(3, 0));
		n.addFirst(new Point(3, 3));
		n.addLast(new Point(6, 3));
		n.print();
	}
}
