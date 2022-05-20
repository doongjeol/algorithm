package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q_9012_PS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            Stack<String> stack = new Stack();
            boolean isVPS = true;
            for (int j = 0; j < str.length(); j++) {
                String c = String.valueOf(str.charAt(j));

                // 여는 괄호이면 stack에 push
                if(c.equals("("))
                    stack.push(c);
                else if(c.equals(")")) {
                    if(!stack.empty()){
                        // stack에 여는 괄호가 존재한다면 stack의 값을 pop
                        stack.pop();
                    } else {
                        // 여는 괄호가 없는데 닫힌 괄호가 나왔으면 false
                        isVPS = false;
                        break;
                    }
                }
            }

            if(!stack.isEmpty())
                isVPS = false;

            if(isVPS)
                System.out.println("YES");
            else
                System.out.println("NO");
        }


    }
}
