import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] v = new int[N + 1];
        int[] c = new int[N + 1];
        int[][] result = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            v[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (v[i] > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    result[i][j] = Math.max(c[i] + result[i - 1][j - v[i]], result[i - 1][j]);
                }
            }
        }
        System.out.println(result[N][K]);
    }
}
