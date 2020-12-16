package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_11055_IncreasingSubsequence {
    public static int solution(int[] a){
        int result = 0;

        for (int index = 0; index < a.length; index++) {
            int start = a[index];
            for (int index2 = 1; index2 < a.length; index2++) {
                
            }


        }

        return result;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(a +"\n");

        br.close();
        bw.close();
    }
}
