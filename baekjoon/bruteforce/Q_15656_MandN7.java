package baekjoon.bruteforce;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_15656_MandN7 {
    public static int[] data;
    public static void permutation(int[] arr, int r, int depth, BufferedWriter bw) throws IOException{
        if(depth == r){
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < data.length ; i++) {
            arr[depth] = data[i];
            permutation(arr, r, depth+1, bw);
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
        permutation(new int[r], r, 0, bw);

        br.close();
        bw.close();
    }
}
