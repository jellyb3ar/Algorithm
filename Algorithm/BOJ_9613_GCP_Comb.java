package problem.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9613 {
	private static long sum;
	private static int[] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int tc = 0; tc<t; tc++) {
			sum = 0;
			int n = scan.nextInt();
			arr = new int[n];
			for(int i = 0; i<n;i++) {
				arr[i] = scan.nextInt();
			}
			combination(2,n,new int[2]);
			System.out.println(sum);
		}
	}
	public static void combination(int r, int n, int[] tmp) {
		if(r==0) {
			//System.out.println(Arrays.toString(tmp));
			sum += gcd(tmp[0],tmp[1]);
		}
		else if(r>n)
			return;
		else {
			tmp[r-1] = arr[n-1];
			combination(r-1,n-1,tmp);
			combination(r,n-1,tmp);
		}
	}
	public static long gcd(long a, long b) {
		long tmp;
		while(b>0) {
			tmp = b;
			b = a%b;
			a = tmp;
		}
		return a;
	}
}
