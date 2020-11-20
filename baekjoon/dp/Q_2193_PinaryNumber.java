package baekjoon.dp;
import java.io.*;

public class Q_2193_PinaryNumber {
    public static int solution(int n){
        int[][] a = new int[n+1][n+1];

        a[1][0] = 0; a[1][1] = 1;
        a[2][0] = 1; a[2][1] = 0;

        for (int i = 3; i < n + 1; i++) {
            a[i][0] = a[i - 1][0] + a[i - 1][1];
            a[i][1] = a[i - 1][0];
        }

        int result = a[n-1][0] * 2 + a[n-1][1];

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
