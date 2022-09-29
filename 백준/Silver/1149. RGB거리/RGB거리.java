import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, res;
    static int [][] color;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        color=new int[N][3];
        dp=new int[N][3];
        res=Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int max=Integer.MIN_VALUE;
            for (int j = 0; j < 3; j++) {
                color[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0]=color[0][0];
        dp[0][1]=color[0][1];
        dp[0][2]=color[0][2];

        for(int i=1;i<color.length;i++){
            dp[i][0] = Math.min(color[i][0] + dp[i-1][1], color[i][0] + dp[i-1][2]);
            dp[i][1] = Math.min(color[i][1] + dp[i-1][0], color[i][1] + dp[i-1][2]);
            dp[i][2] = Math.min(color[i][2] + dp[i-1][0], color[i][2] + dp[i-1][1]);
        }
        for (int i = 0; i < 3; i++) {
            res= Math.min(res,dp[N-1][i]);
        }
        System.out.println(res);
    }
}
