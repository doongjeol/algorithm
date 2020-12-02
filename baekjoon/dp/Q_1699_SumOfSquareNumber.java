package baekjoon.dp;
import java.io.*;

public class Q_1699_SumOfSquareNumber {
    public static int solution(int n) {
        int[] square = new int[318];

        for(int i=0 ; i<square.length ; i++){
            square[i] = i * i ;
        }

        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            a[i] = i;
            for (int j = 1; square[j] <= i; j++) {
                a[i] = Math.min(a[i], a[i-square[j]]+1);
            }
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
