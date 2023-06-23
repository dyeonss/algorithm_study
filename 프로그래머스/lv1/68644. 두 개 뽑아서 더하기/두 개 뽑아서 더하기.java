import java.util.*;
class Solution {
    public Integer[] solution(int[] numbers) {
        Integer[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(!arr.contains(numbers[i]+numbers[j]))
                    arr.add(numbers[i]+numbers[j]);
            }
        }
 
        Collections.sort(arr);
        answer = arr.toArray(new Integer[arr.size()]);
        return answer;
    }
}