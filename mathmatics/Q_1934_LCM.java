package etc;

import java.io.*;
import java.util.StringTokenizer;

public class Q_1934_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(a * b / gcd(Math.max(a, b), Math.min(a, b))+"\n");

        br.close();
        bw.close();
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp%a;
        }

        return a;
    }
}
