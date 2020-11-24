package baekjoon.dp;
import java.io.*;

public class Q_1699_SumOfSquareNumber {
    public static int solution(int n) {
        int[] square = new int[318];

        for(int i=0 ; i<square.length ; i++){
            square[i] = i * i ;
        }

        int[] a = new int[n + 1];
        a[1] = 1;
        int k = 1;
        for (int i = 2; i < n + 1; i++) {
            if(i == square[k+1]) {
                a[i] = 1;
                k++;
            } else if(i > square[k]) {
                a[i] = a[square[k]] + a[i-square[k]];
                if(i == square[k-1] * 2)
                    a[i] = 2;
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
