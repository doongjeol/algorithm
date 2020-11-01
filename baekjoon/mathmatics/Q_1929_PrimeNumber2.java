package baekjoon.mathmatics;

import java.io.*;
import java.util.StringTokenizer;

public class Q_1929_PrimeNumber2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = m; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if(i%j == 0){
                    count ++;
                }
                if(count >= 3)
                    break;
            }

            if(count == 2)
                bw.write(i+"\n");

        }

        br.close();
        bw.close();
    }
}
