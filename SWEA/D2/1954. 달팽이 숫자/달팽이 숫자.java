import java.util.Scanner;

public class Solution {
	static int[][] board;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int r = 0;
			int c = 0;
			int d = 0;

			board = new int[n][n];
			
			for (int i = 1; i <= n * n; i++) {
				board[r][c] = i;
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || board[nr][nc] != 0) {
					d++;

					if (d >= 4) {
						d = d % 4;
					}
				}
				r = r + dr[d];
				c = c + dc[d];

			}
			System.out.println("#" + test_case);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
