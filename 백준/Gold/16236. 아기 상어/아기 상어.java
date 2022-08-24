import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Shark{
		int r,c;
		int size;
		int dist;
		int eat;
		public Shark(int r, int c, int size, int dist, int eat) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist= dist;
			this.eat= eat;
		}
	}
	static class Fish{
		int r,c;
		int size;
		int dist;
		public Fish(int r, int c, int size, int dist) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist = dist;
		}
	}
	static int N;
	static int [][] map;
	static Shark shark;
	static ArrayList<Fish> fishes;
	static Fish target;
	static int second=0;
	static boolean possible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		fishes=new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) 
					shark= new Shark(i, j, 2,0,0);
				if(map[i][j]!=0&&map[i][j]!=9) {
					Fish f=new Fish(i, j, map[i][j],20);
					fishes.add(f);
				}
			}
		}
	
		bfs(shark);
		System.out.println(second);
	}

	static int [] dr = {-1,0,1,0};
	static int [] dc= {0,1,0,-1};
	private static void bfs(Shark s) {
		ArrayList<Fish> targetfish=new ArrayList<>();
		
		if(fishes.size()==0) return;
		
		for (int i = 0; i < fishes.size(); i++) {
			//상어의 크기보다 작으면 해당 물고기는 타겟 리스트에 넣어준다.
			if(fishes.get(i).size<shark.size) {
				targetfish.add(fishes.get(i));
			}
		}
		
		map[shark.r][shark.c]=0;
		//fishes의 크기가 0이 되면 종료
		while(targetfish.size()!=0) {
		
			dist(targetfish);	
			if(!possible) {
				return;
			}
			map[target.r][target.c]=0;
			targetfish.remove(target);
			shark.r=target.r;
			shark.c=target.c;
			shark.eat++;
			
			if(shark.eat==shark.size) {
				shark.size++;
				shark.eat=0;
				
				targetfish=new ArrayList<>();
				for (int i = 0; i < fishes.size(); i++) {
					//상어의 크기보다 작으면 해당 물고기는 타겟 리스트에 넣어준다.
					if((map[fishes.get(i).r][fishes.get(i).c]!=0)&&fishes.get(i).size<shark.size) {
						targetfish.add(fishes.get(i));
					}
				}
			}
		}
	}
	//먹을 수 있는 물고기가 여러마리일때 한마리를 정하는 함수
	private static void dist(ArrayList<Fish> targetfish) {
		int mindist=Integer.MAX_VALUE;
		int count=0;
		boolean [][] visited;
		target = new Fish(0, 0, 0,20);
		
		//거리가 가까운 물고기 찾기
		for (int i = 0; i <targetfish.size(); i++) {
			Shark temp=shark;
			visited = new boolean [N][N];
			visited[temp.r][temp.c]=true;
			count=0;
			
			Queue<Shark> q = new LinkedList<>();
			q.offer(temp);
			while (!q.isEmpty()) {
				Shark cur=q.poll();
				
				if((cur.r==targetfish.get(i).r)&&cur.c==targetfish.get(i).c) {
					targetfish.get(i).dist=cur.dist;
					if(cur.dist<mindist)	mindist=cur.dist;
					possible=true;
					break;
				}
					
				for (int j = 0; j < 4; j++) {
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];

					if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] <= temp.size) {
						visited[nr][nc] = true;
						q.offer(new Shark(nr, nc, cur.size, cur.dist+1,cur.eat));
					}
				}
			}
		}
		
		if(mindist==Integer.MAX_VALUE) {
			possible=false;
			return;
		}
		second+=mindist;
		ArrayList<Fish> closefish=new ArrayList<>();
		
		for (int i = 0; i < targetfish.size(); i++) {
			if(mindist==targetfish.get(i).dist) {
				closefish.add(targetfish.get(i));
			}
		}

		//거리가 가까운 물고기가 여러마리
		int top=N;
		if(closefish.size()>1) {
			ArrayList<Fish> topfish=new ArrayList<>();
			for (int i = 0; i < closefish.size(); i++) {
				if(closefish.get(i).r<top) {
					top=closefish.get(i).r;
				}
			}
			for (int i = 0; i < closefish.size(); i++) {
				if(top==closefish.get(i).r) {
					topfish.add(closefish.get(i));
				}
			}
			
			if(topfish.size()>1) {
				//가장 위에 있는 물고기중 가장 왼쪽에 있는 물고기
				int left=N;
				for (int i = 0; i < topfish.size(); i++) {
					if(topfish.get(i).c<left) {
						left=topfish.get(i).c;
						target=topfish.get(i);
					}
				}
			}
			else if(topfish.size()==1)	target=topfish.get(0);
		}
		else if(closefish.size()==1)
			target=closefish.get(0);
	}
	private static boolean check(int r, int c) {
		return r>=0&&r<N&&c>=0&&c<N;
	}

}
