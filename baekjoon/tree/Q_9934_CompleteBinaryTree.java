package baekjoon.tree;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 중위순회 */
public class Q_9934_CompleteBinaryTree {
    public static int size, totalLevel;
    public static int[] node;
    public static List<Integer>[] nodeList; // 트리 레벨별 노드
    public static void solve(int s, int e, int level){
        if(level == totalLevel) return;
        int mid = (s + e) / 2;
        nodeList[level].add(node[mid]);

        solve(s, mid - 1, level + 1);
        solve(mid + 1, e, level + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        totalLevel = Integer.parseInt(br.readLine());
        size = (int) Math.pow(2, totalLevel) - 1;
        node = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }

        nodeList = new ArrayList[totalLevel];
        for (int i = 0; i < totalLevel; i++) {
            nodeList[i] = new ArrayList<>();
        }

        solve(0, size - 1, 0);

        for (int i = 0; i < totalLevel; i++) {
            for(int result : nodeList[i]){
                bw.write(result+" ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
