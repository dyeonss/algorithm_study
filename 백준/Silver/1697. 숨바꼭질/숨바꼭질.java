import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int min=Integer.MAX_VALUE;
	static int visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		visited=new int[100001];
		
		find(N);
		System.out.println(min);
	}
	private static void find(int n) {
		Queue<Integer> q = new LinkedList<>();
		int second=1;
		
		q.offer(n);
		visited[n]=second;
		
		while(!q.isEmpty()) {
			int loc = q.poll();
			if(loc==K) {
				min=visited[loc]-1;
			}
			second++;
			if(loc-1>=0&&loc-1<=100000&&visited[loc-1]==0) {
				q.offer(loc-1);
				visited[loc-1]=visited[loc]+1;
			}
			if(loc+1>=0&&loc+1<=100000&&visited[loc+1]==0) {
				q.offer(loc+1);
				visited[loc+1]=visited[loc]+1;
			}
			if(loc*2>=0&&loc*2<=100000&&visited[loc*2]==0) {
				q.offer(loc*2);
				visited[loc*2]=visited[loc]+1;
			}
		}
	}
}
