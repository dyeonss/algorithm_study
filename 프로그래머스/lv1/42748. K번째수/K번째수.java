import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int[] copy = new int[commands[i][1]-commands[i][0]+1];
            for(int j=0;j<copy.length;j++){
                copy[j]=array[commands[i][0]+j-1];
            }
            Arrays.sort(copy);
            answer[i]=copy[commands[i][2]-1];
        }
        
        return answer;
    }
}