package problem.swea;

import java.util.Scanner;
public class SWEA_2814 {
	
	private static int M;
	private static int N;
	static int[][] adj;
	private static int ans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = scan.nextInt(); // 정점의 개수 
			M = scan.nextInt(); // 간선의 개수
			adj = new int[N+1][N+1];
			visited = new boolean[N+1];
			for(int i = 0; i<M;i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				adj[a][b] = 1;
				adj[b][a] = 1;
			}
			ans = 0;
			for(int i = 1; i<=N;i++) {
				visited[i] = true;
				dfs(i,1);
				visited[i] = false;
				
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	static boolean visited[];
	static void dfs(int v, int cnt) {
		// 더이상 방문할 노드가 없음. 
		ans = Math.max(ans, cnt);
		// 나와 간선이 존재하고, 아직 방문하지 않았으면 .
		for(int i = 1; i<=N;i++) {
			if(adj[v][i]==1 && !visited[i]) {
				visited[i] = true;
				dfs(i,cnt+1);
				visited[i] = false;
			}
		}
	}
}
