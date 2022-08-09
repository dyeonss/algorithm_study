import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N;	//과자 봉지의 개수
	static int M;	//무게 제한 
	static int result;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			result=-1;
			pick(0,0,0);
			
			System.out.println("#"+test_case+" "+result);
		}
	}

	private static void pick(int cnt,int total, int start) {
		if(cnt==2) {
			if(total<=M) {
				result=Math.max(result, total);
			}
			return ;
		}
		for (int i = start; i < N; i++) {
			pick(cnt+1,total+list.get(i),i+1);
		}
	}
}
