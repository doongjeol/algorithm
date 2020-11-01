package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10808_NumOfAlphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arry = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int position =
                    str.charAt(i) - 97; // a의 아스키코드 10진수가 07

            arry[position] += 1;
        }

        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i]+" ");
        }

    }

}
