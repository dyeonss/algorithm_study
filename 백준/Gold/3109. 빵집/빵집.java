import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char [][] map;
	static boolean [][] visited;
	static int res;
	static int [] dr= {-1,0,1};
	static int [] dc= {1,1,1};
	static boolean stop;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		map=new char[R][C];
		visited=new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String s=br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j]=s.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			stop=false;
			dfs(i,0);
		}
		System.out.println(res);
	}

	private static void dfs(int r, int c) {
		if(c==C-1) {
			res++;
			stop=true;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if(stop)	return;
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(check(nr,nc)&&!visited[nr][nc]&&map[nr][nc]=='.') {
				visited[nr][nc]=true;
				dfs(nr,nc);
			}
		}
	}

	private static boolean check(int r, int c) {
		return (r>=0&&r<R&&c>=0&&c<C);
	}
}
