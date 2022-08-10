import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N=9;
	static boolean visited[];
	static int gywin;
	static int gylose;
	static List<Integer> gycard;
	static List<Integer> iycard;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			gycard=new ArrayList<>();	
			iycard=new ArrayList<>();
			visited=new boolean[18];
			gywin=0;
			gylose=0;
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				gycard.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 1; i <= 18 ; i++) {
				if(!gycard.contains(i))
					iycard.add(i);
			}
			dfs(0,0,0);
			System.out.println("#"+test_case+" "+gywin+" "+gylose);
		}
	}

	private static void dfs(int round,int gysum,int iysum) {
		if(round==N) {
			if(gysum>iysum)	gywin++;
			else if (gysum<iysum) gylose++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[iycard.get(i)-1]) continue;
			
			visited[iycard.get(i)-1]=true;
			int total=iycard.get(i)+gycard.get(round);
			if(iycard.get(i)>gycard.get(round))
				dfs(round+1, gysum, iysum+total);
			else if (iycard.get(i)<gycard.get(round))
				dfs(round+1, gysum+total, iysum);
			visited[iycard.get(i)-1]=false;
		}
	}
}