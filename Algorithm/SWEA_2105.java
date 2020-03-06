package problem.swea;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * 
 * @author sin-yujin
 * 1. 매 칸에서 시작하되, 범위를 벗어나면 종료 
 * 2. 방향을 바꾸면 한 모서리가 끝난 것!! 
 * 3. 앞 두개의 모서리를기억해두고, 그이후에 그것의 반대로 진행해야됨. 
 */
public class SWEA_2105 {
	private static int[][] arr;
	private static boolean[][] visited;
	private static int N;
	private static List<Integer> list;
	private static int dir[][] = {{1,1},{1,-1},{-1,-1},{-1,1}}; //오아 왼아 왼위 오위 
	private static int rst;
	private static int sc;
	private static int sr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N= scan.nextInt();
			arr = new int[N][N];
			rst = -1;
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<N;j++) {
					arr[i][j] = scan.nextInt();
				}
			}
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<N;j++) {
					list = new LinkedList<Integer>();
					visited = new boolean[N][N];
					visited[i][j] = true;
					list.add(arr[i][j]);
					sr = i;
					sc = j;
					dfs(i,j,0);	
					visited[i][j] = false;
				}
			}
			System.out.printf("#%d %d\n",tc,rst);
		}
	}
	private static void dfs(int r, int c, int status) {
		int d = (status+1)%4;
		// 1. 연장 
		int tmpR = r+dir[status][0];
		int tmpC = c+dir[status][1];
		if(tmpR>=0&&tmpR<N&&tmpC>=0&&tmpC<N&&!visited[tmpR][tmpC]) {
			int tmp = arr[tmpR][tmpC];
			if(!list.contains(tmp)) {
				visited[tmpR][tmpC] = true;
				list.add(arr[tmpR][tmpC]);
				dfs(tmpR,tmpC,status);
				visited[tmpR][tmpC] = false;
				list.remove(list.size()-1);
			}
		}
		tmpR = r+dir[d][0];
		tmpC = c+dir[d][1];
		if(tmpR>=0&&tmpR<N&&tmpC>=0&&tmpC<N&&!visited[tmpR][tmpC]) {
			// 2. 다음 
			int tmp = arr[tmpR][tmpC];
			if(!list.contains(tmp)) {
				visited[tmpR][tmpC] = true;
				list.add(arr[tmpR][tmpC]);
				dfs(tmpR,tmpC,d);
				visited[tmpR][tmpC] = false;
				list.remove(list.size()-1);
			}
		}
		if(sr == tmpR && sc == tmpC && status == 3) {
			rst = Math.max(rst, list.size());
			return;
		}
		else {
			return;
		}
	}
}
