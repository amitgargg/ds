package org.Graph;

import java.util.LinkedList;

public class AdjacencyList {

	private int vertex;

	private LinkedList<Integer>[] edges;

	@SuppressWarnings("unchecked")
	public AdjacencyList(int vertext) {
		this.vertex = vertext;
		this.edges = new LinkedList[vertext];

		for (int i = 0; i < vertex; i++) {
			this.edges[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int destination) {
		// Directed Graph
		this.edges[source].addFirst(destination);
		
		// For Non Directed Graph
//		this.edges[destination].addFirst(source);		
	}

	private void printEdge() {
		for (int i = 0; i < edges.length; i++) {
			System.out.print("Vertex " + i + " is connected to: ");
			LinkedList<Integer> linkedList = edges[i];
			for (Integer integer : linkedList) {
				System.out.print(integer + "==>");
			}
			System.out.println();
		}
	}

	private boolean isEdge(int source, int destination) {
		boolean isEdge = false;
		LinkedList<Integer> linkedList = edges[source];
		for (Integer integer : linkedList) {
			if (destination == integer) {
				isEdge = true;
			}
		}
		return isEdge;
	}

	public static void main(String[] args) {
		AdjacencyList adjacencyList = new AdjacencyList(4);
		adjacencyList.addEdge(0, 1);
		adjacencyList.addEdge(0, 2);
		adjacencyList.addEdge(1, 2);
		adjacencyList.addEdge(2, 3);
		adjacencyList.addEdge(3, 1);

		adjacencyList.printEdge();

		System.out.println("IsEdge between 2 to 3 " + adjacencyList.isEdge(2, 3));
		System.out.println("IsEdge between 2 to 1 " + adjacencyList.isEdge(2, 1));
	}
}
