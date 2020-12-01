package baekjoon.dp;
import java.io.*;

public class Q_11057_UphillNum {
    public static long solution(int n){
        long[][] a = new long[n + 1][10];

        for (int i = 0; i <= 9; i++) {
            a[1][i] = 1;
        }

        for (int row = 2; row <= n; row++) {
            for (int col = 0; col <= 9; col++) {
                for(int i=0 ; i<=col ; i++)
                    a[row][col] += a[row - 1][i];
                a[row][col] %= 10007;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += a[n][i];
        }
        result %= 10007;

        return result;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(solution(n) +"\n");

        br.close();
        bw.close();
    }
}
