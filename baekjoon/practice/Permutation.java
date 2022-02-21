package baekjoon.practice;

import java.util.Arrays;

public class Permutation {
    public static void permutation(int[] arr, boolean[] selected, int depth) {
        if (depth == selected.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            arr[depth] = i;
            permutation(arr, selected, depth + 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) {
        permutation(new int[3], new boolean[3], 0);
    }
}