package problem.boj;

import java.util.Scanner;
// 비트마스크 연습 !!
public class BOJ_11723_bitmasking {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		for(int i = 0; i<M;i++) {
			String str = scan.next();
			int x = 0;
			switch(str) {
				case "add":
					x = scan.nextInt();
					ans = ans |(1<<x);
					break;
				case "remove":
					x = scan.nextInt();
					ans = ans & ~(1<<x);
					break;
				case "check":
					x = scan.nextInt();
					int check = ans & (1<<x);
					if(check == 0) {
						sb.append("0\n");
					}else {
						sb.append("1\n");
					}
					break;
				case "toggle":
					x = scan.nextInt();
					ans ^= (1<<x);
					break;
				case "all":
					ans = (1<<21)-1;
					break;
				case "empty":
					ans = 0;
					break;
					
			}
		}
		System.out.println(sb);
	}
}
