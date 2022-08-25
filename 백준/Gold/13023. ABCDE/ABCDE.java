import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<ArrayList<Integer>> f=new ArrayList<>();
	static int res=0;
	static int depth = 5;
	static boolean stop;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		for (int i = 0; i <N; i++) {
			f.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			f.get(a).add(b);
			f.get(b).add(a);
		}
		
		for (int i = 0; i < N; i++) {
			visited=new boolean[N];
			visited[i]=true;
			dfs(i,1);
			if(stop)	break;
		}
		System.out.println(res);
	}
	private static void dfs(int x,int depth) {
		
		if(depth==5) {
			res=1;
			stop=true;
			return;
		}
		
		for (int j = 0; j < f.get(x).size(); j++) {
			if(!visited[f.get(x).get(j)]) {
				visited[f.get(x).get(j)]=true;
				dfs(f.get(x).get(j),depth+1);
				visited[f.get(x).get(j)]=false;
				if(stop)	return;
			}
		}
	}
	
}
