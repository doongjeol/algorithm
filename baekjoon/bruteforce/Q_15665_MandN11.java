package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_15665_MandN11 {
    public static int n,m;
    public static int[] num;
    public static void permutation(int[] arr, boolean[] selected, int depth, BufferedWriter bw) throws IOException{
        if (depth == m) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            arr[depth] = num[i];
            permutation(arr, selected, depth + 1, bw);
            selected[i] = false;
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        bw.close();
    }
}
