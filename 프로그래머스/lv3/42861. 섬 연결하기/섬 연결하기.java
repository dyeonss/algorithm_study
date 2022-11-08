import java.util.*;
class Solution {
    static class Edge implements Comparable<Edge>{
        int w;
        int cost;
        public Edge(int w, int cost){
            this.w=w;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(Edge o){
            return this.cost-o.cost;
        }    
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int cnt=1;
        ArrayList<ArrayList<int[]>> island = new ArrayList<>();
        boolean [] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue();
        
        for(int i=0;i<n;i++){
            island.add(new ArrayList<int []>());
        }
        for(int i=0;i<costs.length;i++){
            island.get(costs[i][0]).add(new int[]{ costs[i][1], costs[i][2]});
            island.get(costs[i][1]).add(new int[]{ costs[i][0], costs[i][2]});
        }
        
        int v=costs[0][0];
        visited[v]=true;
        for(int i=0;i<island.get(v).size();i++){
            pq.offer(new Edge(island.get(v).get(i)[0],island.get(v).get(i)[1]));
        }
   
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(!visited[e.w]){
                visited[e.w]=true;
                answer+=e.cost;
                v=e.w;
                for(int i=0;i<island.get(v).size();i++){
                    if(!visited[island.get(v).get(i)[0]]){
                        pq.offer(new Edge(island.get(v).get(i)[0],island.get(v).get(i)[1]));    
                    }
                }
            }
        }
        
        return answer;
    }
}