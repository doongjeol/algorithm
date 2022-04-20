package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_16198_GatherEnergy {
    public static int max = Integer.MIN_VALUE;
    public static int n;
    public static int[] w;
    public static void permutation(boolean[] selected, int depth, int result){
        if(depth == 2){
            max = Math.max(max, result);
            return;
        }

        for (int i = 1; i < n-1; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            int left = i - 1;
            int right = i + 1;

            while(selected[left]){
                left -= 1;
            }
            while (selected[right]){
                right += 1;
            }

            if(left < 0 || right >= n) continue;
            permutation(selected, depth -1, result +  w[left] * w[right]);
            selected[i] = false;

        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        permutation(new boolean[n],n,0);
        bw.write(max+"");
        br.close();
        bw.close();
    }
}
