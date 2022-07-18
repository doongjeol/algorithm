package baekjoon.tree;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* 1. dfs 통해 임의의 정점 하나에서 가장 먼 정점을 구한다.
* 2. dfs 통해 구한 정점으로 가장 먼 정점까지의 거리를 구한다.*/
public class Q_1167_DegreeOfTree {
    public static int v, answer, farNode;
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

    public static void dfs(int v, int totalLength) {
        if(totalLength > answer){
            answer = totalLength;
            farNode = v;
        }

        visited[v] = true;

        for (Node node : list[v]) {
            if(!visited[node.next]) {
                dfs(node.next, totalLength + node.length);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        for (int i = 0; i < v+1; i++) {
            list[i] = new ArrayList();
        }


        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            while(true) {
                int first = Integer.parseInt(st.nextToken());
                if(first == -1) break;
                int length = Integer.parseInt(st.nextToken());
                list[nodeNum].add(new Node(first, length));
            }
        }


        answer = 0;
        // 이렇게 풀면 시간초과
//        for (int i = 1; i < v + 1; i++) {
//            visited = new boolean[v + 1];
//            visited[i] = true;
//            dfs(i, 0);
//        }

        visited = new boolean[v + 1];
        // 임의의 노드 1에서 부터 가장 먼 노드를 찾는다
        // 이 때 찾은 노드를 farNode에 저장한다
        dfs(1, 0);

        // farNode에서부터 가장 먼 노드까지의 거리를 구한다
        visited = new boolean[v + 1];
        dfs(farNode, 0);
        
        bw.write(answer+"");
        br.close();
        bw.close();
    }
}
