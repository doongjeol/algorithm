package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_10828_Stack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack stack = new Stack();
		String insert = "";
		StringTokenizer st;
		
		for(int i=0; i<N ; i++) {
			insert = br.readLine();
			st = new StringTokenizer(insert);
			if(st.nextToken().equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if(insert.equals("pop")) {
				if(stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
			} else if(insert.equals("size")) {
				System.out.println(stack.size());
			} else if(insert.equals("empty")) {
				if(stack.empty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if(insert.equals("top")) {
				if(stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
			}
		}
	}
}
