package baekjoon.dp;
import java.io.*;
import java.util.StringTokenizer;

public class Q_11051_BinaryCoe {
    public static long solution(int n, int k){
        long a[][] = new long[n+1][k+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if(i == j || j == 0)
                    a[i][j] = 1;
                else if (i > 0) {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                    a[i][j] %= 10007;
                }
            }
        }
//        a[n][k] %= 10007;

        return a[n][k];

    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(solution(n,k)+"\n");

        br.close();
        bw.close();
    }
}
