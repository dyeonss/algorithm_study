import java.util.*;
class Solution {
    public static String[] friends={"A", "C", "F", "J", "M", "N", "R", "T"};
    public static int answer;
    public int solution(int n, String[] data) {
        String str="";
        boolean[] visited=new boolean[8];
        answer=0;
        dfs(0, str, visited, data);
        return answer;
    }
    public void dfs(int depth, String str, boolean[] visited, String[] data){
        if(depth==8){
            if(check(str, data)){
                // System.out.println(str);
                answer++;
            }
            return;
        }
        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(depth+1, str+friends[i], visited, data);
                visited[i]=false;
                
            }
        }
    }
    public boolean check(String str, String[] data){
        for(int i=0;i<data.length;i++){
            String a=data[i].substring(0,1);
            String b=data[i].substring(2,3);
            String s=data[i].substring(3,4);
            int cnt=Integer.valueOf(data[i].substring(4));
            int diff=Math.abs(str.indexOf(a)-str.indexOf(b))-1;
            
            if(s.equals("=")){
                if(diff!=cnt) return false;
            }
            else if(s.equals(">")){
                if(diff<=cnt)   return false;
            }
            else{
                if(diff>=cnt)   return false;
            }
        }
        return true;
    }
}