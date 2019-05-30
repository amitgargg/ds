package org.Graph;

import java.util.Stack;

public class DepthFirstSearch {

	private final int maxVertices = 20;

	private Vertex vertexList[];

	private int adjMatrix[][];

	private int vertexCount;

	private Stack<Integer> theStack;

	public DepthFirstSearch() {
		vertexList = new Vertex[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
		vertexCount = 0;
		theStack = new Stack<Integer>();
	}

	public void addVertex(String label) {
		vertexList[vertexCount++] = new Vertex(label);
	}

	public void addEdge(int source, int destination) {
		adjMatrix[source][destination] = 1;
		adjMatrix[destination][source] = 1;
	}

	public void displayVertex(int v) {
		System.out.println(vertexList[v].getLabel());
	}

	private int getAdjUnvisitiedVertex(int v) {
		for (int i = 0; i < vertexCount; i++) {
			if (adjMatrix[v][i] == 1 && vertexList[i].isVisited() == false) {
				return i;
			}
		}
		return -1;
	}

	public void dfs() {
		vertexList[0].setVisited(true);
		displayVertex(0);
		theStack.push(0);
		while (!theStack.isEmpty()) {
			int v = getAdjUnvisitiedVertex(this.theStack.peek());
			if (v == -1) {
				theStack.pop();
			} else {
				vertexList[v].setVisited(true);
				displayVertex(v);
				theStack.push(v);
			}
		}
	}

	public static void main(String[] args) {
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
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

		depthFirstSearch.dfs();
	}
}

class Vertex {
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