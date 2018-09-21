import java.io.*;
import java.util.Stack;

public class Ch3_QueueWithStacks<T>{
	Stack<T> s1,s2;
	
	public Ch3_QueueWithStacks(){
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public void push(T a) {
		s1.push(a);
	}
	
	public T pop() {
		if(!s2.empty()) {
			return s2.pop();
		}
		else {
			while(!s1.empty()) {
				T a = s1.pop();
				s2.push(a);
			}
			return s2.pop();
		}
	}
	
	public T peek() {
		if(!s2.empty())
			return s2.peek();
		else
		{
			while(!s1.empty()) {
				s2.push(s1.pop());
			}
			return s2.peek();
		}
	}
	
	public int size() {
		return s1.size() + s2.size();
	}
	
	public static void main(String[] args) {
		Ch3_QueueWithStacks<Integer> q = new Ch3_QueueWithStacks<Integer>();
		q.push(5);
		q.push(10);
		q.push(15);
		System.out.println(q.peek());
		System.out.println(q.pop());
		System.out.println(q.pop());
		q.push(4);
		q.push(11);

		System.out.println(q.pop());
		q.push(17);
		q.push(3);
		System.out.println(q.peek());
	}
	
}
