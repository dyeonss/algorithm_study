class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] board = new int[n][n];
        int dir=0, r=-1,c=0;
        int start=1,idx=0;
        int size = n;
        
        while(n>0){
            if(dir%3==0){
                for(int i=0;i<n;i++){
                    board[++r][c]=start++;
                    // System.out.println(board[r][c]);
                }
            }
            else if(dir%3==1){
                for(int i=0;i<n;i++){
                    board[r][++c]=start++;
                    // System.out.println(board[r][c]);
                }
            }
            else if(dir%3==2){
                for(int i=0;i<n;i++){
                    board[--r][--c]=start++;
                    // System.out.println(board[r][c]);
                }
            }
            dir++;
            n--;
            
        }
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=0)
                    answer[idx++]=board[i][j];
            }
        }
        return answer;
    }
}