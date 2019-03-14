package org.tree.binarytree;

import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();

		postOrderTraversalRecursive(binaryTree.getRoot());
		postOrderTraversalIterative(binaryTree.getRoot());

	}

	private static void postOrderTraversalIterative(BinaryTreeNode<Integer> root) {
		System.out.println("PostOrder Traversal Iterative");
		BinaryTreeNode<Integer> curr = root;
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		while (curr != null || !stack.isEmpty()) {

			if (curr != null) {
				stack.push(curr);
				curr = curr.getLeftNode();
			} else {
				BinaryTreeNode<Integer> temp = stack.peek();
				if (temp.getRightNode() != null) {
					curr = temp.getRightNode();
				} else {
					temp = stack.pop();
					System.out.print(temp.getData() + " ");
					while (!stack.isEmpty() && temp == stack.peek().getRightNode()) {
						temp = stack.pop();
						System.out.print(temp.getData() + " ");
					}
				}
			}

		}
		System.out.println();
	}

	private static void postOrderTraversalRecursive(BinaryTreeNode<Integer> root) {
		System.out.println("PostOrder Traversal Recursive");
		postOrderRecursive(root);
		System.out.println();
	}

	private static void postOrderRecursive(BinaryTreeNode<Integer> root) {
		if (root != null) {
			postOrderRecursive(root.getLeftNode());
			postOrderRecursive(root.getRightNode());
			System.out.print(root.getData() + " ");
		}

	}
}
