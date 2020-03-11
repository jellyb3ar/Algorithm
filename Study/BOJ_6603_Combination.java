package problem.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_6603 {
	public static int tmp[] = new int[6];
	private static int N;
	private static int[] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			N = scan.nextInt();
			if(N==0)
				System.exit(0);
			arr = new int[N];
			for(int i = 0; i<N;i++) {
				arr[i] = scan.nextInt();
			}
			
			makeCombination(6,new int[6], 0);
			System.out.println();
		}
	}
	private static void makeCombination(int r, int tmp[], int start) {
		// 방문했으면 안가기.
		// base case
		if(r==0) {
			for(int i = tmp.length-1; i>=0;i--) {
				System.out.print(tmp[i]+" ");
			}
			System.out.println();
		}
		else {
			for(int i = start; i< arr.length; i++) {
				tmp[r-1] = arr[i];
				makeCombination(r-1, tmp, i+1);
			}
		}
	}
		
	}


