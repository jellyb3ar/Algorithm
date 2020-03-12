package problem.swea;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class SWEA_7701 {
// TreeSet : 중복제거 가능! 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = scan.nextInt();
			TreeSet<String>name = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int len1 = o1.length();
					int len2 = o2.length();
					if(len1 == len2) {
						return o1.compareTo(o2);
					}else {
						return len1-len2;
					}
				}
			});
			for(int i = 0; i<N;i++) {
				name.add(scan.next());
			}
			System.out.printf("#%d\n",tc);
			
			for (String string : name) {
				System.out.println(string);
			}
		}
	}

}
