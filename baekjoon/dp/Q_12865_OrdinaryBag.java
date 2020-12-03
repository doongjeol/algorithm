package baekjoon.dp;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q_12865_OrdinaryBag {
    public static int solution(int k, int[] w, int[] v) {
// w -> k , v 최대
        int[] a = new int[k+1];

        for (int i = 0; i < w.length; i++) {
            for (int j = w[i]; j <= k; j++) {
                a[j] = Math.max(a[j], a[j - w[i]] + v[i]);
            }
        }

        return a[k];
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] w = new int[n];
        int[] v = new int[n];
        for(int i=0 ; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken()); // 무게
            v[i] = Integer.parseInt(st.nextToken()); // 가치
        }

        bw.write(solution(k,w,v)+"\n");

        br.close();
        bw.close();

    }

    public static void print(int[][] wv){
        for (int i = 0; i < 4; i++) {
            System.out.print(wv[i][0] +" ");
            System.out.println(wv[i][1]);
        }

    }
}
