import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int [][] map;
	static boolean [][] visited;
	static boolean result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <=10; test_case++) {
			int startY=0,startX=0;
			int endY=0,endX=0;
			int N=Integer.parseInt(br.readLine());
			result=false;
			map=new int[16][16];
			visited=new boolean[16][16];
			
			for (int i = 0; i < 16; i++) {
				String s =br.readLine();
				for (int j = 0; j <16; j++) {
					map[i][j]=s.charAt(j)-'0';
					if(map[i][j]==2) {
						startY=i;
						startX=j;
;					}
					else if(map[i][j]==3) {
						endY=i;
						endX=j;
					}
				}
			}
			visited[startY][startX]=true;;
			miro(startY,startX,endY,endX);
			System.out.println("#"+test_case+" "+(result==true?1:0));
		}
	}
	private static void miro(int startY,int startX,int endY,int endX) {
		if(startY==endY&&startX==endX) {
			result=true;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(result)	return;
			int nr=startY+dr[i];
			int nc=startX+dc[i];
			
			if(check(nr,nc)&&!visited[nr][nc]&&(map[nr][nc]==0||map[nr][nc]==3)) {
				visited[nr][nc]=true;
				miro(nr,nc,endY,endX);
				visited[nr][nc]=false;
			}
		}
	}
	private static boolean check(int r, int c) {
		return r>=0&&r<16&&c>=0&&c<16;
	}
}
