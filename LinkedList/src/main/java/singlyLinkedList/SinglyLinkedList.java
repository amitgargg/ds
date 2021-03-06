package singlyLinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

	Node<T> firstNode;
	Node<T> lastNode;

	public SinglyLinkedList() {

	}

	public T deleteFirst() {
		if (firstNode == null) {
			new NoSuchElementException();
		}
		T data = firstNode.getData();
		firstNode = firstNode.nextNode;
		if (firstNode == null) {
			lastNode = null;
		}
		return data;
	}

	public T deleteLast() {
		if (lastNode == null) {
			throw new NoSuchElementException();
		}
		Node<T> secondLastNode = null;
		Node<T> tempNode = firstNode;
		while (tempNode.nextNode != null) {
			secondLastNode = tempNode;
			tempNode = secondLastNode.nextNode;
		}
		T data = lastNode.data;
		if (secondLastNode == null) {
			firstNode = null;
		} else {
			secondLastNode.nextNode = null;
		}
		lastNode = secondLastNode;
		return data;
	}

	public T deleteAtIndex(int index) {
		Node<T> tempNode = null;
		for (int i = 0; i < index; i++) {
			if (tempNode == null) {
				tempNode = firstNode;
			} else {
				tempNode = tempNode.nextNode;
			}

			if (tempNode == null || tempNode.nextNode == null) {
				throw new IndexOutOfBoundsException();
			}
		}
		T data = null;
		if (index == 0) {
			data = deleteFirst();
		} else {
			Node<T> nodeForDelete = tempNode.nextNode;
			Node<T> nextNode = nodeForDelete.nextNode;
			tempNode.nextNode = nextNode;
			data = nodeForDelete.data;
		}
		return data;
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
	
	public void insertLast(Node<T> newNode) {
		if (firstNode == null) {
			firstNode = newNode;
			lastNode = firstNode;
		} else {
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
	}

	public T getFirst() {
		if (firstNode == null) {
			new NoSuchElementException();
		}
		return firstNode.getData();
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
		System.out.println(linkedList);
		System.out.println(linkedList.deleteAtIndex(1));
		System.out.println(linkedList);
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

	public Node<T> getFirstNode() {
		return firstNode;
	}

}
