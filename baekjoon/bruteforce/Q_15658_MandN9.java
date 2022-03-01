package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_15658_MandN9 {
//    public static int[][] data;
    public static String[][] data;
    public static int max = -40001;
    public static void combination(String[] arr, int k, int depth, int idxR, int idxC){
        if(depth == k){
            int sum = 0;
//            for (int i = 0; i < arr.length; i++) {
//                sum += arr[i];
//            }
//            max = Math.max(sum, max);

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = idxR; i < data.length; i++) {
            for (int j = idxC; j < data[0].length; j++) {
                arr[depth] = data[i][j];

                combination(arr, k, depth+1, i, j+1);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

//        data = new int[n][m];
        data = new String[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
//                data[i][j] = Integer.parseInt(st.nextToken());
                data[i][j] = st.nextToken();
            }
        }

        combination(new String[k], k, 0, 0, 0);
        bw.write(max+"");

        br.close();
        bw.close();
    }
}
