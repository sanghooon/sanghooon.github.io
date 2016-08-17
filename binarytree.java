//Binary Node class
public class BinaryNode {
	int data;
	BinaryNode left;
	BinaryNode right;
	
	BinaryNode(int data, BinaryNode left, BinaryNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	BinaryNode(int data) {
		this(data, null, null);
	}
	
	BinaryNode() {
		this(0);
	}
	
	static int countNodes(BinaryNode root) {
		if(root == null) return 0;
		else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}
	
	static int height(BinaryNode n) {
		if(n == null) return -1;
		else
			return 1 + Math.max(height(n.left), height(n.right));
	}
}

//Binary Tree class
public class BinaryTree {
	private BinaryNode root;
	
	public BinaryTree(int data) {
		root = new BinaryNode(data);
	}
	
	public BinaryTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public int nodeCount() {
		return BinaryNode.countNodes(root);
	}
	
	public int height() {
		return BinaryNode.height(root);
	}
	
	public int getRoot() throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty tree");
		else
			return root.data;
	}
	
	public BinaryTree getLeft() throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty tree");
		else {
			BinaryTree t = new BinaryTree();
			t.root = root.left;
			return t;
		}
	}
	public BinaryTree getRight() throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty tree");
		else {
			BinaryTree t = new BinaryTree();
			t.root = root.right;
			return t;
		}
	}
	
	public void setLeft(BinaryTree t) throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty tree");
		else
			root.left = t.root;
	}
	
	public void setRight(BinaryTree t) throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty tree");
		else
			root.right = t.root;
	}
	public void setRoot(int x) throws BinaryTreeException {
		if(root == null) throw new BinaryTreeException("Empty tree");
		else
			root.data = x;
	}
	
	public static void inorder(BinaryTree t) throws BinaryTreeException {
		if(!t.isEmpty()) {
			inorder(t.getLeft());
			System.out.println(t.getRoot());
			inorder(t.getRight());
		}
	}
	
	public static int sum(BinaryTree t) throws BinaryTreeException {
		if(t.isEmpty()) return 0;
		else
			return(t.getRoot() + sum(t.getLeft()) + sum(t.getRight()));
	}
	
	public class BinaryTreeException extends RuntimeException {
		public BinaryTreeException(String err) {
			super(err);
		}
	}
}

//Main to test
import java.io.*;
import java.util.*;

public class treetest {
	public static void main(String[] args) {
			
		BinaryTree lt = new BinaryTree(12);
		BinaryTree rt = new BinaryTree(-4);
		BinaryTree t = new BinaryTree(23);
		t.setLeft(lt);
		t.setRight(rt);
		System.out.print("Node count: " +t.nodeCount());
		System.out.println(" Height: " +t.height());
		BinaryTree p = new BinaryTree(19);
		p.setLeft(t);
		System.out.print("Node count: " +p.nodeCount());
		System.out.println(" Height: " +p.height());
		p.inorder(p);
		System.out.println("Sum: " +p.sum(p));
	}
}
