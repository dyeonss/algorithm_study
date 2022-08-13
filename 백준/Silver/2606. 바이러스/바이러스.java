import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] com;
	static boolean[] visited;
	static int result;
	static int start;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		com = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			com[r][c] = 1;
			com[c][r] = 1;
		}

		for (int j = 0; j < N; j++) {
			if (com[0][j] == 1) {
				bfs(j);
				break;
			}

		}
		System.out.println(result);
	}

	private static void bfs(int j) {
		Queue<Integer> q = new LinkedList<>();

		q.offer(j);
		visited[j] = true;
		while (!q.isEmpty()) {
			int x=q.poll();//1	

			for (int k = 0; k < N; k++) {
				if (com[x][k] == 1 && !visited[k]) {
					q.offer(k);
					result++;
					visited[k] = true;
				}
			}
		}
	}

}
