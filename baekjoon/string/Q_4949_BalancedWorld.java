package baekjoon.string;
import java.io.*;
import java.util.Stack;

public class Q_4949_BalancedWorld {
    public static boolean solution(String str){
        Stack<String> stack = new Stack();
        boolean isPossible = true;

        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));

            // 여는 괄호이면 stack에 push
            if(c.equals("(") || c.equals("[")){
                stack.push(c);
            // 닫는 소괄호일 경우
            } else if(c.equals(")")){
                // 스택이 비어있거나 peek한 값이 여는 소괄호가 아닌 경우
                if(stack.empty() || !stack.peek().equals("(")){
                    return false;
                // stack에 여는 괄호가 존재한다면 스택의 값을 pop
                } else {
                    stack.pop();
                }

            // 닫는 대괄호일 경우
            } else if(c.equals("]")){
                // 스택이 비어있거나 peek한 값이 여는 대괄호가 아닌 경우
                if(stack.empty() || !stack.peek().equals("[")){
                    return false;
                // stack에 여는 괄호가 존재한다면 스택의 값을 pop
                } else {
                    stack.pop( );
                }
            }
        }

        if(!stack.empty())
            return false;


        return isPossible;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str.charAt(0) == '.'){
                break;
            }

            boolean isPossible = solution(str);
            if(isPossible){
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }

        }

        br.close();
        bw.close();
    }

}
