package baekjoon.practice;

import java.util.Arrays;

public class Combination {
    public static void combination(int[] arr, int n, int r, int depth, int idx) {
        if (depth == r) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = idx; i < n; i++) {
            arr[depth] = i;
            combination(arr, n, r, depth + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        combination(new int[2], 4, 2, 0, 0);
    }
}
