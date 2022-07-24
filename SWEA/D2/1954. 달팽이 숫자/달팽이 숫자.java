import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int n;
	static int[][] snail;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			snail = new int[n][n]; // 0초기화

			godfs(0, 0, 0, 1);

			System.out.println("#" + test_case);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void godfs(int r, int c, int d, int i) {
		snail[r][c] = i;
		if (i == n * n)
			return;

		int nr = r + dr[d];
		int nc = c + dc[d];

		if (!(check(nr, nc) && snail[nr][nc] == 0)) {
			d = (d + 1) % 4;
		}
		r = r + dr[d];
		c = c + dc[d];

		godfs(r, c, d, i + 1);
	}

	private static boolean check(int r, int c) {

		return r >= 0 && r < n && c >= 0 && c < n; // 범위 안에 있음
	}

}
