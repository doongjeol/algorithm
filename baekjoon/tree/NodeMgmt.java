package baekjoon.tree;


public class NodeMgmt {
    Node root = null;

    public class Node {
        Node left;
        Node right;
        int value; // 노드가 갖고 있는 값

        Node(int data) {
            this.left = null;
            this.right = null;
            this.value = data;
        }
    }

    public boolean insertNode(int data) {
        // CASE 1 : Node가 하나도 없을 때
        if (this.root == null) {
            this.root = new Node(data);
        } else {
            // CASE 2 : Node가 하나 이상 들어가있을 때
            Node findNode = this.root;
            while(true){
                // CASE 2-1 : 현재 Node의 왼쪽에 Node가 들어가야할 때
                if(data < findNode.value){
                    if(findNode.left != null){
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                // CASE 2-2 : 현재 Node의 오른쪽에 Node가 들어가야할 때
                } else {
                    if (findNode.right != null) {
                        if (findNode.right != null) {
                            findNode = findNode.right;
                        } else {
                            findNode.right = new Node(data);
                            break;
                        }
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data){
        // CASE 1 : Node가 하나도 없을 때
        if(this.root == null){
            return null;
        // CASE 2 : Node가 하나 이상 있을 때
        } else {
            Node findNode = this.root;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
        }
        return null;
    }
}

