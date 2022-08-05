package baekjoon.dfs_bfs;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1707_BinaryGraph {
    public static int V;
    public static boolean isNo, endTest;
    public static List<Integer>[] graph;
    public static int[] visited;
    public static void solution(){
        for (int i = 1; i < V+1; i++) {
            if(isNo){
                System.out.println("NO");
                endTest = true;
                break;
            }
            if(visited[i] == 0){
                dfs(i, 1);
            }
        }
    }

    // visited 0이면 방문 X, 1팀 2팀
    public static void dfs(int head, int team){
        if(isNo){
            return;
        }
        visited[head] = team;

        for (int e : graph[head]){
            // 방문했던 곳을 또 방문하면 이분 그래프가 아님
            if(visited[head] == visited[e]){
                isNo = true;
                return;
            } else if(visited[e] == 0){ // 방문한 적이 없다면
                if(visited[head] == 1){
                    dfs(e, 2);
                } else {
                    dfs(e, 1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new int[V+1];
            graph = new ArrayList[V+1];
            isNo = false;
            endTest = false;
            for (int j = 0; j < V+1; j++) {
                graph[j] = new ArrayList<Integer>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            solution();
            if(!endTest){
                System.out.println("YES");
            }
        }
        br.close();
    }
}
