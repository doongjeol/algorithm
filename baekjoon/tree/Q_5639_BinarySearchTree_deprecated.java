package baekjoon.tree;
import java.io.*;

public class Q_5639_BinarySearchTree_deprecated {
    public static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    static class Tree {
        static Node root;

        public static void createNode(char data, char leftData, char rightData) {
            // 아무것도 없을 때 루트 노드 생성
            if (root == null) {
                root = new Node(data);


                // 왼쪽 오른쪽 값이 있을 때에만 노드 생성
                if (leftData != '.') root.left = new Node(leftData);
                if (rightData != '.') root.right = new Node(rightData);
            } else {
                // 초기상태가 아니라면 어디에 들어가야할 지 찾아야함
                searchNode(root, data, leftData, rightData);
            }
        }

        public static void searchNode(Node root, char data, char leftData, char rightData){
            if(root == null) return; // 노드가 null 이면 재귀 종료
            else if(root.data == data){ // 들어갈 위치를 찾았다면
                // .이 아닌 값이 있는 경우에만 왼쪽 오른쪽 노드 생성
                if(leftData != '.') root.left = new Node(leftData);
                if(rightData != '.') root.right = new Node(rightData);

            } else {
                // 아직 찾지 못했고 탐색할 노드가 남아있다면
                searchNode(root.left, data, leftData, rightData);
                searchNode(root.right, data, leftData, rightData);
            }
        }

        // 후위순회 : 왼쪽 -> 오른쪽 -> 루트
        public static void postorder(Node root){
            if(root.left != null) postorder(root.left);
            if(root.right != null) postorder(root.right);
            System.out.println(root.data);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str == null) break;
        }
        br.close();
        bw.close();
    }
}
