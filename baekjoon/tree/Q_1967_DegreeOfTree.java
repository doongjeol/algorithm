package baekjoon.tree;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1967_DegreeOfTree {
    public static int n;
    public static class Node{
        int num, len;
        public Node(int num, int len){
            this.num = num;
            this.len = len;
        }
    }

    public static List<Node> list[];
    public static boolean visited[];
    public static int answer;

    public static void dfs(int num, int dim) {
        for(Node node : list[num]){
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, dim + node.len);
            }
        }

        answer = (answer < dim) ? dim : answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, len));
            list[b].add(new Node(a, len));
        }

        answer = 0;

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        bw.write(answer+"");

        br.close();
        bw.close();
    }
}
