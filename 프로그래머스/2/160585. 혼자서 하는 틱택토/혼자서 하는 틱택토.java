import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer=1;
        int ocnt=0,xcnt=0;
        char[][] tic=new char[3][3];
        
        for(int i=0;i<3;i++){
            tic[i]=board[i].toCharArray();
            for(int j=0;j<3;j++){
                if(tic[i][j]=='O')  ocnt++;
                else if(tic[i][j]=='X') xcnt++;
            }
        }
        
        if(xcnt>ocnt)   return 0;   //후공이 더 많은 지
        if(ocnt-xcnt>1)   return 0;
        
        int[][][] pos=new int[][][]{{{0,0},{0,1},{0,2}},{{1,0},{1,1},{1,2}},{{2,0},{2,1},{2,2}},
                                    {{0,0},{1,0},{2,0}},{{0,1},{1,1},{2,1}},{{0,2},{1,2},{2,2}},
                                    {{0,0},{1,1},{2,2}},{{0,2},{1,1},{2,0}}};
        boolean ovictory=false, xvictory=false;
        
        for(int i=0;i<8;i++){
            if(tic[pos[i][0][0]][pos[i][0][1]]=='O'&&tic[pos[i][0][0]][pos[i][0][1]]==tic[pos[i][1][0]][pos[i][1][1]]&&tic[pos[i][0][0]][pos[i][0][1]]==tic[pos[i][2][0]][pos[i][2][1]]){
                ovictory=true;
            }
            if(tic[pos[i][0][0]][pos[i][0][1]]=='X'&&tic[pos[i][0][0]][pos[i][0][1]]==tic[pos[i][1][0]][pos[i][1][1]]&&tic[pos[i][0][0]][pos[i][0][1]]==tic[pos[i][2][0]][pos[i][2][1]]){
                xvictory=true;
            }
        }
        if(ovictory&&xvictory)  return 0;
        if(ovictory&&ocnt==xcnt)    return 0;
        if(xvictory&&ocnt>xcnt) return 0;
        
        return answer;
    }
}