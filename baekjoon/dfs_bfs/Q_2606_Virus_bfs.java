package baekjoon.dfs_bfs;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2606_Virus_bfs {
    public static int num;
    public static boolean[] visited;
    public static ArrayList<Integer>[] graph;
    public static int result;

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    result += 1;
                }
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

        bfs(1);
        bw.write(result +"");
        br.close();
        bw.close();
    }
}
