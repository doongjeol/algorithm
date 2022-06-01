package baekjoon.dfs_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_2606_Virus_dfs {
    public static int num;
    public static boolean[] visited;
    public static ArrayList<Integer>[] graph;
    public static int result;

    public static void dfs(int i) {
        visited[i] = true;

        for (int next : graph[i]) {
            if (!visited[next]) {
                result += 1;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        visited = new boolean[num + 1];

        graph = new ArrayList[num + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        bw.write(result + "");

        br.close();
        bw.close();
    }
}
