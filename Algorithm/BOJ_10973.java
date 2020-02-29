package problem.boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10973 {

	private static int[] arr;
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		arr = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = scan.nextInt();
		}
		if(makePermutation()) {
			for(int i = 0; i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
		}
		else {
			System.out.println(-1);
		}
	}
	
	public static boolean makePermutation() {
		int i,j;
		for(i = arr.length-2;i>=0;i--) {
			if(arr[i+1]<arr[i]) {
				break;
			}
		}
		if(i<0)
			return false;
		
		for(j = arr.length-1;j>=0; j--) {
			if(arr[i]>arr[j]) {
				break;
			}
		}
		swap(i,j);
		
		for(int a = i+1, b = arr.length-1; a<b; a++,b--) {
			swap(a,b);
		}
		return true;
	}
	public static void swap(int a,int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
