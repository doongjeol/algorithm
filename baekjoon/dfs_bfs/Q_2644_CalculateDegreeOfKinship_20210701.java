package baekjoon.dfs_bfs;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2644_CalculateDegreeOfKinship_20210701 {
    public static int n, m, one, two;
    public static int[][] family;
    public static int[] visited;

    public static void solution(){
        bfs(one);
    }

    public static void bfs(int cur){
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);
        visited[cur] = 0;

        while (!q.isEmpty()) {
            int k = q.poll();

            for (int i = 1; i <= n; i++) {
                if (family[k][i] == 1 && visited[i] == -1) {
                    q.add(i);
                    visited[i] = visited[k] + 1;
                }
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        family = new int[n + 1][n + 1];
        visited = new int[n + 1];
        Arrays.fill(visited,-1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            family[parent][child] = 1;
            family[child][parent] = 1;
        }

        solution();
        bw.write(visited[two]+"");

        br.close();
        bw.close();
    }
}
