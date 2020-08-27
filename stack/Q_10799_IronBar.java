package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q_10799_IronBar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<String> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            String character = String.valueOf(str.charAt(i));

            // 여는 괄호는 stack에 push
            if (character.equals("(")) {
                stack.push(character);
            } else if (character.equals(")")) {
                String characterPrev = String.valueOf(str.charAt(i - 1));
            stack.pop(); // 여는 괄호 pop
                if (characterPrev.equals("(")) {
                    // 바로 전이 여는 괄호면 레이저
                    // 남아있는 괄호가 막대기의 수이므로 size로 계산
                    result += stack.size();
                } else {
                    // 레이저가 아닐 때
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }
}
