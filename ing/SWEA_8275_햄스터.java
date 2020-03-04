package problem.swea;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 조건 
 * 1. M번 만족하는 배치가 여러개이면 합계가 많은 것!
 * 2. 사전 순
 * 3. -1
 */
public class SWEA_8275_햄스터 {
	private static int[] cage; // 가능한 모든 햄스터 배치 해봄
	private static int[] output;
	private static int N;
	private static int X;
	private static int M;
	private static int flag = 0;
	private static int input[][];
	static int max; // 가능하다면 합이 최대 되는 경우 선택 
	private static int ans;
	private static int total;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			N = scan.nextInt(); // 우리 수 
			X = scan.nextInt(); // 한 우리당 최대 햄스터 수 
			M = scan.nextInt(); 
			cage = new int[N+1]; // cage 번호 1~N까지 
			output = new int[N+1]; // cage 번호 1~N까지 
			input = new int[M][3];
			flag = 0;
			ans = 0;
			total = Integer.MIN_VALUE;
			for(int i = 0; i<M;i++) {
				input[i][0] = scan.nextInt();
				input[i][1] = scan.nextInt();
				input[i][2] = scan.nextInt();
				ans += Math.pow(2, i);
			}
			permutation(1,0);
			if(total == Integer.MIN_VALUE) {
				System.out.printf("#%d %d\n",tc,-1);
			}
			else {
				System.out.printf("#%d ",tc);
				for(int i = 1; i<output.length;i++) {
					System.out.print(output[i]+" ");
				}
				System.out.println();
			}
		}
	}

	static void permutation(int idx, int sum) {
		if(idx == cage.length) {
			if(check()&& flag == ans) {
				//System.out.println(flag);
				if(total<sum) {
					output = Arrays.copyOfRange(cage, 0, cage.length);
					total = sum;
				}
				flag = 0;
			}
			return;
		}

		for(int i = 0; i<=X; i++) {
			cage[idx] = i;
			permutation(idx+1, sum + i);
		}
	}

	static boolean check() {
		for(int i = 0; i<M;i++) {
			int tmp = 0;
			for(int j = input[i][0]; j<=input[i][1];j++) {
				tmp += cage[j];
				if(tmp>input[i][2]) {
					return false;
				}
				else if(tmp==input[i][2]) {
					flag = flag|(1<<i);	
				}
			}
		}
		return true;
	}
}
