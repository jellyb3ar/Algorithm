package problem.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115 {
	private static int C;
	private static int M;
	private static int N;
	private static int[][] map; //입력된 정보 
	private static int[][] maxMap; // i, j위치에서 가질 수 있는 최대 이익 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken()); // 수용 가능량 
			map = new int[N][N];
			maxMap = new int[N][N];
			for(int i = 0; i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input

			// 1.각 i,j위치에서 연속된 M개를 고려하여 취할 수 있는 부분집합의 최대 이익 계산
			makeMaxMap();
			// 2. 두 일꾼의 조합 
			System.out.printf("#%d %d\n",tc,getMaxBenefit());
		}

	}
	private static int getMaxBenefit() {
		int max = 0; int temp = 0;
		// 1. 일꾼A 기준 선택
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<=N-M;j++) {
				// 2. 일꾼 B의 선택 
				// 같은 행 기준 선택
				for (int j2 = j+M; j2 <= N-M; j2++) {
					temp = maxMap[i][j] + maxMap[i][j2]; // 두 일꾼 조합의 최대이익
					if(max < temp) {
						max = temp;
					}
				}
				//다음행부터 마지막행까지 선택 
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						temp = maxMap[i][j] + maxMap[i2][j2];
						if(max < temp) {
							max = temp;
						}
					}
				}
			}
			
		}
		return max;
	}
	
	private static void makeMaxMap() {
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<=N-M;j++) {
				makeMaxSubset(i,j,0,0,0);
			}
		}
	}

	private static void makeMaxSubset(int i, int j,int cnt,int sum,int powSum) { // 연속되게 고민해봤는지 원소의 수 
		if(sum>C) return; // 목표량 넘어가면 가지치기 
		if(cnt== M) { //연속된 M까지 다 봄 

			if(maxMap[i][j-M]<powSum) {
				maxMap[i][j-M] = powSum;
				
			}
			return;
		}
		
		// 선택
		makeMaxSubset(i,j+1,cnt+1,sum+map[i][j],powSum+(int)Math.pow(map[i][j], 2));
		// 비선택
		makeMaxSubset(i,j+1,cnt+1,sum,powSum);
		
	}
}