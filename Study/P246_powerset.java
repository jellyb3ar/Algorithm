package com.book;

import java.util.Arrays;

public class P246_powerset {
	static int [] src = {1,2,3,4,5,6,7,8,9,10};
	//각 원소의 포함 여부를 저장할 배열
	static boolean status[] = new boolean[src.length]; // 선택했는지 저장
	static boolean candidates[] = {true, false}; // 써볼 수 있는 것
	static int cnt = 0; // 몇번이나 불림?
	static int target = 10;
	public static void dfs(int r, int sum) {
		if(sum==target) {
			print();
			return;
		}else if(sum>target) {
			//System.out.println("가볼 필요 없다.");
			return;
		}
		if(r==src.length) {
			return;
		}
		else {
			for(int i =0 ; i<candidates.length;i++) {
				status[r] = candidates[i];
				cnt++;
				dfs(r+1, sum+(status[r]?src[r]:0));
			}
		}
	}
	public static void print() {
		for(int i = 0; i<status.length;i++) {
			if(status[i]) {
				System.out.print(src[i]+" ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		dfs(0,0);
	}
}
