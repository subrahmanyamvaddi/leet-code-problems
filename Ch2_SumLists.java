import java.io.*;

public class Ch2_SumLists {
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
	
	public LLNode sumList(LLNode head1, LLNode head2) {
		int carry = 0;
		LLNode p = head1, q = head2;
		LLNode head3 = null;
		while(q != null && p != null) {
			int sum = (q.val + p.val + carry) % 10;
			carry = (q.val + p.val + carry)/10;
			LLNode nn = new LLNode();
			nn.val = sum;
			nn.next = null;
			if(head3 == null)
				head3 = nn;
			else
			{
				nn.next = head3;
				head3 = nn;
			}
			p = p.next;
			q = q.next;
		}
		
		while(p != null) {
			int sum = (p.val + carry) % 10;
			carry = (p.val + carry)/10;
			LLNode nn = new LLNode();
			nn.val = sum;
			nn.next = null;
			if(head3 == null)
				head3 = nn;
			else
			{
				nn.next = head3;
				head3 = nn;
			}
			p = p.next;
		}
		
		while(q != null) {
			int sum = (q.val + carry) % 10;
			carry = (q.val + carry)/10;
			LLNode nn = new LLNode();
			nn.val = sum;
			nn.next = null;
			if(head3 == null)
				head3 = nn;
			else
			{
				nn.next = head3;
				head3 = nn;
			}
			q = q.next;
		}
		
		if(carry != 0) {
			LLNode nn = new LLNode();
			nn.val = carry;
			nn.next = null;
			if(head3 == null)
				head3 = nn;
			else
			{
				nn.next = head3;
				head3 = nn;
			}
		}
		
		return head3;
		
	}
	
	public void printNode(LLNode head) {
		LLNode p = head;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	
	public static void main(String[] args) {
		Ch2_SumLists dp = new Ch2_SumLists();
		LLNode head = null;
		head = dp.insertNode(head, 7);
		
		LLNode head2 = null;
		head2 = dp.insertNode(head2, 9);
		head2 = dp.insertNode(head2, 9);
		head2 = dp.insertNode(head2, 3);
		dp.printNode(dp.sumList(head, head2));
	}
}
