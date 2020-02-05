package com.JA;

import java.util.*;

class Tower {
	int n;
	int h;

	public Tower(int n, int s) {
		this.n = n;
		this.h = s;
	}
}
// 뒤에서부터 보면서 왼쪽방향으로 가장 가까운 자신보다 큰 건물을 찾는 것 => 자신보다 큰 건물 앞은 신경쓰지 않아도 된다. 
public class JA_1809 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Tower> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		int N= scan.nextInt(); 
		int top=0;
		int num=0;
		for(int i=0;i<N;i++) {
			top = scan.nextInt();
			if(stack.isEmpty())
				list.add(0); // 현재 건물보다 낮거나,처음 넣는 것 
			else {
				while(!stack.isEmpty()) {
					if(stack.peek().h < top ) { // 현재보다 작음 -> 앞으로 필요없음!
						stack.pop();
						if(stack.isEmpty())
							list.add(0); // 계속 찾다가 못찾아서 스택이 비면 0
					} else {
						list.add(stack.peek().n); // 스택에 있는 건물이 지금 넣으려는 건물보다 높으면 그 값을 list에 추가
						break;
					}
				}
			}
			stack.push(new Tower(++num,top)); // 현재 것넣기 
			
		}

		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}
}
