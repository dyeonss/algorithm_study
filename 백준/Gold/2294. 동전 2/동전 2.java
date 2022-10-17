import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int [] coin = new int[N];
        int [] dp = new int [100001];

        for (int i = 1; i < K+1; i++) {
            dp[i]=10001;
        }
        for (int i = 0; i < N; i++) {
            coin[i]=Integer.parseInt(br.readLine());
            dp[coin[i]]=1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j < K+1; j++) {
                dp[j]=Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }
        System.out.println(dp[K]!=10001?dp[K]:-1);
    }
}
