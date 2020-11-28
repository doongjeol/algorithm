package baekjoon.dp;
import java.io.*;

public class Q_10844_EasyStair {
    public static int solution(int n) {
        int[] a  = new int[n+1];
        int[] k = new int[n];
        k[1] = 1; k[2] = 2;
        a[1] = 9;
        for (int i = 3; i < n; i++) {
//            k[i] = k[k-2] +
        }

        for (int i = 2; i <= n; i++) {
            a[i] = a[i-1] * 2 - k[i-1];
            a[i] %= 1000000000;
        }

        return a[n];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(solution(n)+"\n");

        br.close();
        bw.close();
    }
}
