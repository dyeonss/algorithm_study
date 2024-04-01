import java.util.*;
class Solution {
    static int score=Integer.MIN_VALUE;
    static int[] lion=new int[11];
    static int[] answer=new int[11];
    public int[] solution(int n, int[] info) {
        
        dfs(n,0,info);
        if(score<=0)    return new int[]{-1};
        return answer;
    }
    public void dfs(int n,int idx,int[] info){
        if(idx==11){
            if(n==0)    calcScore(lion,info);
            return;
        }
        if(info[idx]==0){
            lion[idx]=0;
            dfs(n,idx+1,info);
        }
        //어피치한테 지기
        if(info[idx]>0){
            for(int i=0;i<info[idx];i++){
                lion[idx]=i;
                dfs(n-i,idx+1,info);
            }
        }
        //어피치한테 이기기
        if(info[idx]<n){
            lion[idx]=info[idx]+1;
            dfs(n-(info[idx]+1),idx+1,info);
        }
    }
    public void calcScore(int[] arr,int[] info){
        int lion=0, apeach=0;
        
        for(int i=0;i<11;i++){
            if(arr[i]<=info[i]&&info[i]!=0) apeach+=(10-i);
            else if(arr[i]>info[i]) lion+=(10-i);
        }
        
        if(lion-apeach>score){
            answer=arr.clone();
            score=lion-apeach;
        }
        else if(lion-apeach==score){
            for(int i=10;i>=0;i--){
                if(arr[i]<answer[i]){
                    break;
                }
                else if(arr[i]>answer[i]){
                    answer=arr.clone();
                    break;
                }
            }
        }
       
    }
}