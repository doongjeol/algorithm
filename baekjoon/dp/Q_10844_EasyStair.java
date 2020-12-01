package baekjoon.dp;
import java.io.*;

public class Q_10844_EasyStair {
    public static long solution(int n) {
        long[][] a  = new long[n+1][10];

        // n이 1일 때 1로 초기화
        for (int col = 1; col <= 9; col++) {
            a[1][col] = 1;
        }

        for (int row = 2; row <= n; row++) {
            for (int col = 0; col <= 9; col++) {
                if(col == 0)
                    a[row][col] = a[row - 1][col + 1];
                else if(col == 9)
                    a[row][col] = a[row - 1][col - 1];
                else
                    a[row][col] = a[row - 1][col - 1] + a[row - 1][col + 1];
                a[row][col] %= 1000000000;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += a[n][i];
        }

        result %= 1000000000;

        return result;

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
