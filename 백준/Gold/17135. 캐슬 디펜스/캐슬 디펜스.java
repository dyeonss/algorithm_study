import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M,D;
	static int [] p;
	static int [][] map;
	static int [][] copy;
	static int max=Integer.MIN_VALUE;
	static boolean [] visited=new boolean[M];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		map=new int [N+1][M];
		copy=new int [N+1][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		p=new int[3];
		ncr(0,0);
		
		System.out.println(max);
	}

	private static void attack() {
		int count=0;	//제거한 적의 수
		for (int l = 0; l < N; l++) {
			List<int[]> targets=new ArrayList<>();
			for (int pp = 0; pp <3; pp++) {	//궁수한테 가장 가까운 적 찾기 
				int i = p[pp];	//열위치
					int enemy=0;
					int d=0, mindist=Integer.MAX_VALUE;	//가장 가까운 적의 거리
					List<int[]> enmlist= new ArrayList<>();	//적의 좌표와 거리를 담는다.
					//적 찾기
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < M; k++) {
							if(copy[j][k]==1) {
								// 궁수 위치랑 적의 위치 계산, 왼쪽 적
								d=Math.abs(N-j)+Math.abs(i-k);
								if(d<=D) {
									if(d<mindist)	mindist=d;
									enmlist.add(new int[] {j,k,d});
								}
							}
						}
					}
					int minc=M;	//가장 왼쪽 적을 구하기 위함
					int [] target=null;
					for (int j = 0; j < enmlist.size(); j++) {
						int [] tmp=enmlist.get(j);
						if(mindist==tmp[2]) {
							if(tmp[1]<minc) {
								target=new int[2];
								minc=tmp[1];	//가장 왼쪽 열 
								target[0]=tmp[0];
								target[1]=tmp[1];
							}
						}
					}
					if(target!=null) {
						targets.add(target);	//공격 대상
					}
				}
			
			//공격
			for (int i = 0; i < targets.size(); i++) {
				int [] loc=targets.get(i);
				if(copy[loc[0]][loc[1]]==1) {
					copy[loc[0]][loc[1]]=0;
					count++;
				}
			}
			
			//공격 후 적의 이동
			for (int i = N-1; i > 0; i--) {
				copy[i]=Arrays.copyOf(copy[i-1], copy[i-1].length);
			}
			copy[0]=new int[M];
			
			if(count>max) max=count;
		}
	}

	private static void ncr(int start, int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < N+1; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, map[0].length);
			}
			attack();
			return;
		}
		for (int i = start; i < M; i++) {
			p[cnt]=i;
			ncr(i+1, cnt + 1);
		}
	}
}
