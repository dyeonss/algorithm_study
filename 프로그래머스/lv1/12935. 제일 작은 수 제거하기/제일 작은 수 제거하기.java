import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        int [] copy = Arrays.copyOf(arr,arr.length);
        if(arr.length==1)
            return answer;
        answer = new int [arr.length-1];
        Arrays.sort(copy);
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=copy[0]){
                answer[j]=arr[i];
                j++;
            }
        }
        return answer;
    }
}