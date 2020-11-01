package baekjoon.mathmatics;

import java.io.*;
import java.util.StringTokenizer;

public class Q_2004_NumOfCombination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long deno = 1;
        long numer = 1;

        for (int i = n; i >= m; i--) {
            deno *= i;
        }

        for (int i = m; i > 0; i--) {
            numer *= i;
        }

        long result = deno / numer;
        long count = 0;
        while (true) {
            if (result % 10 != 0) break;
            else {
                result /= 10;
                count++;
            }
        }

        bw.write(count+"\n");

        br.close();
        bw.close();
    }
}
