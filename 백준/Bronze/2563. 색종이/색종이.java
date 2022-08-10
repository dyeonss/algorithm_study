import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] paper = new int [101][101];
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					if(paper[j][k]==0) {
						paper[j][k]=1;
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}