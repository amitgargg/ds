package singlyLinkedList;

public class Node<T> {
	T data;
	Node<T> nextNode;

	public Node(T data) {
		this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
