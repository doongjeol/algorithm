package baekjoon.bruteforce;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_15650_MandN2 {
    public static void permutation(int[] arr, boolean[] selected, int depth, int idx){
        if(depth == arr.length){
            for (int i = 0; i < arr.length ; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < selected.length; i++) {
            if(selected[i]) continue;

            selected[i] = true;
            arr[depth] = i+1;
            permutation(arr, selected, depth+1, i+1);
            selected[i] = false;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutation(new int[m], new boolean[n], 0, 0);

        br.close();
    }
}
