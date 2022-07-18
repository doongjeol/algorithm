package baekjoon.tree;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1967_DegreeOfTree {
    public static int answer = 0;
    public static boolean[] visited;
    public static List<Node>[] list;
    public static class Node {
        int next;
        int length;

        public Node(int next, int length) {
            this.next = next;
            this.length = length;
        }

    }

    public static void dfs(int cur, int totalLength) {
        for (Node node : list[cur]) {
            if (!visited[node.next]) {
                visited[node.next] = true;
                dfs(node.next, totalLength + node.length);
            }
        }

        answer = (answer < totalLength) ? totalLength : answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, length));
            list[b].add(new Node(a, length));
        }

        for (int i = 1; i <= n ; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        bw.write(answer+"");
        br.close();
        bw.close();
    }
}
