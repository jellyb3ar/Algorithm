package problem.boj;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407_BigInteger {
	public static BigInteger[][] comb = new BigInteger[101][101];
	private static int n;
	private static int m;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		comb[0][0] = BigInteger.ONE;
		
		for(int i = 1; i<=n;i++) {
			for(int j = 0; j<=i;j++) {
				if(j==0 || i==j)
					comb[i][j] = BigInteger.ONE;
				else {
					BigInteger big1 = new BigInteger("0"); // 0으로 객체 생성후 값을 더하기 
					BigInteger big2 = new BigInteger("0");
					big1 = big1.add(comb[i-1][j]);
					big2 = big2.add(comb[i-1][j-1]);
					
					comb[i][j] = big1.add(big2);
				}
			}
		}
		System.out.println(comb[n][m]);
	}
		
	
	
		
}
