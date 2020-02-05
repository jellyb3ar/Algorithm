package algo_basic.day4;

import java.util.Arrays;

public class nextPermutationTest {
	private static int nums[] = {2,4,3,1};
	public static void swap(int[] nums,int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

	public static void main(String[] args) {
		//TODO: nums의 다음 순열을 구해보자
		//nextPermutation(nums);

		//nums로 만들 수 있는 모든 순열을 뽑아보자.
		Arrays.sort(nums); // 일단 정렬된 처음 상태에서 시작한다.

		do {
			System.out.println(Arrays.toString(nums));
		}while(nextPermutation(nums));
	}
	public static boolean nextPermutation(int nums[]) {
		int i = -1;
		int j = -1;
		//STEP1 : i 찾기
		for(int ii = nums.length-2;ii>=0; ii--) {
			if(nums[ii+1]>nums[ii]) {
				i = ii;
				break;
			}
		}
		//STEP2 : 뒤에서 부터 nums[i] 보다 큰 j 찾기
		if(i!=-1) {
			for(int jj = nums.length-1; jj>i; jj--) {
				if(nums[jj]>nums[i]) {
					j = jj;
					break;
				}
			}

			//STEP3 : swap
			swap(nums, i, j);
			//System.out.println(Arrays.toString(nums));

			//STEP4 : i뒤에 있는 것 reverse
			for(int a = i+1, b = nums.length-1; a<b;a++,b--) {
				swap(nums,a,b);
			}
		}
		if(i == -1)
			return false;
		else
			return true;


	}

}
