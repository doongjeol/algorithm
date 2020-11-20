package baekjoon.dp;
import java.io.*;

public class Q_2193_PinaryNumber {
    public static long solution(int n){
        long[][] a = new long[n+1][n+1];

        a[1][0] = 0; a[1][1] = 1;

        for (int i = 2; i < n; i++) {
            a[i][0] = a[i - 1][0] + a[i - 1][1];
            a[i][1] = a[i - 1][0];
        }
        long result = 0;

        if(n == 1)
            result = 1;
        else
            result = a[n-1][0] * 2 + a[n-1][1];

        return result;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(solution(n)+"\n");

        br.close();
        bw.close();
    }
}
