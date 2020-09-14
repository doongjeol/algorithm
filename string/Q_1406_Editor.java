package string;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_1406_Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());

        // LIFO
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // 왼쪽 스택에 입력받은 문자열을 모두 넣는다
            left.push(String.valueOf(str.charAt(i)));
        }
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command =  st.nextToken();
            String c = "";

            switch (command) {
                case "L":
                    // 왼쪽 스택을 pop(LIFO이므로 스택의 마지막 것이 pop)해 오른쪽 스택에 push
                    // abcd| - left : abcd  right : => left : abc  right : d
                    if(!left.isEmpty())
                        right.push(left.pop());
                    break;
                case "D":
                    // 오른쪽 스택을 pop(LIFO이므로 스택의 마지막 것이 pop)해 오른쪽 스택에 push
                    // abc|d - left : abc  right : d => left : abcd  right :
                    if(!right.isEmpty())
                        left.push(right.pop());
                    break;
                case "B":
                    if(!left.isEmpty())
                        left.pop();
                    break;
                case "P":
                    left.push(st.nextToken());
                    break;
            }
        }


        // left : abc right : d
        // => right : dcba
        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while(!right.isEmpty()){
            bw.write(right.pop());
        }

        br.close();
        bw.close();
    }
}
