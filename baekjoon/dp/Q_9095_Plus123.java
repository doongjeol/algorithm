package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_9095_Plus123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(solution(num));
        }

    }

    public static int solution(int num){
        int[] a = new int[12];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 4;

        for (int i = 4; i <= num; i++) {
            a[i] = a[i - 2] + a[i - 1] + a[i - 3];
        }

        return a[num];
    }
}
