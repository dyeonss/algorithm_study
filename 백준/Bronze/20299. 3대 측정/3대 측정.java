import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,S,M,res;
	static int [][] score;
	static boolean [] join;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		score=new int[N][3];
		join=new boolean[N];
		res=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				score[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			boolean pass = true;
			int sum=0;
			for (int j = 0; j < 3; j++) {
				if(score[i][j]<M) {
					pass=false;
				}
				sum+=score[i][j];
			}
			if(sum>=S&&pass) {
				res++;
				join[i]=true;
			}
		}
		sb.append(res).append("\n");
		for (int i = 0; i < N; i++) {
			if(join[i]) {
				for (int j = 0; j < 3; j++) {
					sb.append(score[i][j]).append(" ");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
