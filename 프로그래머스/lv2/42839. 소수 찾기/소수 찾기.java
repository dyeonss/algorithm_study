import java.util.*;
class Solution {
    public int answer = 0;
    public char[] nums;
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        nums = numbers.toCharArray();
        boolean[] visited = new boolean[nums.length];
       
        for(int i=1;i<=nums.length;i++){
            dfs(visited, 0, i, "");
        }
 
        return set.size();
    }
    public void dfs(boolean[] visited, int cnt, int n, String str){
        if(cnt==n){
            boolean flag = true;
            int prime = Integer.valueOf(str);
            if(prime<=1) return;
            for(int j=2;j<=Math.sqrt(prime);j++){
                if(prime%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                set.add(prime);
            }
            return;
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(visited,cnt+1,n,str+nums[i]);
                visited[i]=false;
            }
        }
    }
}