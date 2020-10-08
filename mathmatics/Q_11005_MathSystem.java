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

        while (share > 0) {
            rest = share % b;
            share = share / b;

            if(rest<10)
                stack.add(String.valueOf(rest));
            else
                stack.add(String.valueOf((char)(rest-10+(int)'A'))); // A에서 아스키코드 reset만큼 char형으로 변환, 10부터 char형 변환이므로 -10

        }

    }
}
