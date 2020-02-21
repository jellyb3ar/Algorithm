import java.util.Scanner;

public class BOJ_4963_섬의개수 {
	private static int[][] arr;
	private static int cnt = 0;
	private static int dr[] = {1,-1,0,0,1,1,-1,-1}; // 하 상 우 좌 오아 왼아 오위 왼위
	private static int dc[] = {0,0,1,-1,1,-1,1,-1};
	private static int h;
	private static int w;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			cnt = 0;
			w = scan.nextInt();
			h = scan.nextInt();
			arr = new int[h][w];

			for(int i = 0; i<h;i++) {
				for(int j = 0; j<w; j++) {
					arr[i][j] = scan.nextInt();
				}
			}

			for(int i = 0; i<h; i++) {
				for(int j = 0; j<w; j++) {
					if(arr[i][j] == 1) {
						check(i,j);
						cnt++;
					}
				}
			}
			if(w ==0 && h == 0) {
				System.exit(0);
			}

			System.out.println(cnt);


		} // end of tc
	}// end of main

	static void check(int r, int c) {
		arr[r][c] = 0;
		/*for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[r].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		 */
		for(int d = 0; d<dr.length; d++) {
			int y = dr[d]+r;
			int x = dc[d]+c;

			if(y>=0&&y<h&&x>=0&&x<w&&arr[y][x]==1) {

				check(y,x);

			}
		}
		//	
	}



}// end of class
