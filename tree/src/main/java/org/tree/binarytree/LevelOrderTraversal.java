package org.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();

		levelOrderTraversal(binaryTree.getRoot());

	}

	private static void levelOrderTraversal(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();
			if (node.getLeftNode() != null)
				queue.add(node.getLeftNode());
			if (node.getRightNode() != null)
				queue.add(node.getRightNode());
			System.out.print(node.getData() + " ");
		}

	}
}
