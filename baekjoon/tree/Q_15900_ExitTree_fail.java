package baekjoon.tree;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 루트 노드에서 리프 노드까지의 깊이 합이 짝수이면 상원이가 패배하고, 홀수면 성원이가 승리
* */
public class Q_15900_ExitTree_fail {
    public static ArrayList<ArrayList<Integer>> list;
    public static int answer,n;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        answer = 0;
        visited = new boolean[n + 1];
        dfs(1, 0, visited);

        // 깊이의 합이 짝수면 성원이가 패배하고, 홀수면 성원이가 승리한다.
        bw.write((answer % 2 == 0) ? "No":"YES");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int node, int count, boolean[] visited){
        visited[node] = true;

        for (int next : list.get(node)) {
            if (!visited[next]) {
                dfs(next, count + 1, visited);
            }
        }

        // 특정 노드가 루트 노드가 아니고, 노드의 인접리스트의 사이즈가 1이면 그 노드는 리프노드
        if (node != 1 && list.get(node).size() == 1) {
            answer += count;
        }
    }
}
