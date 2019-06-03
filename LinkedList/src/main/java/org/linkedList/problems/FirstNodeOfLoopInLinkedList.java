package org.linkedList.problems;

import singlyLinkedList.Node;
import singlyLinkedList.SinglyLinkedList;

public class FirstNodeOfLoopInLinkedList {
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);
		Node<Integer> node5 = new Node<>(5);
		linkedList.insertLast(node1);
		linkedList.insertLast(node2);
		linkedList.insertLast(node3);
		linkedList.insertLast(node4);
		linkedList.insertLast(node5);
		linkedList.insertLast(node3);
		
		System.out.println(findBeginOfLoop(linkedList.getFirstNode()));
	}

	public static Node<Integer> findBeginOfLoop(Node<Integer> head) {

		Node<Integer> fastPtr = head;
		Node<Integer> slowPtr = head;
		boolean loopExists = false;

		while (fastPtr != null && fastPtr.getNextNode() != null) {
			fastPtr = fastPtr.getNextNode().getNextNode();
			slowPtr = slowPtr.getNextNode();
			if (fastPtr == slowPtr) {
				loopExists = true;
				break;
			}
		}

		if (loopExists) {
			slowPtr = head;
			while (slowPtr != fastPtr) {
				slowPtr = slowPtr.getNextNode();
				fastPtr = fastPtr.getNextNode();
			}
			return fastPtr;
		}
		return null;
	}
}
