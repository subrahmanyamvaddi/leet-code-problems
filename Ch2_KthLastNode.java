import java.util.HashSet;
import java.io.*;

public class Ch2_KthLastNode {

	public class LLNode{
		int val;
		LLNode next;
	}
	
	public LLNode insertNode(LLNode head, int data) {
		LLNode nn = new LLNode();
		nn.val = data;
		nn.next = null;
		if(head == null)
		{
			head = nn;
			return head;
		}
		else
		{
			nn.next = head;
			head = nn;
			return head;
		}
	}
	
	public LLNode kthLast(LLNode head, int k) {
		LLNode p = head;
		int n = 0;
		while(p != null) {
			p = p.next;
			n++;
		}
		if(k > n)
			return null;
		p = head;
		n = n-k;
		int i=0;
		while(true) {
			if(i == n)
				return p;
			p = p.next;
			i++;
		}
	}
	
	public void printNode(LLNode head) {
		LLNode p = head;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	
	public static void main(String[] args) {
		Ch2_KthLastNode dp = new Ch2_KthLastNode();
		LLNode head = null;
		head = dp.insertNode(head, 10);
		head = dp.insertNode(head, 20);
		head = dp.insertNode(head, 30);
		head = dp.insertNode(head, 10);
		head = dp.insertNode(head, 30);
		head = dp.insertNode(head, 20);
		dp.printNode(head);
		System.out.println(dp.kthLast(head,3).val);
	}
	
}
