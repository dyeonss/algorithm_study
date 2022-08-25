import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	static class RGB{
		int r,c;
		char ch;
		public RGB(int r, int c, char ch) {
			this.r = r;
			this.c = c;
			this.ch = ch;
		}
	}
	static int N;
	static char [][] board;
	static int orgbres, xrgbres;
	static boolean [][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		board=new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j]=s.charAt(j);
			}
		}
		
		visited=new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j])
					xrgb(i,j);
			}
		}
		
		visited=new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j])
					orgb(i,j);
			}
		}
		
		System.out.println(xrgbres+" "+orgbres);
	}

	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0};
	private static void xrgb(int r, int c) {
		Queue<RGB> q=new LinkedList<>();
		
		q.offer(new RGB(r, c, board[r][c]));
		visited[r][c]=true;
		
		while (!q.isEmpty()) {
			RGB cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (check(nr, nc) && !visited[nr][nc] && (cur.ch == board[nr][nc])) {
					visited[nr][nc] = true;
					q.offer(new RGB(nr, nc, board[nr][nc]));
				}
			}
		}
		xrgbres++;
	}
	
	private static void orgb(int r, int c) {
		Queue<RGB> q=new LinkedList<>();
		
		q.offer(new RGB(r, c, board[r][c]));
		visited[r][c]=true;
		
		while (!q.isEmpty()) {
			RGB cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (check(nr, nc) && !visited[nr][nc] && ((cur.ch == 'R'&&(board[nr][nc]=='R'||board[nr][nc]=='G')))) {
					visited[nr][nc] = true;
					q.offer(new RGB(nr, nc, board[nr][nc]));
				}
				if (check(nr, nc) && !visited[nr][nc] && ((cur.ch == 'G'&&(board[nr][nc]=='R'||board[nr][nc]=='G')))) {
					visited[nr][nc] = true;
					q.offer(new RGB(nr, nc, board[nr][nc]));
				}
				if (check(nr, nc) && !visited[nr][nc] && ((cur.ch == 'B'&&board[nr][nc]=='B'))) {
					visited[nr][nc] = true;
					q.offer(new RGB(nr, nc, board[nr][nc]));
				}
			}
		}
		orgbres++;
	}
	private static boolean check(int r, int c) {
		return r>=0&&r<N&&c>=0&&c<N;
	}
}
