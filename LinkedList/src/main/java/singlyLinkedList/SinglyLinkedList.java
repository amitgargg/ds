package singlyLinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

	Node<T> firstNode;
	Node<T> lastNode;

	public SinglyLinkedList() {

	}

	public void insertFirst(T data) {
		Node<T> newNode = new Node<T>(data);
		if (firstNode == null) {
			firstNode = newNode;
			lastNode = firstNode;
		} else {
			Node<T> tempNode = firstNode;
			firstNode = newNode;
			newNode.setNextNode(tempNode);
		}
	}

	public void insertAtIndex(T data, int index) {
		Node<T> tempNode = null;
		for (int i = 0; i < index; i++) {
			if (tempNode == null) {
				tempNode = firstNode;
			} else {
				tempNode = tempNode.nextNode;
			}
			if (tempNode == null) {
				throw new IndexOutOfBoundsException();
			}
		}
		if (index == 0) {
			insertFirst(data);
		} else {
			Node<T> nextNode = tempNode.nextNode;
			Node<T> newNode = new Node<T>(data);
			newNode.setNextNode(nextNode);
			tempNode.setNextNode(newNode);
		}
	}

	public void insertLast(T data) {
		Node<T> newNode = new Node<T>(data);
		if (firstNode == null) {
			firstNode = newNode;
			lastNode = firstNode;
		} else {
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
	}
	
	public T getFirst() {
		if(firstNode == null) {
			new NoSuchElementException();
		}
		T data = firstNode.getData();
		firstNode = firstNode.nextNode;
		if(firstNode == null) {       
			lastNode = null;
		}
		return data;
	}

	public void printAll() {	
		Node<T> tempNode = firstNode;
		while (tempNode != null) {
			System.out.print(tempNode.getData() + ",");
			tempNode = tempNode.nextNode;
		}
		System.out.println();

	}

	public static void main(String[] args) {
		SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
		linkedList.insertFirst("String1");
		linkedList.insertFirst("String2");
		System.out.println(linkedList.getFirst());
		System.out.println(linkedList.getFirst());
	}
	
	@Override
	public String toString() {
		StringBuffer data = new StringBuffer();
		Node<T> tempNode = firstNode;
		while (tempNode != null) {
			data.append(tempNode.getData() + ",");
			tempNode = tempNode.nextNode;
		}
		return data.toString();
	}

}

class Node<T> {
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