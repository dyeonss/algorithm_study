import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int w;
		
		public Edge(int v1, int v2, int w) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static int V,E;
	static int[] parent;
	static PriorityQueue<Edge> queue; // 간선 정보 저장
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> queue=new PriorityQueue<>();
		parent=new int[V+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int v1=Integer.parseInt(st.nextToken());
			int v2=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			queue.add(new Edge(v1, v2, w));
		}

		for (int i = 0; i < V+1; i++) {
			parent[i]=i;
		}
		
    	int weight = 0;
        while(!queue.isEmpty()) {
            Edge cur = queue.poll(); 
            if(find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                weight += cur.w;
            }
        }
        
        System.out.println(weight);
    	
    }   
    
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }
    
    public static int find(int n) {
        if(parent[n] == n) {
        	return n;
        }   
        return parent[n] = find(parent[n]);
    }
}