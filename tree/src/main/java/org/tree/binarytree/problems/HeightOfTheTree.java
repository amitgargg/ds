package org.tree.binarytree.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.tree.binarytree.BinaryTree;
import org.tree.binarytree.BinaryTreeNode;

/**
 * 
 * Give an algorithm for finding the height (or depth) of the binary tree.
 *
 * height = depth
 */

public class HeightOfTheTree {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		BinaryTreeNode<Integer> node4 = binaryTree.getRoot().getLeftNode().getLeftNode();

		BinaryTreeNode<Integer> node8 = new BinaryTreeNode<Integer>(8);
		node4.setLeftNode(node8);

//		BinaryTreeNode<Integer> node9 = new BinaryTreeNode<Integer>(9);
//		node8.setRightNode(node9);

		int heightOfTheTree = findHeightOfBinaryTree(binaryTree.getRoot());
		System.out.println("Height Of The Tree Using Recursion:" + heightOfTheTree);

		heightOfTheTree = heightOfBinaryTreeUsingStack(binaryTree.getRoot());
		System.out.println("Height Of The Tree Using Stack:" + heightOfTheTree);

		heightOfTheTree = heightOfBinaryTreeUsingRecusion(binaryTree.getRoot());
		System.out.println("Height Of The Tree Using Recursion:" + heightOfTheTree);

		heightOfTheTree = minimumHeightOfBinaryTreeUsingRecusion(binaryTree.getRoot());
		System.out.println("Minimum Height Of The Tree Using Recursion:" + heightOfTheTree);

	}

	private static int findHeightOfBinaryTree(BinaryTreeNode<Integer> root) {

		if (root != null) {
			int height = 0;
			int leftTreeHeight = findHeightOfBinaryTree(root.getLeftNode());
			int rightTreeHeight = findHeightOfBinaryTree(root.getRightNode());

			if (leftTreeHeight > rightTreeHeight) {
				height = leftTreeHeight + 1;
			} else {
				height = rightTreeHeight + 1;
			}
			return height;
		}

		return 0;
	}

	private static int heightOfBinaryTreeUsingStack(BinaryTreeNode<Integer> root) {

		BinaryTreeNode<Integer> curr = root;
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		int heightOfTree = 0;
		while (curr != null || !stack.isEmpty()) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.getLeftNode();
			} else {
				BinaryTreeNode<Integer> temp = stack.peek();
				if (temp.getRightNode() != null) {
					curr = temp.getRightNode();
				} else {
					if (heightOfTree < stack.size()) {
						heightOfTree = stack.size();
					}
					temp = stack.pop();
					while (!stack.isEmpty() && stack.peek().getRightNode() == temp) {
						temp = stack.pop();
					}
				}
			}
		}

		return heightOfTree;
	}

	private static int heightOfBinaryTreeUsingRecusion(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}

		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		int count = 1;

		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> currNode = q.poll();
			if (currNode != null) {

				if (currNode.getLeftNode() != null) {
					q.offer(currNode.getLeftNode());
				}

				if (currNode.getRightNode() != null) {
					q.offer(currNode.getRightNode());
				}
			} else {
				if (!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}

	private static int minimumHeightOfBinaryTreeUsingRecusion(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}

		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		int count = 1;

		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> currNode = q.poll();
			if (currNode != null) {

				if (currNode.getLeftNode() == null && currNode.getRightNode() == null) {
					return count;
				}

				if (currNode.getLeftNode() != null) {
					q.offer(currNode.getLeftNode());
				}

				if (currNode.getRightNode() != null) {
					q.offer(currNode.getRightNode());
				}
			} else {
				if (!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}
}
