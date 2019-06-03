package org.tree.binarytree;

import java.util.Stack;

public class InOrderTraversal {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();

		inOrderTraversalRecursive(binaryTree.getRoot());
		inOrderTraversalIterative(binaryTree.getRoot());

	}

	public static void inOrderTraversalIterative(BinaryTreeNode<Integer> root) {
		System.out.println("InOrder Traversal Iterative:");
		boolean done = false;
		BinaryTreeNode<Integer> currNode = root;
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		while (!done) {
			if (currNode != null) {
				stack.add(currNode);
				currNode = currNode.getLeftNode();
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					BinaryTreeNode<Integer> node = stack.pop();
					System.out.print(node.getData() + " ");
					currNode = node.getRightNode();
				}
			}
		}
		System.out.println();
	}

	private static void inOrderTraversalRecursive(BinaryTreeNode<Integer> root) {
		System.out.println("InOrder Traversal Recursive:");
		inOrderRecursive(root);
		System.out.println();
	}

	private static void inOrderRecursive(BinaryTreeNode<Integer> root) {
		if (root != null) {
			inOrderRecursive(root.getLeftNode());
			System.out.print(root.getData() + " ");
			inOrderRecursive(root.getRightNode());
		}
	}

}
