import java.io.*;
import java.util.HashSet;



public class Ch2_RemoveDups {
	
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
	
	public void removeDups(LLNode head) {
		HashSet<Integer> set = new HashSet<>();
		LLNode prev = null, cur = head;
		while(cur != null) {
			if(set.contains(cur.val)){
				prev.next = cur.next;
				cur = prev.next;
			}
			else {
				set.add(cur.val);
				prev = cur;
				cur = cur.next;
			}
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
		Ch2_RemoveDups dp = new Ch2_RemoveDups();
		LLNode head = null;
		head = dp.insertNode(head, 10);
		head = dp.insertNode(head, 20);
		head = dp.insertNode(head, 30);
		head = dp.insertNode(head, 10);
		head = dp.insertNode(head, 30);
		head = dp.insertNode(head, 20);
		dp.printNode(head);
		dp.removeDups(head);
		dp.printNode(head);
	}
}
