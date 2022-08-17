import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] image;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		image = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] ch = s.toCharArray();
			for (int j = 0; j < N; j++) {
				image[i][j] = ch[j] - '0';
			}
		}

		cmp(0, 0, N);
		System.out.println(sb.toString());
	}

	private static void cmp(int r, int c, int n) {
		boolean check = true;
		if (n == 1) {
			if (image[r][c] == 1)
				sb.append("1");
			else
				sb.append("0");
		} 
		else {
			int d = image[r][c];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (image[r + i][c + j] != d) { // 만약 image에 0이 있으면 분할
						check = false;
						break;
					}
				}
			}
			if (!check) {
				sb.append("(");
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						cmp(r + i * n / 2, c + j * n / 2, n / 2);
					}
				}
				sb.append(")");
			} else {
				sb.append(d + "");
			}
		}
	}
}
