import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static int count=1;
	static char [][] board;
	static boolean [][] visited;
	static ArrayList<Character> alph=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		board=new char[R][C];
		visited=new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j]=s.charAt(j);
			}
		}
		visited[0][0]=true;
		alph.add(board[0][0]);
		dfs(0,0);
		System.out.println(max);
	}
	
	static int [] dr= {-1,1,0,0};
	static int [] dc= {0,0,-1,1};
	static int max=1;
	private static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (check(nr, nc) && !visited[nr][nc] && !alph.contains(board[nr][nc])) {
				alph.add(board[nr][nc]);
				visited[nr][nc] = true;
				count++;
				dfs(nr, nc);
				if(count>max) {
					max=count;
				}
				//이전 상태 복구 
				visited[nr][nc] = false;
				count--;
				alph.remove(alph.size()-1);
			}
		}
	}
	
	private static boolean check(int r, int c) {
		return r>=0&&r<R&&c>=0&&c<C;
	}
}
