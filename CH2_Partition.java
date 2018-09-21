import java.io.*;


public class CH2_Partition {
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
	
	public void partition(LLNode head, int k) {
		if(head == null)
			return;
		LLNode cur = null, p = head;
		while(p != null) {
			
			while(p != null && p.val>=k)
			{
				p = p.next;
			}
			if(p != null) {
				if(cur == null)
				{
					cur = new LLNode();
					cur.val = p.val;
					cur.next = p.next;
					p = p.next;
				}
				else
				{
					cur = cur.next;
					int temp = cur.val;
					cur.val = p.val;
					p.val = temp;
					p = p.next;
					
				}
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
		CH2_Partition dp = new CH2_Partition();
		LLNode head = null;
		head = dp.insertNode(head, 1);
		head = dp.insertNode(head, 2);
		head = dp.insertNode(head, 10);
		head = dp.insertNode(head, 5);
		head = dp.insertNode(head, 8);
		head = dp.insertNode(head, 5);
		head = dp.insertNode(head, 3);
		dp.printNode(head);
		dp.partition(head,5);
		dp.printNode(head);
	}
}
