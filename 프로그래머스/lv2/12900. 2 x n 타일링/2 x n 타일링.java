import java.util.*;
class Solution {
    public int solution(int n) {
        int[] arr = new int[60000];
        arr[0]=1;
        arr[1]=2;
        
        for(int i=2;i<60000;i++){
            arr[i]=(arr[i-2]+arr[i-1])%1000000007;
            if(i==n-1)  break;
        }
        
        return arr[n-1];
    }
}