package baekjoon.tree;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_9372_SangeunTrip {
    public static int n,m,result;
    public static boolean visited[]; // 방문여부 체크
    public static int arr[][]; // 인접행렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            result = 0;

            arr = new int[n + 1][n + 1];
            visited = new boolean[n + 1];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a][b] = 1;
                arr[b][a] = 1;
            }
            bfs();
            bw.write(result - 1 + "\n");
        }

        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            result += 1;
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[cur][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
