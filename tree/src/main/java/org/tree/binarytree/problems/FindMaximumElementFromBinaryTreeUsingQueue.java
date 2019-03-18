package org.tree.binarytree.problems;

import java.util.LinkedList;
import java.util.Queue;

import org.tree.binarytree.BinaryTree;
import org.tree.binarytree.BinaryTreeNode;

/**
 * Problem-2 Give an algorithm for finding maximum element in binary tree without recursion
 **/

public class FindMaximumElementFromBinaryTreeUsingQueue {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();

		int max = findMaximumElementFromBinaryTree(binaryTree.getRoot());
		System.out.println(max);

	}

	private static Integer findMaximumElementFromBinaryTree(BinaryTreeNode<Integer> root) {
		Integer max = null;
		if (root != null) {

			Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {

				BinaryTreeNode<Integer> node = queue.poll();
				if (node.getLeftNode() != null)
					queue.add(node.getLeftNode());
				if (node.getRightNode() != null)
					queue.add(node.getRightNode());
				int data = node.getData();
				if (max == null || max < data) {
					max = data;
				}
			}

		}

		return max;

	}

}
