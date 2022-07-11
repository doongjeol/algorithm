package baekjoon.tree;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_11725_FindParent {
    static class Node {
        int idx;
        int root;
        ArrayList<Node> adj;

        public Node(int idx){
            this.idx = idx;
            this.root = 0;
            this.adj = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }

        // BFS

        boolean[] visited = new boolean[n + 1];

        Queue<Node> q = new LinkedList<>();
        nodes[1].root = -1; //root
        q.add(nodes[1]);

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (Node no : now.adj) {
                if(!visited[no.idx]){ // 방문 안했으면
                    visited[no.idx] = true;
                    no.root = now.idx; // now가 부모 노드가 된다
                    q.add(no);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            bw.write(nodes[i].root+"\n");
        }
        br.close();
        bw.close();
    }
}
