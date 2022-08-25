import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int N,M;
	static int [] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			parent = new int[N];

			int res=1;

			for (int i = 0; i < N; i++) {
				parent[i]=i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				union(a,b);
			}
			
			ArrayList<Integer> nums = new ArrayList<>(); 
			for (int i = 0; i < N; i++) {
				nums.add(parent[i]);
			}
			Collections.sort(nums);
			
			for (int i = 1; i < N; i++) {
				if(nums.get(i-1)!=nums.get(i))	res++;
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
	private static void union(int n1, int n2) {
		int p1=find(n1);
		int p2=find(n2);
		
		if(p1<p2) {
			for(int i=0;i<N;i++) {
				if(p2==parent[i]){
					parent[i]=p1;
				}
			}
			parent[p2]=p1;
		}
		else {
			for(int i=0;i<N;i++) {
				if(p1==parent[i]){
					parent[i]=p2;
				}
			}
			parent[p1]=p2;
		}
	}
	private static int find(int n) {
		if(parent[n]==n) {
			return n;
		}
		return parent[n]=find(parent[n]);
	}
}