import java.io.*;
import java.util.LinkedList;

public class Graph {
	
	LinkedList<Integer>[] arr;
	int N;
	
	public Graph(int n) {
		N = n;
		arr = new LinkedList[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dest) {
		arr[src].addFirst(dest);
	}
	
	public void printGraph() {
		for(int i=0; i<N; i++) {
			for(Integer j : arr[i]) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	public void DFS() {
		boolean[] visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			if(!visited[i])
				DFS_help(visited,i);
		}
	}
	
	void DFS_help(boolean[] visited, int a) {
		if(!visited[a]) {
			visited[a] = true;
			System.out.println(a);
			for(Integer i: arr[a]) {
				if(!visited[i])
					DFS_help(visited,i);
			}
		}
	}
	
	public void BFS() {
		boolean[] visited = new boolean[N];
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i=0; i<N;i++) {
			if(!visited[i])
			{
				visited[i] = true;
				queue.addFirst(i);  
				BFS_help(visited,queue,i);
			}
		}
	}
	
	public void BFS_help(boolean[] visited, LinkedList<Integer> queue, int a) {
		while(!queue.isEmpty()) {
			int front = queue.removeLast();
			System.out.println(front);
			for(int i: arr[front]) {
				if(!visited[i]) {
					queue.addFirst(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 6);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 6);
		g.printGraph();
		g.DFS();
		System.out.println();
		g.BFS();
	}
	
}
