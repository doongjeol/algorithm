package baekjoon.string;
import java.io.*;
import java.util.HashSet;

/*
조건 1 : 30의 배수는 무조건 뒤에 최소한 한 개 이상의 0을 가지고 있어야한다.
조건 2 : 각 자리수의 합이 3의 배수여야한다.

자리수가 10^5개
* */

public class Q_10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int sum = 0; // 각 자리의 숫자의 합
        boolean isPossible = false; // 30의 배수가 가능한 지 판단여부

        int[] numCountArr = new int[10]; // 0부터 9까지 각 숫자가 몇 개있는 지 담는 배열
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            if(num == 0){
                isPossible = true;
            }
            numCountArr[num] += 1;
            sum += num;
        }

        if (!isPossible || sum % 3 != 0) {
            bw.write("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            /* 9부터 0까지 갖고 있는 숫자만큼 문자열을 연결해준다.
            예를 들어, 8을 3개, 3을 2개 갖고 있다면 88833 으로 StringBuilder에 넣어준다.
             */
            for (int i = 9; i >=0 ; i--) {
                while (numCountArr[i] > 0){
                    sb.append(i);
                    numCountArr[i]--;
                }
            }

            bw.write(sb.toString());
        }

        br.close();
        bw.close();
    }
}
