package org.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteBinaryTreeNode {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		InOrderTraversal.inOrderTraversalIterative(binaryTree.getRoot());
		deleteNode(binaryTree.getRoot(), 1);
		InOrderTraversal.inOrderTraversalIterative(binaryTree.getRoot());
	}

	public static void deleteNode(BinaryTreeNode<Integer> root, int data) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();

		BinaryTreeNode<Integer> temp = null;
		BinaryTreeNode<Integer> dataNode = null;
		queue.add(root);

		while (!queue.isEmpty()) {
			temp = queue.poll();

			if (temp.getData() == data) {
				dataNode = temp;
			}

			if (temp.getLeftNode() != null) {
				queue.add(temp.getLeftNode());
			}

			if (temp.getRightNode() != null) {
				queue.add(temp.getRightNode());
			}
		}
		BinaryTreeNode<Integer> deepestNode = temp; 
		System.out.println("deepest Node===" + deepestNode + "::" + "data Node===" +dataNode);
		dataNode.setData(deepestNode.getData());
		deleteDeepestNode(root, deepestNode);

	}

	public static void deleteDeepestNode(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> nodeToBeDelete) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> temp = queue.poll();

			if (temp.getRightNode() != null) {
				if (temp.getRightNode() == nodeToBeDelete) {
					temp.setRightNode(null);
					return;
				} else {
					queue.add(temp.getRightNode());
				}
			}

			if (temp.getLeftNode() != null) {
				if (temp.getLeftNode() == nodeToBeDelete) {
					temp.setLeftNode(null);
					return;
				} else {
					queue.add(temp.getLeftNode());
				}
			}
		}
	}

}
