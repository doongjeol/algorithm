package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_9012_PS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            Stack<String> s1 = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                s1.push(String.valueOf(str.charAt(j)));
            }
        }

    }
}
