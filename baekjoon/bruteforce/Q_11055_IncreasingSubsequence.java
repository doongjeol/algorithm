package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_11055_IncreasingSubsequence {
    public static int solution(int[] a){
        int result = 0;

        for (int start = 0; start < a.length; start++) {
            int temp = a[start];
            int sum = a[start];
            for (int index = start; index < a.length-1; index++) {
                for (int indexTwo = index; indexTwo < a.length - 1; indexTwo++) {

                }
                if (temp < a[index + 1]) {
                    sum += a[index + 1];
                    temp = a[index + 1];
                }
            }
            result = Math.max(sum, result);
            System.out.println(result);

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

        bw.write(solution(a)+"\n");

        br.close();
        bw.close();
    }
}
