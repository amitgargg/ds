package org.tree.binarytree.problems;

import java.util.LinkedList;
import java.util.Queue;

import org.tree.binarytree.BinaryTree;
import org.tree.binarytree.BinaryTreeNode;
import org.tree.binarytree.LevelOrderTraversal;

/**
 * 
 * Give an algorithm for inserting an element into binary tree.
 *
 */

public class InsertElementBTree {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();

		LevelOrderTraversal.levelOrderTraversal(binaryTree.getRoot());
		System.out.println();
		insertElementBTree(binaryTree.getRoot(), 8);
		insertElementBTree(binaryTree.getRoot(), 9);
		insertElementBTree(binaryTree.getRoot(), 10);
		insertElementBTree(binaryTree.getRoot(), 11);
		insertElementBTree(binaryTree.getRoot(), 12);
		insertElementBTree(binaryTree.getRoot(), 13);
		LevelOrderTraversal.levelOrderTraversal(binaryTree.getRoot());

	}

	public static void insertElementBTree(BinaryTreeNode<Integer> root, int insertData) {

		if (root != null) {
			Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
			queue.offer(root);
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(insertData);

			while (!queue.isEmpty()) {
				BinaryTreeNode<Integer> node = queue.poll();
				if (node.getLeftNode() == null) {
					node.setLeftNode(newNode);
					break;
				} else if (node.getRightNode() == null) {
					node.setRightNode(newNode);
					break;
				} else {
					queue.offer(node.getLeftNode());
					queue.offer(node.getRightNode());
				}

			}

		}
	}
}
