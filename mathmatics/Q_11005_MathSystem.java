package mathmatics;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_11005_MathSystem {
    static Stack<String> stack = new Stack();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        solution(n, b);
        while(!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        br.close();
        bw.close();
    }

    public static void solution(int n, int b) {

        int share = n;
        int rest = 0;

        while (share >= b) {
            rest = share % b;
            share = share / b;

            char c = (char) (b + 55);
            if(b>=10 && b<36)
                stack.add(String.valueOf(c));
//            else if(b==36) {
//                c = (char) (b + 54);
//                stack.add(String.valueOf(c));
//            }
            else
                stack.add(String.valueOf(rest));

            if(share < b){
                if(b>=10 && b<36)
                    stack.add(String.valueOf(c));
                else if(b==36) {
                    c = (char) (b + 54);
                    stack.add(String.valueOf(c));
                }
                else
                    stack.add(String.valueOf(share));
            }
        }

    }
}
