import java.util.*;
class Solution {
    static int[] answer;
    static int[] in;
    static boolean[] visited;
    public int[] solution(int[][] edges) {
        answer = new int[4];
        List<ArrayList<Integer>> graph=new ArrayList<>();
        int n=0, vertex=0;
        
        for(int i=0;i<edges.length;i++)
            n=Math.max(n,Math.max(edges[i][0],edges[i][1]));
        
        in=new int[n+1];
        visited=new boolean[n+1];
        
        for(int i=0;i<n+1;i++)
            graph.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            in[edges[i][1]]++;
        }
        
        for(int i=1;i<n+1;i++){
            if(graph.get(i).size()>=2&&in[i]==0){
                visited[i]=true;
                vertex=i;
                answer[0]=vertex;
                break;
            }
        }
        
        for(int i=1;i<graph.size();i++){
            if(i==vertex)   continue;
            findStick(i, graph);
            findEight(i, graph);
        }
        
        answer[1]=graph.get(vertex).size()-(answer[2]+answer[3]);
        
        return answer;
    }
    public void findStick(int idx, List<ArrayList<Integer>> graph){
        if(!visited[idx]&&graph.get(idx).size()==0&&in[idx]>0){
            visited[idx]=true;
            answer[2]++;
        }
        return;
    }
    public void findEight(int idx, List<ArrayList<Integer>> graph){
        if(!visited[idx]&&graph.get(idx).size()==2&&in[idx]>=2){
            visited[idx]=true;
            answer[3]++;
        }
        return;
    }
}