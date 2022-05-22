package baekjoon.string;
import java.io.*;
import java.util.Stack;

public class Q_PalindromNumber {
    public static boolean solution(String str,int length){
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < str.length() / 2; i++) {
            stack.add(str.charAt(i) - '0');
        }
        if(length %2 != 0) {
            for (int i = str.length() / 2 + 1; i < str.length(); i++) {
                int s = stack.pop();
                if (s != str.charAt(i) - '0') {
                    return false;
                }
            }
        } else {
            for (int i = str.length() / 2; i < str.length(); i++) {
                int s = stack.pop();
                if (s != str.charAt(i) - '0') {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str.equals("0")) break;

            boolean result = solution(str, str.length());

            if(result){
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        br.close();
        bw.close();
    }
}
