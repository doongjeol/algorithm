package baekjoon.bruteforce;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_15654_MandN5 {
    public static int[] data;
    public static void permutation(int[] arr, boolean[] selected, int r, int depth){
        if(depth == r){
            for (int i = 0; i < arr.length ; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < data.length ; i++) {
            if(selected[i]) continue;

            selected[i] = true;
            arr[depth] = data[i];
            permutation(arr, selected, r, depth+1);
            selected[i] = false;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        data = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);
        permutation(new int[r], new boolean[n], r, 0);

        br.close();
        bw.close();
    }
}
