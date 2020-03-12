package algo.JA;

import java.util.Scanner;
// 주사위 던지기!! 
public class JA_1169 {
	public static int dice[] = {1,2,3,4,5,6};
	public static int rst[];
	private static int N;	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		int M = scan.nextInt();
		rst = new int[N];
		switch(M) {
		case 1: // 중복 순열
			dice1(0,rst);
			break;

		case 2:
			dice2(0,rst,0); // 중복 조합 
			break;

		case 3: // 모든 다른 수
			dice3(0,rst,0);
			break;
			
		case 4: // 조합 
			dice4(0,6,rst,0);
			break;
		}
	}
	private static void dice4(int r, int n, int rst[],int cur) {
		if(r==N) {
			for(int i = 0; i<N;i++) {
				System.out.print(rst[i]+" ");
			}
			System.out.println();
			return;
		}
		if(r>n)
			return;
		else {
			for(int i = cur; i<6;i++) {
				rst[r] = dice[i];
				dice4(r+1,n,rst,i);
			}
		}
	}
	private static void dice3(int cnt, int rst[], int visited) {
		if(cnt==N) {
			for(int i = 0; i<N;i++) {
				System.out.print(rst[i]+" ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i = 0; i<6;i++) {
				if((visited & (1<<i))==0) {
					rst[cnt] = dice[i];
					dice3(cnt+1,rst,visited|1<<i);
				}
			}
		}

	}
	private static void dice2(int cnt,int rst[], int cur) {
		if(cnt==N) {
			for(int i = 0; i<N;i++) {
				System.out.print(rst[i]+" ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i = cur; i<6;i++) {
				rst[cnt] = dice[i];
				dice2(cnt+1,rst,i);
			}
		}


	}
	private static void dice1(int cnt, int rst[]) {
		if(cnt==N) {
			for(int i = 0; i<N;i++) {
				System.out.print(rst[i]+" ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i = 0; i<6;i++) {
				rst[cnt] = dice[i];
				dice1(cnt+1,rst);
			}
		}


	}
}
