package org.tree.binarytree;

import java.util.Stack;

public class PreorderTraversal {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();

		preOrderTraversalRecursive(binaryTree.getRoot());
		preOrderTraversalIterative(binaryTree.getRoot());

	}

	private static void preOrderTraversalRecursive(BinaryTreeNode<Integer> rootNode) {
		System.out.println("PreOrder Traversal Recursive: ");
		preOrderRecursive(rootNode);
		System.out.println();

	}

	private static void preOrderRecursive(BinaryTreeNode<Integer> rootNode) {
		if (rootNode != null) {
			System.out.print(rootNode.getData() + " ");
			preOrderRecursive(rootNode.getLeftNode());
			preOrderRecursive(rootNode.getRightNode());
		}
	}

	private static void preOrderTraversalIterative(BinaryTreeNode<Integer> rootNode) {
		System.out.println("PreOrder Traversal Iterative: ");
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		stack.add(rootNode);
		while (!stack.isEmpty()) {

			BinaryTreeNode<Integer> currNode = stack.pop();
			System.out.print(currNode.getData() + " ");

			if (currNode.getRightNode() != null) {
				stack.add(currNode.getRightNode());
			}

			if (currNode.getLeftNode() != null) {
				stack.add(currNode.getLeftNode());
			}

		}

	}
}
