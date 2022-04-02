package baekjoon.bruteforce;
import java.io.*;
import java.util.*;

public class Q_15663_MandN9 {
    public static int[] data;
    public static void permutation(int[] arr, int r, int depth, boolean[] chekced, BufferedWriter bw) throws IOException {
        if(depth == r){
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < data.length; i++) {
            if(chekced[i]) continue;
            chekced[i] = true;
            arr[depth] = data[i];
            permutation(arr, r, depth + 1, chekced, bw);
            chekced[i] = false;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        permutation(new int[r], r, 0, new boolean[n], bw);

        br.close();
        bw.close();
    }
}
