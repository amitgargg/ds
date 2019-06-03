package org.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearchUsingAdjacencyList {

	private List<Vertex> vertexList;

	private LinkedList<Integer>[] adjList;

	private Queue<Integer> theQueue;

	@SuppressWarnings("unchecked")
	public BreadthFirstSearchUsingAdjacencyList(int maxVertices) {
		vertexList = new ArrayList<>();
		adjList = new LinkedList[maxVertices];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		theQueue = new LinkedList<Integer>();
	}

	public void addVertex(String label) {
		vertexList.add(new Vertex(label));
	}

	public void addEdge(int source, int destination) {
		adjList[source].addLast(destination);
		adjList[destination].addLast(source);
	}

	public void displayVertex(int v) {
		System.out.println(vertexList.get(v).getLabel());
	}

	private int getAdjUnvisitiedVertex(int v) {
		LinkedList<Integer> edges = adjList[v];

		for (int i = 0; i < edges.size(); i++) {
			int edge = edges.get(i);
			if (vertexList.get(edge).isVisited() == false) {
				return edge;
			}
		}
		return -1;
	}

	public void bfs() {
		vertexList.get(0).setVisited(true);
		displayVertex(0);
		theQueue.offer(0);
		while (!theQueue.isEmpty()) {
			int v = getAdjUnvisitiedVertex(this.theQueue.peek());
			if (v == -1) {
				theQueue.poll();
			} else {
				vertexList.get(v).setVisited(true);
				displayVertex(v);
				theQueue.offer(v);
			}
		}
	}

	public static void main(String[] args) {
		BreadthFirstSearchUsingAdjacencyList depthFirstSearch = new BreadthFirstSearchUsingAdjacencyList(9);
		depthFirstSearch.addVertex("0");
		depthFirstSearch.addVertex("1");
		depthFirstSearch.addVertex("2");
		depthFirstSearch.addVertex("3");
		depthFirstSearch.addVertex("4");
		depthFirstSearch.addVertex("5");
		depthFirstSearch.addVertex("6");
		depthFirstSearch.addVertex("7");
		depthFirstSearch.addVertex("8");

		depthFirstSearch.addEdge(0, 2);
		depthFirstSearch.addEdge(1, 2);
		depthFirstSearch.addEdge(2, 4);
		depthFirstSearch.addEdge(2, 5);
		depthFirstSearch.addEdge(3, 4);
		depthFirstSearch.addEdge(5, 6);
		depthFirstSearch.addEdge(5, 8);
		depthFirstSearch.addEdge(7, 8);

		depthFirstSearch.bfs();
	}

	private class Vertex {
		private String label;

		private boolean visited;

		public Vertex(String label) {
			this.label = label;
			this.visited = false;
		}

		public String getLabel() {
			return label;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}
	}
}
