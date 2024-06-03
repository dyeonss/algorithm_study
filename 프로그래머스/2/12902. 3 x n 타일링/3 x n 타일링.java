import java.util.*;
class Solution {
    public long solution(int n) {
        int answer = 0;
        long[] arr=new long[n+1];
        
        arr[0]=1;
        arr[1]=0;
        arr[2]=3;
        arr[3]=0;
        
        for(int i=4;i<n+1;i+=2){
            arr[i]=(arr[i-2]*4-arr[i-4])%1000000007;
            if(arr[i]<0)    arr[i]+=1000000007;
        }
        
        return arr[n];
    }
}