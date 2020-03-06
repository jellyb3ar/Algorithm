package problem.swea;

import java.util.Arrays;
import java.util.Scanner;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
public class SWEA_1247 {
	private static int index[];
	private static int ans;
	private static int N;
	private static Point[] arr;
	private static Point home;
	private static Point company;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			ans = Integer.MAX_VALUE;
			N = scan.nextInt();
			company = new Point(scan.nextInt(),scan.nextInt());
			home = new Point(scan.nextInt(),scan.nextInt());
			arr = new Point[N];
			index = new int[N];
			for(int i = 0; i<N;i++) {
				arr[i] = new Point(scan.nextInt(), scan.nextInt());
				index[i] = i;
			}
			Permutation(N,0,new int[N],0);
			System.out.printf("#%d %d\n",tc,ans);
		} //end of Test Case

	}
	public static void Permutation(int r, int current, int tmp[], int visit) {
		if(r==current) {
			int sum = Math.abs(company.x-arr[tmp[0]].x)+Math.abs(company.y-arr[tmp[0]].y);
			for(int i= 0; i<N-1;i++) {
				sum += Math.abs(arr[tmp[i]].x-arr[tmp[i+1]].x)+Math.abs(arr[tmp[i]].y-arr[tmp[i+1]].y);
			}
			sum += Math.abs(home.x-arr[tmp[N-1]].x)+Math.abs(home.y-arr[tmp[N-1]].y);
			ans = Math.min(ans, sum);
			return;
		}
		else {
			for(int i = 0; i<tmp.length;i++) {
				if((visit&(1<<i))==0) {
					tmp[current] = index[i];
					Permutation(r,current+1,tmp,visit|(1<<i));
				}
			}
		}
	}

}
