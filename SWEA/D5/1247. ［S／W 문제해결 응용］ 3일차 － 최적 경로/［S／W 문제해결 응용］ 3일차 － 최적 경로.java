import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Pos myhome, office;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			office=new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			myhome=new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			Pos[] list=new Pos[N];
			for (int i = 0; i < N; i++) {
				list[i]=new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			//방문 집 순열로
			int [] nums=new int[N];
			for (int i = 0; i < N; i++) {
				nums[i]=i;
			}
			int min=Integer.MAX_VALUE;
			do {
				int sum=0;
				sum+=calc(office,list[nums[0]]);
				for (int i = 1; i < N; i++) {
					sum+=calc(list[nums[i]],list[nums[i-1]]);
				}
				sum+=calc(list[nums[N-1]],myhome);
				if(sum<min)	min=sum;
			}while(np(N-1,nums));

			System.out.println("#"+tc+" "+min);
		}
	}
	private static int calc(Pos from, Pos to) {
		return Math.abs(from.x-to.x)+Math.abs(from.y-to.y);
	}
	private static boolean np(int size, int [] nums) {
		int i = size;

		while (i > 0 && nums[i - 1] > nums[i])
			i--;

		if (i == 0)
			return false;
		
		int j=size;
		
		while(nums[i-1]>nums[j])
			j--;
		
		int temp=nums[i-1];
		nums[i-1]=nums[j];
		nums[j]=temp;
		
		int k=size;
		
		while(i<k) {
			temp=nums[i];
			nums[i]=nums[k];
			nums[k]=temp;
			i++;
			k--;
		}
		
		return true;
	}
}
