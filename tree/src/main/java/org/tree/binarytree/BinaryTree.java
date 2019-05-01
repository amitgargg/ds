package org.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	private BinaryTreeNode<Integer> root;

	public void createBinaryTree() {
		root = createNode(1);
		root.setLeftNode(createNode(2));
		root.setRightNode(createNode(3));

		root.getLeftNode().setLeftNode(createNode(4));
		root.getLeftNode().setRightNode(createNode(5));

		root.getRightNode().setLeftNode(createNode(6));
		root.getRightNode().setRightNode(createNode(7));
	}

	public void insertElementBTree(BinaryTreeNode<Integer> root, int insertData) {

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

	private BinaryTreeNode<Integer> createNode(Integer data) {
		BinaryTreeNode<Integer> treeNode = new BinaryTreeNode<>();
		treeNode.setData(data);
		return treeNode;
	}

	public BinaryTreeNode<Integer> getRoot() {
		return root;
	}

}
