import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static String res;
	static Pos house, festival;
	static Pos[] stores;
	static class Pos {
		int r, c;
		boolean visited;
		public Pos(int r, int c, boolean visited) {
			super();
			this.r = r;
			this.c = c;
			this.visited = visited;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()); // 집
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			house = new Pos(r, c, false);
			List<Pos> store = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()); // 가게
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				store.add(new Pos(r, c, false));
			}
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			festival = new Pos(r, c, false);
			res = "sad";

			Queue<Pos> root = new LinkedList<>();
			root.add(house);

			while (!root.isEmpty()) {
				Pos p = root.poll();
				int d = Math.abs(festival.r - p.r) + Math.abs(festival.c - p.c);
				if (d <= 1000) {
					res = "happy";
					break;
				}
				for (Pos pos : store) {
					int dist = Math.abs(p.r - pos.r) + Math.abs(p.c - pos.c);
					if (dist <= 1000 && !pos.visited) {
						pos.visited = true;
						root.offer(pos);
					}
				}
			}
			System.out.println(res);
		}
	}
}