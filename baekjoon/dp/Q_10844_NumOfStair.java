package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10844_NumOfStair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] a = new int[101];
        a[0] = 0;
        a[1] = 9;

        for (int i = 2; i <= num; i++) {
            a[i] = a[i - 1] * 2 - (i - 1);
        }
        System.out.println(a[num]);
    }
}
