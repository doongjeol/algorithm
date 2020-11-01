package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer =

                solution(br.readLine());

        System.out.println(answer);

        br.close();

    }

    public static String solution(String new_id) {
        String answer = new_id;

        // 1단계
        answer = new_id.toLowerCase();

        // 2단계
        answer = answer.replaceAll("[^a-zA-Z0-9_\\-\\.]", "");

        // 3단계
        StringBuilder sb = new StringBuilder(answer);
        for (int i = 0; i < sb.length() - 1; i++) {
            char c = sb.charAt(i);
            char c2 = sb.charAt(i + 1);
            if (c == c2 && c == '.') {
                sb.deleteCharAt(i);
                i = i - 1;
            }
        }

        // 4단계
        if (sb.length() >= 1) {
            if (sb.charAt(0) == '.')
                sb.deleteCharAt(0);
        } else if (sb.length() >= 2) {
            if (sb.charAt(sb.length() - 1) == '.')
                sb.deleteCharAt(0);
        }

        // 5단계
        if (sb.length() == 0) {
            sb.append("a");
        }

        // 6단계
        if (sb.length() >= 16) {
           sb.delete(15, sb.length());
        }
        if(sb.length()>=1) {
            if (sb.charAt(sb.length() - 1) == '.')
                sb.deleteCharAt(sb.length()-1);
        }

        // 7단계
        if (sb.length() >= 1) {
            char c = sb.charAt(sb.length() - 1);
            while (sb.length() <= 2) {
                sb.append(c);
            }
        }
        answer = sb.toString();

        return answer;

    }
}
