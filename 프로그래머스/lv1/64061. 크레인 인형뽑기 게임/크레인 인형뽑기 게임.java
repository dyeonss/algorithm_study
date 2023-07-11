import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> box = new Stack<>();
        
        for(int i=0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1]!=0){
                    int n=board[j][moves[i]-1];
                    board[j][moves[i]-1]=0;
                    if(box.size()>0){
                        if(n==box.peek()){
                            box.pop();
                            answer+=2;
                            break;
                        }
                    }
                    box.push(n);
                    break;
                }
            }
        }
        return answer;
    }
}