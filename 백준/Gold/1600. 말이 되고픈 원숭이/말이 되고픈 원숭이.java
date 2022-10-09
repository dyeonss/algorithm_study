import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H;
	static int res;
	static int[][] map;
	static boolean[][][] visited;

	static class Pos {
		int r, c;
		int cnt, hcnt;
		public Pos(int r, int c, int cnt, int hcnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.hcnt = hcnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Pos monkey = new Pos(0, 0, 0, 0);
		bfs(monkey);
		System.out.println(res==Integer.MAX_VALUE?-1:res);
	}

	static int[] dr_m = { 0, -1, 0, 1 };
	static int[] dc_m = { -1, 0, 1, 0 };
	static int[] dr_h = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc_h = { -2, -1, 1, 2, -2, -1, 1, 2 };
	private static void bfs(Pos monkey) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(monkey);

		while (!q.isEmpty()) {
			Pos now = q.poll();

			if (now.r == H - 1 && now.c == W - 1) {
				res = Math.min(res, now.cnt);
				break;
			}
			if (now.hcnt < K) {
				for (int i = 0; i < 8; i++) {
					int nr = now.r + dr_h[i];
					int nc = now.c + dc_h[i];
					if (check(nr, nc) && !visited[nr][nc][now.hcnt+1] && map[nr][nc] == 0) {
						visited[nr][nc][now.hcnt+1] = true;
						q.offer(new Pos(nr, nc, now.cnt + 1, now.hcnt + 1));
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr_m[i];
				int nc = now.c + dc_m[i];
				if (check(nr, nc) && !visited[nr][nc][now.hcnt] && map[nr][nc] == 0) {
					visited[nr][nc][now.hcnt] = true;
					q.offer(new Pos(nr, nc, now.cnt + 1, now.hcnt));
				}
			}
		}
	}
	private static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}
