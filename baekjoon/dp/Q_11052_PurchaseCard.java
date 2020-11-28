package baekjoon.dp;
import java.io.*;
import java.util.StringTokenizer;

public class Q_11052_PurchaseCard {
    public static int solution(int n, int[][] p) {
        int[] a = new int[n+1];

        for (int i = 1; i <= n; i++) {
            for(int j=p[0][i] ; j<=n ; j++) {
                a[j] = Math.max(a[j], a[j - p[0][i]] + p[1][i]);
            }
        }

        return a[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] p = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            p[0][i] = i;
            p[1][i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution(n,p)+"\n");

        br.close();
        bw.close();
    }
}
