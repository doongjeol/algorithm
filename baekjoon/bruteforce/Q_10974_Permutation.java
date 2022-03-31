package baekjoon.bruteforce;
import java.io.*;

public class Q_10974_Permutation {
    public static void permutaion(int[] arr, boolean[] checked, int n , int depth, BufferedWriter bw) throws IOException {
        if(depth == n){
            for (int i = 0; i < arr.length ; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");

            return;
        }

        for (int i = 1; i <= n; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            arr[depth] = i;
            permutaion(arr, checked, n, depth + 1, bw);
            checked[i] = false;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        permutaion(new int[n],new boolean[n+1],n,0,bw);
        br.close();
        bw.close();
    }
}
