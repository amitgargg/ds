package org.tree.binarytree.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.tree.binarytree.BinaryTree;
import org.tree.binarytree.BinaryTreeNode;

/**
 * 
 * Give an algorithm for printing the level order data in reverse order. For
 * example,the output for the below tree should be: 4 5 6 7 2 3 1
 *
 */

public class LevelOrderReverseTraversal {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();

		levelOrderReverseTraversal(binaryTree.getRoot());

	}

	private static void levelOrderReverseTraversal(BinaryTreeNode<Integer> root) {
		if (root != null) {
			Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
			Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode<Integer> node = queue.poll();
				if (node.getRightNode() != null) {
					queue.offer(node.getRightNode());
				}
				if (node.getLeftNode() != null) {
					queue.offer(node.getLeftNode());
				}
				stack.add(node);
			}

			while (!stack.isEmpty())
				System.out.print(stack.pop().getData() + " ");
		}

	}
}
