package baekjoon.dp;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q_12865_OrdinaryBag {
    public static int solution(int n, int k, int[][] wv) {
// w -> k , v 최대
        int[] a = new int[n];

//        for (int i = 0; i < n; i++) {
//            for(int j=k[i] ; j<)
//        }

        return 0;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] wv = new int[n][n];
        for(int i=0 ; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            wv[0][i] = Integer.parseInt(st.nextToken()); // 무게
            wv[1][i] = Integer.parseInt(st.nextToken()); // 가치
        }
        Arrays.sort(wv, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                else
                    return Integer.compare(o1[0], o2[0]);
            }
        });
        print(wv);
        bw.write(solution(n,k,wv)+"\n");

        br.close();
        bw.close();

    }

    public static void print(int[][] wv){
        for (int i = 0; i < 4; i++) {
            System.out.print(wv[0][i] +" ");
            System.out.println(wv[1][i]);
        }

    }
}
