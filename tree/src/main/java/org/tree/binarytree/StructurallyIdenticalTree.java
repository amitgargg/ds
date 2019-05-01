package org.tree.binarytree;

/**
 * 
 * @author egraiam
 *	Given two binary trees, return true if they are structurally identical.
 *
 */

public class StructurallyIdenticalTree {

	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();
		tree1.createBinaryTree();

		BinaryTree tree2 = new BinaryTree();
		tree2.createBinaryTree();
//		tree2.getRoot().getLeftNode().getLeftNode().setRightNode(new BinaryTreeNode<Integer>(10));

		System.out.println(checkStructurallyIdenticalTree(tree1.getRoot(), tree2.getRoot()));

	}

	private static boolean checkStructurallyIdenticalTree(BinaryTreeNode<Integer> node1,
			BinaryTreeNode<Integer> node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if (node1 == null || node2 == null) {
			return false;
		}

		return checkStructurallyIdenticalTree(node1.getRightNode(), node2.getRightNode())
				&& checkStructurallyIdenticalTree(node1.getLeftNode(), node2.getLeftNode());
	}

}
