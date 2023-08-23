import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int size = board.length;
        char[][] game = new char[n][m];
        
        for(int i=0;i<m;i++)    game[i]=board[i].toCharArray();
        
        ArrayList<int[]> loc = new ArrayList<>();
        
        while(true){
            loc.clear(); 
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(game[i][j]!=' '){
                        char ch = game[i][j];
                        
                        if(ch==game[i][j+1]&&ch==game[i+1][j+1]&&ch==game[i+1][j]){
                            loc.add(new int[]{i,j});  
                            loc.add(new int[]{i,j+1});
                            loc.add(new int[]{i+1,j+1});  
                            loc.add(new int[]{i+1,j});
                        }
                    }
                }
            }
        
            if(loc.size()==0)   break;
            
            for(int i=0;i<loc.size();i++){
                int[] coor = loc.get(i);
                if(game[coor[0]][coor[1]]!=' '){
                    game[coor[0]][coor[1]]=' ';
                    answer++;
                }  
            }
            
            //밑으로 내려주기
            for(int i=n-1;i>=0;i--){
                for(int j=0;j<m;j++){
                    //칸이 비어있으면 그 열의 밑에서부터 맨위까지 조사해서 내리기
                    if(game[i][j]==' '){
                        for(int k=i-1;k>=0;k--){
                            if(game[k][j]!=' '){
                                game[i][j]=game[k][j];
                                game[k][j]=' ';
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}