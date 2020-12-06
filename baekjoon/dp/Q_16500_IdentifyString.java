package baekjoon.dp;
import java.io.*;

public class Q_16500_IdentifyString {
    public static void solution(){

    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] A = new String[n];
        for (int i = 0; i < n; i++) {
            A[i] = br.readLine();
        }

        br.close();
        bw.close();
    }
}
