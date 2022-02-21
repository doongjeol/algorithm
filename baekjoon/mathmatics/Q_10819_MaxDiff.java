package baekjoon.mathmatics;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_10819_MaxDiff {
    public static int[] data;
    public static int result;
    public static void permutation(int[] arr, int n, int r, boolean[] selected, int depth){
        if(depth == r){
            int sum = 0;
            for(int i=0 ; i <arr.length-1 ; i++){
                sum += Math.abs(arr[i] - arr[i+1]);

            }
            result = Math.max(sum, result);
            return;
        }

        for(int i=0 ; i<arr.length ; i++){
            if(selected[i]){
                continue;
            }
            arr[depth] = data[i];

            selected[i] = true;
            permutation(arr, n, r, selected, depth+1);
            selected[i] = false;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        permutation(new int[n], n, n, new boolean[n], 0);
        bw.write(result+"");

        br.close();
        bw.close();
    }
}
