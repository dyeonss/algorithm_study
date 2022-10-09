import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int INF = 9999999;
	static int N;
	static int distance[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			distance=new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					distance[i][j]=Integer.parseInt(st.nextToken());
					if(i!=j&&distance[i][j]==0)
						distance[i][j]=INF;
				}
			}
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if(j==i)	continue;
					for (int k = 0; k < N; ++k) {
						if(j==k||i==k)	continue;
						if(distance[j][k]>distance[j][i]+distance[i][k]) {
							distance[j][k]=distance[j][i]+distance[i][k];
						}
					}
				}
			}
			int min=Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum=0;
				for (int j = 0; j < N; j++) {
					sum+=distance[i][j];
				}
				min=Math.min(sum, min);
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
}
