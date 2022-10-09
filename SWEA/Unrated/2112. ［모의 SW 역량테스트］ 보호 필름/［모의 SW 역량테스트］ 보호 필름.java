import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int D, W, K, res;
    static int[][] film;
    static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            res = Integer.MAX_VALUE;
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            film = new int[D][W];
            temp = new int[D][W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());    //0->A, 1->B
                }
            }
            for (int i = 0; i < D; i++) {
                System.arraycopy(film[i], 0, temp[i], 0, film[i].length);
            }
            test(0, 0, temp);
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void test(int cnt, int idx, int[][] copy) {
        if (cnt >= res) {
            return;
        }
        if (pass(copy)) {
            res = Math.min(res, cnt);
            return;
        }
        for (int i = idx; i < D; i++) {
            change(copy, i, 0);
            test(cnt + 1, i + 1, copy);
            change(copy, i, 1);
            test(cnt + 1, i + 1, copy);
            copy(copy, i);
        }
    }

    private static void copy(int[][] copy, int i) {
        for (int c = 0; c < W; c++) {
            copy[i][c] = film[i][c];
        }
    }

    private static void change(int[][] copy, int i, int paint) {
        for (int j = 0; j < W; j++) {
            copy[i][j] = paint;
        }
    }

    private static boolean pass(int[][] copy) {
        boolean p = true;
        for (int i = 0; i < W; i++) {
            int d = copy[0][i];
            int count = 1;
            for (int j = 1; j < D; j++) {
                if (d != copy[j][i]) {
                    d = copy[j][i];
                    count = 1;
                } else count++;
                if (count == K) break;
            }
            if (count != K) {
                p = false;
                return false;
            }
        }
        return true;
    }
}
