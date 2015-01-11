import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	int v;
	ArrayList<LinkedList<Integer>> adjList ; 
	int root;
	boolean visited[];
	Stack<Integer> s = new Stack<Integer>();
	
	
	public Graph(int n, int k) {
		v = n;
		root = k;
		visited = new boolean[n];
		adjList = new ArrayList<LinkedList<Integer>> ();
		adjList.add(null);
		s = new Stack<Integer>();
		s.add(root);	
	}
	
	public void addList(int list[]) {
			
		LinkedList<Integer> temp = new LinkedList<Integer>();
		for(int i = 0; i < list.length; ++i) {
			temp.add(list[i]);
		}
		adjList.add(temp);			
	}
	
	public LinkedList<Integer> getChildNodes(int i) {
		if(i < adjList.size()) 
			return adjList.get(i);
		return null;
	}
	
	public void DFS() {
			if(s.isEmpty()) {
				return;
			}
			int k = s.pop();
			System.out.println(k);
			LinkedList<Integer> temp = getChildNodes(k);
			if(temp != null) {
				visited[k] = true;			
				for(int i = 0; i < temp.size(); ++i) {
					if(visited[temp.get(i)] != true)
						s.add(temp.get(i));
					DFS();
				}
			}		
	}

	public void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(root);
		while(!q.isEmpty()){
			int k = q.remove();
			LinkedList<Integer> temp = getChildNodes(k);
			
			if(temp != null && visited[k] != true) {
				visited[k] = true;
				System.out.println(k);
				for(int i = 0; i < temp.size(); ++i) {
					q.add(temp.get(i));
				}
			}
		}
		clearVisited();
	}
	
	public boolean findPath(int n1, int n2) {
		Queue<Integer> q = new LinkedList<Integer>();	
		q.add(n1);
		
		while(!q.isEmpty()){
			int k = q.remove();
			if(k == n2) {
				return true;
			}
			LinkedList<Integer> temp = getChildNodes(k);
			
			if(temp != null && visited[k] != true) {
				visited[k] = true;
				System.out.println(k);
				for(int i = 0; i < temp.size(); ++i) {
					q.add(temp.get(i));
					
				}
			}
		}
		clearVisited();
		return false;
	}
	
	public void clearVisited(){
		visited = new boolean[v];
	}
	
	public static void main(String args[]) {
	
		Graph g = new Graph(7, 1);
		int a[] = {2, 3, 4};
		int b[] = { 1, 5, 6};
		int c[] = {1, 6};
		int d[] = {1};
		int e[] = {2};
		g.addList(a);
		g.addList(b);
		g.addList(c);
		g.addList(d);
		g.addList(e);
		g.addList(e);
		System.out.println("BFS Traversal: \n");
		g.BFS();
		System.out.println("DFS Traversal: \n");
		g.DFS();
		g.clearVisited();
		System.out.println(g.findPath(5, 6));

	}

}