package baekjoon.dp;
import java.io.*;

public class Q_1904_01Tile {
    public static int solution(int n) {
        int[] a = new int[n+1];

        a[0] = 1; a[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            a[i] = (a[i - 1] + a[i - 2])%15746;
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
