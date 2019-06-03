package org.tree.binarytree.problems;

import org.tree.binarytree.BinaryTree;
import org.tree.binarytree.BinaryTreeNode;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.createBinaryTree();

		System.out.println(diameterOfTheTree(tree.getRoot()));
	}

	private static int diameterOfTheTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = heightOfTheTree(root.getLeftNode());
		int rightHeight = heightOfTheTree(root.getRightNode());
		int leftDiameter = diameterOfTheTree(root.getLeftNode());
		int rightDiameter = diameterOfTheTree(root.getRightNode());
		int totalHeight = leftHeight + rightHeight + 1;
		int maxDiameter = Math.max(leftDiameter, rightDiameter);
		return Math.max(totalHeight, maxDiameter) + 1;

	}

	private static int heightOfTheTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = heightOfTheTree(root.getLeftNode());
		int rightHeight = heightOfTheTree(root.getRightNode());
		return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
	}

}
