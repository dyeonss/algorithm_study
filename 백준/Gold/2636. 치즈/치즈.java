import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int[][] pizza;
	static boolean[][] visited;
	static int second = 0, cheese, last=0;
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pizza = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				pizza[i][j] = Integer.parseInt(st.nextToken());
				if (pizza[i][j] == 1)
					cheese++;
			}
		}
		melting();
		System.out.println(second + "\n" + last);
	}
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static void melting() {
		Queue<Pos> q = new LinkedList<>();
		int cnt=0;
		while (cnt != cheese) {
			visited = new boolean[N][M];
			q.offer(new Pos(0, 0));
			visited[0][0] = true;
			pizza[0][0] = -1;
			last=0;
			while (!q.isEmpty()) {
				Pos p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if (check(nr, nc) && !visited[nr][nc] && pizza[nr][nc] == 0) {
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
						pizza[nr][nc] = -1;
					}
					if (check(nr, nc) && !visited[nr][nc] && pizza[nr][nc] == 1) {
						pizza[nr][nc] = pizza[nr][nc] + 1;
						cnt++;
						last++;
					}
				}
			}
			second++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(pizza[i][j]==-1||pizza[i][j]>1) 
						pizza[i][j]=0;
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
