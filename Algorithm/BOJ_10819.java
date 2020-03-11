package problem.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10819 {
	private static int visited;
	private static int N;
	private static int[] tmp;
	private static int[] arr;
	private static int max;
	private static int ans;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N];
		tmp = new int[N];
		ans = Integer.MIN_VALUE;
		visited = 0;
		for(int i = 0; i<N;i++) {
			arr[i] = scan.nextInt();
		}
		
		makePermutation(0,tmp,visited);
		System.out.println(ans);
	}

	private static void makePermutation(int cnt, int[] tmp, int visited) {
		if(cnt==N) {
			calc();
			return;
		}
		else {
			for(int i = 0; i<N;i++) {
				if((visited & (1<<i))==0) {
					tmp[cnt] = arr[i];
					makePermutation(cnt+1,tmp,visited|1<<i);
				}
			}
		}
	}

	private static void calc() {
		for(int i = 0; i<N-1;i++) {
			max += Math.abs(tmp[i]-tmp[i+1]);
		}
		ans = Math.max(ans, max);
		max = 0;
	}
}
