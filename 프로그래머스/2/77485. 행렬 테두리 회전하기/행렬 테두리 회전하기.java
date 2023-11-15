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
            int r1=queries[i][0]-1;
            int c1=queries[i][1]-1;
            int r2=queries[i][2]-1;
            int c2=queries[i][3]-1;
           
            int tmp=matrix[r1][c1];
            int min=tmp;
            for(int j=r1;j<r2;j++){
                matrix[j][c1]=matrix[j+1][c1];
                if(matrix[j][c1]<min)   min=matrix[j][c1];
            }
            
            for(int j=c1;j<c2;j++){
                matrix[r2][j]=matrix[r2][j+1];
                if(matrix[r2][j]<min)   min=matrix[r2][j];
            }
            
            for(int j=r2;j>r1;j--){
                matrix[j][c2]=matrix[j-1][c2];
                if(matrix[j][c2]<min)   min=matrix[j][c2];
            }
            
            for(int j=c2;j>c1;j--){
                matrix[r1][j]=matrix[r1][j-1];
                if(matrix[r1][j]<min)   min=matrix[r1][j];
            }
            
            matrix[r1][c1+1]=tmp;
            answer[i]=min;
        }
        return answer;
    }
}