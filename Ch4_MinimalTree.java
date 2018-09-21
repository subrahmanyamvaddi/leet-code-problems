import java.io.*;


public class Ch4_MinimalTree {
	public class Node{
		int val;
		Node left, right;
		public Node(int data) {
			val = data;
			left = null;
			right = null;
		}
	}
	
	public Node makeBST(int[] arr) {
		return makeBST_help(arr,0,arr.length-1);
	}
	
	private Node makeBST_help(int[] arr, int l, int h) {
		if(l<=h) {
			if(l==h) {
				return new Node(arr[l]);
			}
			int mid = (l+h)/2;
			Node root = new Node(arr[mid]);
			root.left = makeBST_help(arr,l,mid-1);
			root.right = makeBST_help(arr,mid+1,h);
			
			return root;
		}
		else
			return null;
	}
	
	public void printBST(Node root) {
		if(root != null) {
			printBST(root.left);
			System.out.print(root.val + " ");
			printBST(root.right);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[6];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
		Ch4_MinimalTree tree = new Ch4_MinimalTree();
		Node root = tree.makeBST(arr);
		tree.printBST(root);
		
	}
}
