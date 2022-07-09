package baekjoon.tree;

public class practice {
    class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // 전위순회 : 루트 -> 왼쪽 -> 오른쪽
    public void preorder(Node root) {
        System.out.println(root.data); // 루트 먼저 출력
        if (root.left != null) preorder(root.left); // 왼쪽 탐색
        if (root.right != null) preorder(root.right); // 오른쪽 탐색
    }

    // 중위순회 : 왼쪽 -> 루트 -> 오른쪽
    public void inorder(Node root) {
        if (root.left != null) inorder(root.left); // 왼쪽 탐색
        System.out.println(root.data); // 루트 먼저 출력
        if (root.right != null) inorder(root.right); // 오른쪽 탐색
    }

    // 후위순회 : 왼쪽 -> 오른쪽 -> 루트
    public void postorder(Node root) {
        if (root.left != null) postorder(root.left); // 왼쪽 탐색
        if (root.right != null) postorder(root.right); // 오른쪽 탐색
        System.out.println(root.data); // 루트 먼저 출력
    }
}