package com.swea;

import java.util.*;

// 전위 표기식 input을 받아 후위표기식으로 전환 후 계산하
public class SWEA_1224 {
	static List<Character> postfix;
	static Stack<Character> st;
	static Stack<Integer> Ist;
	
	public static int getInstOrder(char c) {
		if(c=='*'||c=='/') {
			return 4;
		}
		else if(c=='+' || c=='-') {
			return 3;
		}
		else if(c=='(' || c==')') {
			return 1;
		}
		else {
			return 0;
		}
	}

	public static List<Character> postfix(String str) {
		/*for(int s = 0; s<str.length();s++) {
			char c = str.charAt(s);

			if(c=='(')
				st.push(c);
			else if(getInstOrder(c)==0){ // 숫자일 
				postfix.add(c);
			}
			else if(c==')') {
				while(true) {

					char top = st.pop();
					if(top=='(')
						break;
					else
						postfix.add(top);
				}
			}
			else { //비교해야될 경우 
				while(!st.isEmpty()&&true) {
					char top = st.peek(); // 빼야될지 여부 아직 판단 불
					if(getInstOrder(c)>=getInstOrder(top)) { //st안의 것이 더 작거나 같으면 pop(같을 땐 현재 들어오는 애가 더큼)
						postfix.add(st.pop());
					}
					else {
						st.push(c);
					}
				}
				//조건이 맞게 되었다면 현재 아이 넣기 
				st.push(c);
			}
		}*/
		postfix = new ArrayList<>();
		st = new Stack<>();
		for(int i = 0; i<str.length();i++) {
			char token = str.charAt(i);
			int tokenOrder = getInstOrder(token);

			if(tokenOrder == 0) { // 숫자
				postfix.add(token);
			}else if(token=='(') {
				st.push(token);
			}else if(token==')') {
				while(true) {
					char top = st.pop();
					if(top=='(') {
						break;
					}else {
						postfix.add(top);
					}
				}
			}else {
				while(!st.isEmpty() && true) {
					char top = st.peek(); // 빼야할지는 모름
					if(getInstOrder(top)>=tokenOrder) {
						postfix.add(st.pop());
					}
					else {
						break;
					}
				}
				// 모든 제거가 끝났다면
				st.push(token);
			}

		}
		// 모든 비교가 끝났으므로 List에 넣기 
		while(!st.isEmpty()) {
			postfix.add(st.pop());
		}
		System.out.println(postfix);
		return postfix;
	}
	
	public static void calc(List<Character> postfix) {
		Ist = new Stack<>();
		for(int i = 0; i<postfix.size(); i++) {
			char token = postfix.get(i);
			if(getInstOrder(token)==0) { // 숫자
				Ist.push(token-'0');
			}
			else{
				int a = st.pop();
				int b = st.pop();
				if(postfix.get(i)=='-') {
					b = b-a;
					Ist.push(b);
				}
				else if(postfix.get(i)=='+') {
					b = b+a;
					Ist.push(b);
				}
				else if(postfix.get(i)=='*') {
					b = b*a;
					Ist.push(b);
				}
				else if(postfix.get(i)=='/') {
					b = b/a;
					Ist.push(b);
				}
				}
		}
		System.out.println(Ist.pop());
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int tc = 1; tc<=10; tc++) {
			int l = scan.nextInt();
			String str = scan.next();
			//int l = 11;
			//String str = "6+5*(2-8)/2";
			//System.out.format("#%d %d",tc,calc(postfix(str)));
			calc(postfix(str));
		}
	}

}
