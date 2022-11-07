import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> network = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            network.add(new ArrayList<Integer>());
        
        for(int i=0;i<wires.length;i++){
            network.get(wires[i][0]-1).add(wires[i][1]-1);
            network.get(wires[i][1]-1).add(wires[i][0]-1);
        }

        for(int i=0;i<wires.length;i++){
            int cnt=1;
            boolean [][] visited = new boolean[n][n];
            visited[wires[i][0]-1][wires[i][1]-1]=true;
            visited[wires[i][1]-1][wires[i][0]-1]=true;
            Queue <Integer> q = new LinkedList<>();
            q.offer(wires[i][0]-1);
            
            while(!q.isEmpty()){
                int p=q.poll();
                for(int j=0;j<network.get(p).size();j++){
                    if(!visited[p][network.get(p).get(j)]&&!visited[network.get(p).get(j)][p]){
                        q.offer(network.get(p).get(j));
                        visited[p][network.get(p).get(j)]=true;
                        visited[network.get(p).get(j)][p]=true;
                        cnt++;
                    }
                }
            }
            answer=Math.min(answer,Math.abs(cnt-(n-cnt)));
        }
        return answer;
    }
}
    