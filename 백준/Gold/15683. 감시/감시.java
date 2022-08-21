import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int [][] map;
	static int [][] copy;
	static int [] order;	//cctv순서 
	static int min=Integer.MAX_VALUE;
	static ArrayList<cctv> list=new ArrayList<>();
	static class cctv{
		int r,c;
		int num;
		public cctv(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		int cctvNum=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0&&map[i][j]!=6) {
					cctv c=new cctv(i, j, map[i][j]);
					list.add(c);
					cctvNum++;
				}
			}
		}
		order=new int [cctvNum];
		nextpermutation(0,cctvNum);
		
		System.out.println(min);
	}
	private static void nextpermutation(int cnt, int cctvNum) {
		if(cnt==cctvNum) {
			copy=new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
			}
			for (int i = 0; i < cctvNum; i++) {
				direct(list.get(i),order[i]);	//cctv 번호, 방향 순서 
			}
			count();
			return;
		}
		for (int i = 0; i < 4; i++) {
			order[cnt]=i;
			nextpermutation(cnt+1, cctvNum);
		}
	}

	private static void count() {
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j]==0)	cnt++;
			}
		}
		if(cnt<min)	min=cnt;
	}
	private static void direct(cctv in, int i) {	//오:0 왼:1 위:2 아래:3
		if (in.num == 1) {
			if(i==0)	watch(0,in.r,in.c);
			else if(i==1) watch(1,in.r,in.c);
			else if(i==2) watch(2,in.r,in.c);
			else if(i==3) watch(3,in.r,in.c);
		} 
		else if (in.num == 2) {
			if(i==0||i==2) {
				watch(0,in.r,in.c);
				watch(1,in.r,in.c);
			}
			else if(i==1||i==3) {
				watch(2,in.r,in.c);
				watch(3,in.r,in.c);
			}
		}
		else if (in.num == 3) {
			if(i==0) {
				watch(0,in.r,in.c);
				watch(2,in.r,in.c);
			}
			else if(i==1) {
				watch(0,in.r,in.c);
				watch(3,in.r,in.c);
			}
			else if(i==2) {
				watch(1,in.r,in.c);
				watch(3,in.r,in.c);
			}
			else if(i==3) {
				watch(1,in.r,in.c);
				watch(2,in.r,in.c);
			}
		}
		else if (in.num == 4) {
			if(i==0) {
				watch(1,in.r,in.c);
				watch(2,in.r,in.c);
				watch(0,in.r,in.c);
			}
			else if(i==1) {
				watch(2,in.r,in.c);
				watch(0,in.r,in.c);
				watch(3,in.r,in.c);
			}
			else if(i==2) {
				watch(0,in.r,in.c);
				watch(3,in.r,in.c);
				watch(1,in.r,in.c);
			}
			else if(i==3) {
				watch(3,in.r,in.c);
				watch(1,in.r,in.c);
				watch(2,in.r,in.c);
			}
		}
		else if (in.num == 5) {
			watch(0,in.r,in.c);
			watch(1,in.r,in.c);
			watch(2,in.r,in.c);
			watch(3,in.r,in.c);
		}
	}
	private static void watch(int i, int r, int c) {
		switch (i) {
		case 0:	//오른쪽 
			for (int j = c+1; j < M; j++) {
				if(copy[r][j]==6)	break;
				if(copy[r][j]==0)	copy[r][j]=-1;
			}
			break;
		case 1:	//왼쪽 
			for (int j = c-1; j >= 0; j--) {
				if(copy[r][j]==6)	break;
				if(copy[r][j]==0)	copy[r][j]=-1;
			}
			break;
		case 2:	//위	 
			for (int j = r-1; j >= 0; j--) {
				if(copy[j][c]==6)	break;
				if(copy[j][c]==0)	copy[j][c]=-1;
			}
			break;
		case 3:	//아
			for (int j = r+1; j < N; j++) {
				if(copy[j][c]==6)	break;
				if(copy[j][c]==0)	copy[j][c]=-1;
			}
			break;
		}
	}	
}