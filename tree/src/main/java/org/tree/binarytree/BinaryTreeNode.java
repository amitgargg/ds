package org.tree.binarytree;

public class BinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode<T> leftNode;
	private BinaryTreeNode<T> rightNode;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryTreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return data.toString();
	}

}
