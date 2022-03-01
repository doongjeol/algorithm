package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_15651_MandN3 {
    public static void permutaion(int[] arr, int n, int depth, BufferedWriter bw) throws IOException{
        if(depth == arr.length){
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i+1;
            permutaion(arr, n, depth+1, bw);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutaion(new int[m], n, 0, bw);
        br.close();
        bw.close();
    }
}
