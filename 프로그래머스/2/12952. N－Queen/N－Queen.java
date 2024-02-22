import java.util.*;
class Solution {
    static int[] arr;
    static boolean[] visited;
    static int answer=0;
    public int solution(int n) {
        arr=new int[n];
        visited=new boolean[n];
        dfs(n,0);
        return answer;
    }
    public void dfs(int n, int cnt){
        if(cnt==n){
            answer++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                arr[cnt]=i;
                visited[i]=true;
                if(queen(cnt))
                    dfs(n,cnt+1);
                visited[i]=false;
            }
        }
    }
    public boolean queen(int n){
        for(int i=0;i<n;i++){
            if(Math.abs(n-i)==Math.abs(arr[n]-arr[i]))  return false;
        }
        
        return true;
    }
}