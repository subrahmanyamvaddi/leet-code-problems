import java.io.*;
import java.util.Stack;

public class Ch3_StackMin extends Stack<Integer> {
	Stack<Integer> s2;
	
	public Ch3_StackMin() {
		s2 = new Stack<Integer>();
	}
	
	public void push(int a) {
		if(s2.empty()) {
			s2.push(a);
		}else {
			int top = s2.peek();
			if(a < top )
				s2.push(a);
		}
		super.push(a);
	}
	
	public int min() {
		if(s2.empty())
			return Integer.MAX_VALUE;
		else
			return s2.peek();
	}
	
	public Integer pop() {
		int a = super.peek();
		int min = s2.peek();
		if(a == min)
			s2.pop();
		return super.pop();
	}
	
	public static void main(String[] args) {
		Ch3_StackMin st = new Ch3_StackMin();
		st.push(5);
		st.push(10);
		st.push(15);
		st.push(4);
		st.push(11);
		st.push(17);
		st.push(3);
		
		System.out.println(st.pop());
		System.out.println(st.min());
		
		System.out.println(st.pop());
		System.out.println(st.min());
		
		System.out.println(st.pop());
		System.out.println(st.min());
		
		System.out.println(st.pop());
		System.out.println(st.min());
		
		System.out.println(st.pop());
		System.out.println(st.min());
	}
	
}
