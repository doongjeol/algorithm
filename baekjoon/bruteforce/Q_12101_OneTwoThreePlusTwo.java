package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Q_12101_OneTwoThreePlusTwo {
    public static int n,k;
    public static int result = -1;
    public static int[] arr = {1, 2, 3};
    public static void permutation(int depth, int sum){
        if(sum == n){
            System.out.println("헤에이..");
            return;
        }

        for (int i = 0; i <= arr.length; i++) {
            if(sum + arr[depth] > n) continue;
            System.out.print(depth+" ");
            if(i == arr.length)
                System.out.println();
            permutation(depth+1,sum+arr[depth]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        permutation(0,0);
        bw.write(result+"");
    }
}
