package org.linkedList.problems;

import singlyLinkedList.Node;
import singlyLinkedList.SinglyLinkedList;

public class CheckLinkedListIsCircular {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		linkedList.insertLast(1);
		linkedList.insertLast(2);
		linkedList.insertLast(3);
		linkedList.insertLast(4);
		linkedList.insertLast(2);

		System.out.println(isCircular(linkedList.getFirstNode()));
	}

	private static boolean isCircular(Node<Integer> head) {
		if (head == null)
			return true;

		Node<Integer> node = head.getNextNode();

		while (node != null && node.getData() != head.getData())
			node = node.getNextNode();
		return (node != null && node.getData() == head.getData());
	}

}
