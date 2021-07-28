package baekjoon.dfs_bfs;
import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class Q_10265_MT_20210629 {
    public static int[] student;
    public static List list;
    public static void solution(){

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        student = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.close();
    }
}
