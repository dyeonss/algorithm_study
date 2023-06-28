import java.util.*;
class Solution {
    public static int sr=0, sc=0, nr=0, nc=0;
    public static char[][] p;
    public static int W,H;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        p = new char[park.length][park[0].length()];
        int sr=0,sc=0,nr=0,nc=0;
        int W=park[0].length(),H=park.length;
        
        for(int i=0;i<H;i++){
            p[i]=park[i].toCharArray();
            for(int j=0;j<W;j++){
                if(p[i][j]=='S'){
                    sr=i;
                    sc=j;
                    break;
                }
            }
        }
        
        for(int i=0;i<routes.length;i++){
            char op = routes[i].charAt(0);
            int n = Integer.valueOf(routes[i].charAt(2))-48;
            boolean check=true;
            nr=sr;
            nc=sc;
            for(int j=0;j<n;j++){
                if(op=='N') nr--;
                else if(op=='S')    nr++;
                else if(op=='W')    nc--;
                else    nc++;
                if(nr<0||nr>H-1||nc<0||nc>W-1||p[nr][nc]=='X'){
                    check=false;
                    break;
                }
            }
            if(check){
                sr=nr;
                sc=nc;
            }
        }
        answer[0]=sr;
        answer[1]=sc;
        return answer;
    }
}