package baekjoon.mathmatics;

import java.io.*;
import java.util.StringTokenizer;

public class Q_1850_GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long max = Math.max(a, b);
        long min = Math.min(a, b);

        for (int i = 0; i < gcd(max, min); i++) {
            bw.write("1");
        }
        bw.write("\n");

        br.close();
        bw.close();

    }

    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = a;
            a = b;
            b = temp%a;
        }

        return a;
    }
}
