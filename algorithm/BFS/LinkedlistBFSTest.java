package study;

import java.util.LinkedList;
import java.util.Queue;

class Graph{
	public int v;	//노드의 개수
	public LinkedList <Integer>[] adj;	//인접리스트 
	public Graph(int v) {
		this.v = v;
		adj=new LinkedList[v];
		
		for (int i = 0; i < v; i++) {
			adj[i]=new LinkedList<>();
		}
	}
	void add(int v, int w) {
		adj[v].add(w);
	}
}
public class LinkedlistBFSTest {

	public static void main(String[] args) {
		Graph g= new Graph(4);
		
		g.add(0, 1);
		g.add(0, 2);
		g.add(1, 2);
		g.add(2, 0);
		g.add(2, 3);
		g.add(3, 3);
		
		bfs(g,2);
	}

	private static void bfs(Graph g, int i) {
		boolean [] visited = new boolean[g.v];
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(i);
		visited[i]=true;
		
		while(!q.isEmpty()) {
			int idx=q.poll();
			System.out.println(idx+" ");
			
			for (int j = 0; j < g.adj[idx].size(); j++) {
				if(!visited[g.adj[idx].get(j)]) {
					visited[g.adj[idx].get(j)]=true;
					q.offer(g.adj[idx].get(j));
				}
			}
		}
	}
}
