import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int count;
	static int[][] room;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int rnum=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count=1;
					search(i,j);
					if(count>=max) {
						if(count == max & rnum < room[i][j])
                            continue;
                        max = count;
                        rnum = room[i][j];
					}
				}
			}
			
			System.out.println("#" +test_case+ " "+rnum+" "+max);
		}

	}

	private static void search(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(check(nr,nc)&&room[nr][nc]==room[r][c]+1) {
				count++;
				search(nr, nc);
			}
				
		}
		return ;
	}
	
	private static boolean check(int nr, int nc) {
		return nr>=0&&nr<N&&nc>=0&&nc<N;
	}
}