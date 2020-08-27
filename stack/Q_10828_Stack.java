package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_10828_Stack {
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = "";
            int integer = 0;
            if(st.countTokens() == 2) {
                command = st.nextToken();
                integer = Integer.parseInt(st.nextToken());
                solution(command, integer);
            } else{
                command = st.nextToken();
                solution(command,integer);
            }
        }

    }

    public static void solution(String text, int num){
        switch (text){
            case "push":
                stack.push(num);
                break;
            case "pop":
                if(!stack.isEmpty())
                    System.out.println(stack.pop());
                else System.out.println(-1);
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                if(!stack.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(1);
                break;
            case "top":
                if(!stack.isEmpty())
                    System.out.println(stack.peek());
                else
                    System.out.println(-1);
                break;
        }
    }
}
