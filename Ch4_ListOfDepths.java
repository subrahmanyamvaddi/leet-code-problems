import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Ch4_ListOfDepths {
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
	
	public ArrayList<LinkedList> depthLists(Node tree) {
		ArrayList<LinkedList> ret = new ArrayList<>();
		
		LinkedList<Node> queue = new LinkedList<>();
		int n = 1;
		queue.addFirst(tree);
		while(!queue.isEmpty()) {
			ret.add((LinkedList<Integer>)queue.clone());
			while(n > 0) {
				Node front = queue.removeLast();
				if(front.left != null)
					queue.addFirst(front.left);
				
				if(front.right != null)
					queue.addFirst(front.right);
				n--;
			}
			n = queue.size();
		}
		
		return ret;
	}

	public static void main(String[] args) {
		int[] arr = new int[7];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		Ch4_ListOfDepths tree = new Ch4_ListOfDepths();
		Node root = tree.makeBST(arr);
		tree.printBST(root);
		ArrayList<LinkedList> lists = tree.depthLists(root);
		System.out.println();
		for(LinkedList<Node> i : lists) {
			for(Node j: i) {
				System.out.print(j.val + " ");
			}
			System.out.println();
		}
		
	}
}
