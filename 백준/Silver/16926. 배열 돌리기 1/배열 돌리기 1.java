import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R;
	static int[][] arr;
	static boolean [][] visited;
	static int [] dr= {0,1,0,-1};
	static int [] dc= {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) { // 회전
			for (int j = 0; j < (N < M ? N / 2 : M / 2); j++) { // 배열 안에서 반시계방향으로 돌리는 횟수
				int sy = j;	//(0,0) (1,1) 
				int sx = j;
				int k=0;
				int temp=arr[sy][sx];
				while (true) {
					int nr = sy + dr[k];
					int nc = sx + dc[k];
					if (!check(nr, nc, j)) {
						k++;
						if(k>=4)
							k=k%4;
						nr=sy + dr[k];
						nc = sx + dc[k];
					}

					arr[sy][sx]=arr[nr][nc];

					sy=nr;
					sx=nc;
					
					if(sy==j&&sx==j)
						break;
				}
				arr[j+1][j] = temp;
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean check(int r, int c, int d) {
			return r>=d&&r<N-d&&c>=d&&c<M-d;
	}

}
