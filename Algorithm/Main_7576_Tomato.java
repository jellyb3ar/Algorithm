package problem.boj;

import java.util.*;
class Tomato{
	int x;
	int y;
	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main_7576_Tomato {
	static int dx[] = {-1,1,0,0}; // 상 하 좌 우 
	static int dy[] = {0,0,1,-1}; // 상 하 좌 우  

	private static int[][] arr;
	private static int N;
	private static int M;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		M = scan.nextInt(); //garo
		N = scan.nextInt(); //sero
		
		arr = new int[N][M];
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		
		BFS(arr,N,M);
	}
	public static void BFS(int arr[][], int S,int G) {
		Queue<Tomato> q = new LinkedList<Tomato>();
		
		for(int i = 0; i<S;i++) {
			for(int j = 0; j<G; j++) {
				if(arr[i][j] == 1) {
					q.add(new Tomato(j,i));
					// 익은 토마토가 있으면 모든 위치를 큐에 담는다. 
				}
			}
		}
		
		while(!q.isEmpty()) {
			// 상하좌우 다음에 익기 때문에 큐에 담아둔다.
			Tomato to = q.poll();
			for(int i = 0; i<dx.length;i++) {
				int x = to.x + dx[i];
				int y = to.y + dy[i];
				
				if(x<0 || y<0 || x>=M ||y>=N) // 범위 넘어가면
					continue;
				if(arr[y][x] != 0) // 익지 않은 토마토 
					continue;
				
				arr[y][x]= arr[to.y][to.x]+1;
				q.add(new Tomato(x,y)); // 다음 것 넣어주
				
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, arr[i][j]);
			}
		}
		System.out.println(max-1);
	}
}
