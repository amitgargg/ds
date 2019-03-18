package org.tree.binarytree.problems;

import org.tree.binarytree.BinaryTree;
import org.tree.binarytree.BinaryTreeNode;

public class BinaryTreeDataSearch {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();

		boolean data = binaryTreeDataSearchRecursive(binaryTree.getRoot(), 5);
		System.out.println(data);

	}

	private static boolean binaryTreeDataSearch(BinaryTreeNode<Integer> root, int searchData) {

		if (root != null && (root.getData() == searchData || binaryTreeDataSearch(root.getLeftNode(), searchData)
				|| binaryTreeDataSearch(root.getRightNode(), searchData))) {
			return true;
		}
		return false;
	}

	private static boolean binaryTreeDataSearchRecursive(BinaryTreeNode<Integer> root, int searchData) {
		if (root == null) {
			return false;
		}
		System.out.println(root.getData());
		if (root.getData() == searchData) {
			return true;
		}
		return binaryTreeDataSearchRecursive(root.getLeftNode(), searchData)
				|| binaryTreeDataSearchRecursive(root.getRightNode(), searchData);
	}
}
