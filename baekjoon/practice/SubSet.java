package baekjoon.practice;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void subSet(List<Integer> list, int n, int depth) {
        if (depth == n) {
            System.out.println(list);
            return;
        }

        list.add(depth);
        subSet(list, n, depth + 1);
        list.remove(list.size() - 1);
        subSet(list, n, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        subSet(new ArrayList<>(), 3, 0);
    }
}
