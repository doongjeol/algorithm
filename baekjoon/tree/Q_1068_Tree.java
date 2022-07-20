package baekjoon.tree;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1068_Tree {
    public static int n, d, result = 0;
    public static Node[] nodes;
    public static class Node {
        int idx;
        ArrayList<Node> child = new ArrayList<>();

        public Node(int idx){
            this.idx = idx;
        }
    }
    public static void deleteNode(int idx){
        for(Node child : nodes[idx].child){
            if(child.idx == d){
                nodes[idx].child.remove(child);
                return;
            }
            deleteNode(child.idx);
        }
    }
    public static void dfs(int idx){
        if(nodes[idx].child.size() == 0){
            result += 1;
            return;
        }

        for(Node child : nodes[idx].child){
            dfs(child.idx);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        nodes = new Node[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= n ; i++) {
            nodes[i] = new Node(i);
        }

        int root = 0;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if(parent == -1){
                root = i;
                continue;
            }
            nodes[parent].child.add(nodes[i]);
        }

        d = Integer.parseInt(br.readLine());

        if (d != root) {
            deleteNode(root);
            dfs(root);
        }

        bw.write(result +"");

        br.close();
        bw.close();
    }
}
