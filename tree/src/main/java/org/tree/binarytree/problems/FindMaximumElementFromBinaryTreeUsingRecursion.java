package org.tree.binarytree.problems;

import org.tree.binarytree.BinaryTree;
import org.tree.binarytree.BinaryTreeNode;

/**
 * Problem-1 Give an algorithm for finding maximum element in binary tree.
 **/

public class FindMaximumElementFromBinaryTreeUsingRecursion {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();

		int max = findMaximumElementFromBinaryTree(binaryTree.getRoot());
		System.out.println(max);

	}

	private static int findMaximumElementFromBinaryTree(BinaryTreeNode<Integer> root) {
		int max = Integer.MIN_VALUE;
		if (root != null) {
			int leftMax = findMaximumElementFromBinaryTree(root.getLeftNode());
			int rightMax = findMaximumElementFromBinaryTree(root.getRightNode());
			if (leftMax > rightMax) {
				max = leftMax;
			} else {
				max = rightMax;
			}

			if (max < root.getData()) {
				max = root.getData();
			}
		}
		return max;
	}

}
