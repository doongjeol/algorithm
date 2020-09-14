package etc;

import java.io.*;
import java.util.StringTokenizer;

public class Q_9613_SumOfGCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long t = Long.parseLong(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] a = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = Long.parseLong(st.nextToken());
            }

            long result = 0;

            for(int j=0 ; j<n-1 ; j++){
                for (int k = j+1; k < n; k++) {
                    result = result + gcd(a[j], a[k]); // n = 4 | 0 1 | 0 2 | 0 3 || 1 2 | 1 3 || 2 3 |
                }
            }
            bw.write(result+"\n");
        }

        br.close();
        bw.close();
    }

    public static long gcd(long a, long b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);

        while (min > 0) {
            long temp = max;
            max = min;
            min = temp%max;
        }

        return max;
    }

}
