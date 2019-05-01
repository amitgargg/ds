package org.tree.binarytree.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.tree.binarytree.BinaryTree;
import org.tree.binarytree.BinaryTreeNode;

/**
 * 
 * @author egraiam Give an algorithm for finding the number of leaves in the
 *         binary tree without using recursion.
 *
 */

public class NumberOfLeaveNodes {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		int leafNodeCount = noOfLeaveNodesUsingRecursion(binaryTree.getRoot(), 0);
		System.out.println("Using Recursion: " + leafNodeCount);

		leafNodeCount = noOfLeaveNodesUsingQueue(binaryTree.getRoot());
		System.out.println("Using Queue: " + leafNodeCount);

		leafNodeCount = noOfLeaveNodesUsingStack(binaryTree.getRoot());
		System.out.println("Using Stack: " + leafNodeCount);

	}

	private static int noOfLeaveNodesUsingRecursion(BinaryTreeNode<Integer> root, int leafNodeCount) {
		if (root == null) {
			return leafNodeCount;
		}
		if (root.getLeftNode() == null && root.getRightNode() == null) {
			leafNodeCount = leafNodeCount + 1;
		}
		leafNodeCount = noOfLeaveNodesUsingRecursion(root.getLeftNode(), leafNodeCount);
		leafNodeCount = noOfLeaveNodesUsingRecursion(root.getRightNode(), leafNodeCount);
		return leafNodeCount;
	}

	private static int noOfLeaveNodesUsingStack(BinaryTreeNode<Integer> root) {
		int leafNodeCount = 0;

		if (root == null) {
			return leafNodeCount;
		}

		Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
		stack.add(root);

		while (!stack.isEmpty()) {
			BinaryTreeNode<Integer> node = stack.pop();
			if (node.getLeftNode() == null && node.getRightNode() == null) {
				leafNodeCount = leafNodeCount + 1;
			}

			if (node.getLeftNode() != null) {
				stack.add(node.getLeftNode());
			}

			if (node.getRightNode() != null) {
				stack.add(node.getRightNode());
			}
		}
		return leafNodeCount;
	}

	private static int noOfLeaveNodesUsingQueue(BinaryTreeNode<Integer> root) {

		int leafNodeCount = 0;
		if (root == null) {
			return leafNodeCount;
		}

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();
			if (node.getLeftNode() == null && node.getRightNode() == null) {
				leafNodeCount = leafNodeCount + 1;
			}

			if (node.getLeftNode() != null) {
				queue.add(node.getLeftNode());
			}

			if (node.getRightNode() != null) {
				queue.add(node.getRightNode());
			}
		}
		return leafNodeCount;
	}

}
