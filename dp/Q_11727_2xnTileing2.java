package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11727_2xnTileing2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] a = new int[1001];
        a[0] = 1;
        a[1] = 1;

        for (int i = 2; i <= num; i++) {
            a[i] = a[i - 2] * 2 + a[i - 1];
            a[i] %= 10007;
        }

        System.out.println(a[num]);

    }

}
