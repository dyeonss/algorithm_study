import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix=new int[rows][columns];
        int start=1;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j]=start++;
            }
        }
        
        for(int i=0;i<queries.length;i++){
            queries[i][0]-=1;
            queries[i][1]-=1;
            queries[i][2]-=1;
            queries[i][3]-=1;
            
            int tmp=matrix[queries[i][0]][queries[i][1]];
            int min=tmp;
            for(int j=queries[i][0];j<queries[i][2];j++){
                matrix[j][queries[i][1]]=matrix[j+1][queries[i][1]];
                min=Math.min(min,matrix[j][queries[i][1]]);
            }
            
            for(int j=queries[i][1];j<queries[i][3];j++){
                matrix[queries[i][2]][j]=matrix[queries[i][2]][j+1];
                min=Math.min(min,matrix[queries[i][2]][j]);
            }
            
            for(int j=queries[i][2];j>queries[i][0];j--){
                matrix[j][queries[i][3]]=matrix[j-1][queries[i][3]];
                min=Math.min(min,matrix[j][queries[i][3]]);
            }
            
            for(int j=queries[i][3];j>queries[i][1];j--){
                matrix[queries[i][0]][j]=matrix[queries[i][0]][j-1];
                min=Math.min(min,matrix[queries[i][0]][j]);
            }
            
            matrix[queries[i][0]][queries[i][1]+1]=tmp;
            answer[i]=min;
        }
        return answer;
    }
}