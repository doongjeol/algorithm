package baekjoon.tree;
import java.io.*;
import java.util.StringTokenizer;

public class Q_11725_FindParent {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Tree {
        static Node root;

        public static void createNode(int data, int leftData, int rightData) {
            // 아무것도 없을 때 루트 노트 생성
            if (root == null) {
                root = new Node(data);

                // 왼쪽, 오른쪽 값이 있을 때에만 노드 생성
                if (leftData != '.') root.left = new Node(leftData);
                if (rightData != '.') root.right = new Node(rightData);
            } else {
                // 초기상태가 아니라면 어디에 들어가야할 지 찾아야함
                searchNode(root, data, leftData, rightData);
            }
        }

        // 주의 ! 여기 root는 매개변수로 들어온 로컬 변수 root
        public static void searchNode (Node root, int data, int leftData, int rightData) {
            if (root == null) return; // 노드가 null이면 재귀 종료
            else if (root.data == data) { // 들어갈 위치를 찾았다면
                // .이 아닌 값이 있는 경우에만 왼쪽 오른쪽 노드 생성
                if (leftData != '.') root.left = new Node(leftData);
                if (rightData != '.') root.right = new Node(rightData);
            } else {
                // 아직 찾지 못했고 탐색할 노트가 남아있다면
                searchNode(root.left, data, leftData, rightData); // 왼쪽 탐색
                searchNode(root.right, data, leftData, rightData); // 오른쪽 탐색
            }
        }

        // 중위순회 : 왼쪽 -> 루트 -> 오른쪽
        public static void inorder(Node root) {
            if (root.left != null) inorder(root.left); // 왼쪽 탐색
            System.out.print(root.data); // 루트 먼저 출력
            if (root.right != null) inorder(root.right); // 오른쪽 탐색
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = i;
            int n1 = st.nextToken().charAt(0);
            int n2 = st.nextToken().charAt(0);
            if(n1 == 1){
                tree.createNode(n1, n2,null);
            } else if(n2 == 1){
                tree.createNode(n2,n1,null);
            }

            tree.createNode(node, left, right);
        }

        br.close();
        bw.close();
    }
}
