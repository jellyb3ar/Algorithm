package com.ssafy.step01.recursive;

import java.util.Scanner;

public class R04_HanoiTest {
	static StringBuilder rst = new StringBuilder();
	private static int n;
	private static int count;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		hanoi(n,1,2,3);
		System.out.println(count);
		System.out.println(rst);
	}
	private static void hanoi(int cnt, int from, int tmp, int to) {
		// cnt : 옮긴 원판 개수 
		if(cnt==0) {
			return;
		}
		// n-1덩어리 원판을 tmp로 옮김 
		// n원판을 to로 옮김 
		// tmp에 있는 것들을 to로 옮김.
			hanoi(cnt-1,from,to,tmp);
			rst.append(from+" "+to+"\n");
			count++;
			hanoi(cnt-1,tmp,from,to);
	}

}
