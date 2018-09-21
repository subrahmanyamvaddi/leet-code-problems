import java.io.*;

public class Ch4_PathswithSum {
	public class Node{
		int val;
		Node left, right;
		public Node(int data) {
			val = data;
			left = null;
			right = null;
		}
	}
	
	public class returnval{
		Integer count ;
		public returnval() {
			count = 0;
		}
	}
	
	public returnval makeretval() {
		return new returnval();
	}
	
	public Node makeNode(int val) {
		Node nn = new Node(val);
		return nn;
	}
	
	public void pathSum(Node root, returnval count, int cur, Integer target) {
		System.out.println(cur);
		if(root == null)
			return;
		if(root.val + cur == target)
			count.count++;
		pathSum(root.left,count,cur+root.val,target);
		pathSum(root.right,count,cur+root.val,target);
		pathSum(root.left,count,cur,target);
		pathSum(root.right,count,cur,target);
		
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

	public static void main(String[] args) {
		Ch4_PathswithSum tree = new Ch4_PathswithSum();
		Node root = tree.makeNode(10);
		root.left = tree.makeNode(5);
		root.left.left = tree.makeNode(3);
		root.left.left.left = tree.makeNode(3);
		root.left.left.right = tree.makeNode(-2);
		root.left.right = tree.makeNode(2);
		root.left.right.right = tree.makeNode(1);
		root.right = tree.makeNode(-3);
		root.right.right = tree.makeNode(11);
		returnval ret = tree.makeretval();
		tree.pathSum(root, ret, 0, 8);
		System.out.println(ret.count);
	}
}
