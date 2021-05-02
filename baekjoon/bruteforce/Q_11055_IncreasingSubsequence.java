package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_11055_IncreasingSubsequence {
    public static long solution(int[] a){
        long result = 0;

        for (int start = 0; start < a.length; start++) {
            for (int index = start; index < a.length-1; index++) {
                int temp = a[start];
                long sum = a[start];
                for (int second = index + 1; second < a.length - 1; second++) {
                    if (temp < a[second]) {
                        sum += a[second];
                        temp = a[second];
                    }
                    System.out.println("start : "+start+" | index : "+index+" | second : "+second);
                }
                result = Math.max(sum, result);
                System.out.println("---");
                System.out.println(result);
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

        bw.write(solution(a)+"\n");

        br.close();
        bw.close();
    }
}
