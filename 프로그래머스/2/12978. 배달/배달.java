import java.util.*;
class Solution {
    public class Node{
        int n,v,d;
        public Node(int n, int v, int d){
            this.n=n;
            this.v=v;
            this.d=d;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<ArrayList<Node>> conn=new ArrayList<>();
        int[] dist=new int[N+1];
        
        for(int i=0;i<N+1;i++)    conn.add(new ArrayList<>());
        
        for(int i=0;i<road.length;i++){
            conn.get(road[i][0]).add(new Node(road[i][0],road[i][1],road[i][2]));
            conn.get(road[i][1]).add(new Node(road[i][1],road[i][0],road[i][2]));
        }
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        
        PriorityQueue<Node> pq=new PriorityQueue<>((o1,o2)->{return o1.d-o2.d;});
        
        pq.addAll(conn.get(1));
        
        while(!pq.isEmpty()){
            Node n=pq.poll();
            if(n.d+dist[n.n]>dist[n.v]) continue;
            dist[n.v]=n.d+dist[n.n];
            pq.addAll(conn.get(n.v));
        }
        
        for(int i=1;i<N+1;i++){
            if(dist[i]<=K)  answer++;
        }
        return answer;
    }
}