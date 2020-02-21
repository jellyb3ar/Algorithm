package algo.study;

import java.util.Arrays;

public class makeCombinationTest {
	static int comb[][] = new int[1001][1001];
	static int[] nums = {1,2,3,4,5};
	public static void main(String[] args) {
		calcCombination();
		//System.out.println(comb[5][3]);
		makeCombination(3,5,new int[3]);
		System.out.println("---------------------------------------");
		makeCombination(3,new int[3], 0);
	}

	private static void makeCombination(int r, int n, int tmp[]) {
		if(r==0) {
			System.out.println(Arrays.toString(tmp));
		}
		else if(n<r){ // n개중에 r개를 뽑는데, 개수를 넘겼으니까.
			return;
		}
		else {
			tmp[r-1] = nums[n-1]; // tmp에 넣기.
			makeCombination(r-1,n-1,tmp);
			makeCombination(r,n-1,tmp);
		}
	}
	
	private static void makeCombination(int r, int tmp[], int start) {
		// 방문했으면 안가기.
		// base case
		if(r==0) {
			System.out.println("visited : "+Arrays.toString(tmp));
		}
		else {
			for(int i = start; i< nums.length; i++) {
				tmp[r-1] = nums[i];
				makeCombination(r-1, tmp, i+1);
			}
		}
	}
	private static void calcCombination() {
		comb[0][0] = 1;
		for(int i =1; i<=1000;i++) {
			for(int j = 0; j<=1000; j++) {
				if(j==0) {
					comb[i][j] = 1;
				}
				else {
					comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
				}
			}
		}
	}
}
