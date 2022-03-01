package baekjoon.bruteforce;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_15655_MandN6 {
    public static int[] data;
    public static void combination(int[] arr, int r, int depth, int idx, BufferedWriter bw) throws IOException{
        if(depth == r){
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = idx; i < data.length; i++) {
            arr[depth] = data[i];
            combination(arr, r, depth+1, i+1, bw);
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
        combination(new int[r], r, 0, 0, bw);

        br.close();
        bw.close();
    }
}
