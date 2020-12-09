package baekjoon.dp;
import java.io.*;

public class Q_16500_IdentifyString {
    public static int solution(String S, int n, String[] A){

        return 1;

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

        bw.write(solution(S,n,A)+"\n");

        br.close();
        bw.close();
    }
}
