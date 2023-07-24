import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int i=1;
        
        while(true){
            boolean flag = true;
            answer = max*i++;
            for(int j=0;j<arr.length-1;j++){
                if(answer%arr[j]!=0){
                    flag = false;
                    break;
                }
            }
            if(flag)    break;
        }
        return answer;
    }
}