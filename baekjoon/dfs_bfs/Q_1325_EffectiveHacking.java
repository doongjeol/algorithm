package baekjoon.dfs_bfs;
import java.io.*;
import java.util.*;

public class Q_1325_EffectiveHacking {
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int[] result;
    public static int max = Integer.MIN_VALUE;
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        result[start] +=1 ;
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int e : graph[cur]) {
                if(!visited[e]){
                    result[start] += 1;
                    q.add(e);
                    visited[e] = true;
                }
            }

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        result = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        for (int j = 1; j < n + 1; j++) {
            visited = new boolean[n + 1];
            bfs(j);
        }
        // debug
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(result[i],max);
        }

        for (int computer = 1; computer < n + 1; computer++) {
            if(result[computer] == max){
                bw.write(computer+" ");
            }
        }

        br.close();
        bw.close();
    }
}
