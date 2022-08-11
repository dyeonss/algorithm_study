import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[][] map;
	static int[][] origin;
	static int [] dr= {0,1,0,-1};
	static int [] dc= {-1,0,1,0};
	static ArrayList<ArrayList<Integer>> ops=new ArrayList<>();
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		origin=new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				origin[i][j]=map[i][j];
			}
		}
		int [] order=new int[K];

		//회전연산 
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> op=new ArrayList<>();
			op.add(Integer.parseInt(st.nextToken())-1);
			op.add(Integer.parseInt(st.nextToken())-1);
			op.add(Integer.parseInt(st.nextToken()));
			ops.add(op);
			order[i]=i;	//ops의 순서 
		}
		
		do {
			for (int j = 0; j < order.length; j++) {
				rotate(ops.get(order[j]).get(0),ops.get(order[j]).get(1),ops.get(order[j]).get(2),map);
			}
			countMin(map);
			for(int i=0; i<origin.length; i++){
	            System.arraycopy(origin[i], 0, map[i], 0, map[i].length);
	        }
		}while(np(order));
		
		System.out.println(min);
	}

	private static boolean np(int[] order) {
		int N=order.length;
		int i=N-1;
		
		while(i>0&&order[i-1]>order[i])	i--;
		
		if(i==0) return false;	//다음 순열을 만들 수 없는 가장 큰 순열인 상태
		
		int j=N-1;
		
		while(order[i-1]>order[j])	
			j--;
		
		int temp=order[i-1];
		order[i-1]=order[j];
		order[j]=temp;
		
		int k=N-1;
		
		while(i<k) {
			temp=order[i];
			order[i]=order[k];
			order[k]=temp;
			i++;
			k--;
		}
		return true;
	}

	private static void countMin(int arr[][]) {
		for (int j = 0; j < N; j++) {
			int sum=0;
			for (int k = 0; k < M; k++) {
				sum+=arr[j][k];
			}
			min=Math.min(min, sum);
		}
	}

	private static void rotate(int r, int c, int s, int arr[][]) {
		//(r-s,c-s),	(r+s,c+s)	3,4,2->(0,1) (4,5)	n:5 m:6 현재 5*5
		int [] start=new int[] {r-s,c-s};//(0,1)
		int [] end=new int[] {r+s,c+s};//(4,5)
		int n=end[0]-start[0]+1; //n*m의 크기의 배열 5*5
		int m=end[1]-start[1]+1;
		for (int j = 0; j < ( n< m? n / 2 : m / 2); j++) { // 배열 안에서 반시계방향으로 돌리는 횟수
			int sy = start[0]+j;	//(0,5) (1,4)
			int sx = end[1]-j;
			int k=0;
			int temp=arr[sy][sx];
			while (true) {
				int nr = sy + dr[k];
				int nc = sx + dc[k];
				if (!check(nr, nc, start[0],end[0],start[1],end[1],j)) {
					k++;
					if(k>=4)
						k=k%4;
					nr=sy + dr[k];
					nc = sx + dc[k];
				}

				arr[sy][sx]=arr[nr][nc];

				sy=nr;
				sx=nc;
				
				if(sy==(start[0]+j)&&sx==(end[1]-j))
					break;
			}
			arr[start[0]+j+1][end[1]-j] = temp;
		}
	}

	private static boolean check(int r, int c, int rs, int re, int cs, int ce, int d) {
			return r>=rs+d&&r<=re-d&&c>=cs+d&&c<=ce-d;
	}
}
