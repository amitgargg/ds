package org.tree.binarytree;

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

	private BinaryTreeNode<Integer> createNode(Integer data) {
		BinaryTreeNode<Integer> treeNode = new BinaryTreeNode<>();
		treeNode.setData(data);
		return treeNode;
	}

	public BinaryTreeNode<Integer> getRoot() {
		return root;
	}

}
