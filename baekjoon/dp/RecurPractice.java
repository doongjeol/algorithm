package baekjoon.dp;

public class RecurPractice {
    public static void main(String[] args) {
        recur(3);
    }

    static void recur(int n){
        while (n>0){
            recur(n-1);
            System.out.println(n);
            n=n-2;
        }
    }
}
