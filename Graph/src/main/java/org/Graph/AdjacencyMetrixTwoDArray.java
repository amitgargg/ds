package org.Graph;

public class AdjacencyMetrixTwoDArray {

	private boolean adjMatrix[][];
	
	private int vertexCount;
	
	public AdjacencyMetrixTwoDArray(int vertexCount) {
		this.vertexCount = vertexCount;
		
		this.adjMatrix = new boolean[vertexCount][vertexCount];
	}
	
	
	public void addEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
			adjMatrix[i][j] = true;
			adjMatrix[j][i] = true;
		}
	}
	
	public void removeEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
			adjMatrix[i][j] = false;
			adjMatrix[j][i] = false;
		}
	}
	
	public boolean isEdge(int i, int j) {
		if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount)
			return adjMatrix[i][j];
		return false;
	}
	
	
	
	public static void main(String[] args) {
		AdjacencyMetrixTwoDArray adjacencyMetrixTwoDArray = new AdjacencyMetrixTwoDArray(2);
		adjacencyMetrixTwoDArray.addEdge(1, 1);
		System.out.println(adjacencyMetrixTwoDArray.isEdge(1, 1));
	}
}
