import java.io.*;
import java.lang.Math;
public class Ch4_CheckBalanced {
	public class Node{
		int val;
		Node left, right;
		public Node(int data) {
			val = data;
			left = null;
			right = null;
		}
	}
	
	public Node makeNode(int val) {
		Node nn = new Node(val);
		return nn;
	}
	
	public boolean isBalanced(Node root) {
		if(root == null)
			return true;
		if(Math.abs(height(root.left)-height(root.right)) > 1)
				return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public int height(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		else
			return max(height(root.left), height(root.right)) + 1;
	}
	
	private int max(int height, int height2) {
		if(height > height2)
			return height;
		else
			return height2;
	}

	public void printBST(Node root) {
		if(root != null) {
			printBST(root.left);
			System.out.print(root.val + " ");
			printBST(root.right);
		}
	}
	
	public boolean isBST(Node root) {
		return isBST_help(root,null,null);
	}
	
	public boolean isBST_help(Node root, Integer min, Integer max) {
		if(root == null)
			return true;
		
		if(min != null && root.val < min || max != null && root.val > max)
			return false;
		
		return isBST_help(root.left, min, root.val) && isBST_help(root.right,root.val,max);
	}

	public static void main(String[] args) {
		Ch4_CheckBalanced tree = new Ch4_CheckBalanced();
		Node root = tree.makeNode(10);
		root.left = tree.makeNode(9);
		root.left.left = tree.makeNode(6);
		root.left.left.right = tree.makeNode(15);
		root.right = tree.makeNode(15);
		System.out.println(tree.isBST(root));
	}
}
