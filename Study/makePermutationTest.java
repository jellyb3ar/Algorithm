package algo.study;

import java.util.Arrays;

public class makePermutationTest {
	private static int[] nums = {1,2,3,4,5};
	public static void main(String[] args) {
		nextPermutationNP(); // 사전순 가능.
		System.out.println("---------------------------------");
		makePermutation(5,new int[5], new boolean[5]);
	}
	
	public static void makePermutation(int r, int tmp[], boolean visited[]) {
		if(r==0) {
			System.out.println(Arrays.toString(tmp));
		}else {
			for(int i = 0; i<nums.length;i++) {
				if(!visited[i]) {
					visited[i] = true;
					tmp[r-1] = nums[i];
					makePermutation(r-1,tmp,visited);
					visited[i] = false;
				}
			}
		}
	}
	
	
	public static void nextPermutationNP() {
		Arrays.sort(nums);
		do {
			System.out.println(Arrays.toString(nums));
		}while(nextPermutation());
	}
	public static boolean nextPermutation() {
		int i, j;
		for(i = nums.length-2; i>=0; i--) {
			if(nums[i]<nums[i+1]) {
				break;
			}
		}
		/***/
		if(i<0) {
			return false;
		}
		
		for(j = nums.length-1; j>=0; j--) {
			if(nums[i]<nums[j]) {
				break;
			}
		}
		
		swap(i,j);
		// i 뒤부터 reverse 
		for(int s = i+1,end = nums.length-1;s<end; s++,end--) {
			swap(s,end);
		}
		return true;
	}
	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
