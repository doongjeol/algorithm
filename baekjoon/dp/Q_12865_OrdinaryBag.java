package baekjoon.dp;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q_12865_OrdinaryBag {
    public static int solution(int n, int k, int[] w, int[] v) {
        int[][] a = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                a[i][j] = a[i - 1][j];
                if (j - w[i] >= 0) {
                    a[i][j] = Math.max(a[i - 1][j], a[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        return a[n][k];
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] w = new int[n+1];
        int[] v = new int[k+1];
        for(int i=1 ; i<=n ; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken()); // 무게
            v[i] = Integer.parseInt(st.nextToken()); // 가치
        }

        bw.write(solution(n,k,w,v)+"\n");

        br.close();
        bw.close();

    }

}
