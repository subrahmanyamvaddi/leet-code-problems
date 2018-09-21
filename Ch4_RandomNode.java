import java.io.*;
import java.util.Random;


public class Ch4_RandomNode {
	public class Node{
		int val;
		int size;
		Node left, right;
		public Node(int data) {
			val = data;
			left = null;
			right = null;
			size = 0;
		}
	}
	
	public Node insertNode(Node root,int data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}
		if(root.val < data)
			root.right = insertNode(root.right,data);
		else
			root.left = insertNode(root.left,data);
		
		root.size++;
		return root;
	}
	
	public Node randomNode(Node root) {
		if(root == null)
			return null;
		Random r = new Random();
		//System.out.println(root.size);
		int index = root.size == 0 ? 0 :r.nextInt(root.size);
		int leftsize = root.left == null ? 0 : root.left.size;
		if(index < leftsize)
			return randomNode(root.left);
		else if(index == leftsize)
			return root;
		else
			return randomNode(root.right);
			
	}
	
	public static void main(String[] args) {
		Ch4_RandomNode tree = new Ch4_RandomNode();
		Node root = tree.insertNode(null, 10);
		root = tree.insertNode(root, 15);
		root = tree.insertNode(root, 13);
		root = tree.insertNode(root, 17);
		root = tree.insertNode(root, 7);
		root = tree.insertNode(root, 9);
		root = tree.insertNode(root, 5);
		System.out.println(tree.randomNode(root).val);
	}
	
}
