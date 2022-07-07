package programmers.mathmatics;

import java.util.HashMap;

public class Q_12899_124World {
    public static String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        int num = n;

        while (num > 0) {
            int rest = num % 3;
            num /= 3;

            if(rest == 0) num --;

            answer = numbers[rest] + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }
}
