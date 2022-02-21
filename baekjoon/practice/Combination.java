package baekjoon.practice;

import java.io.BufferedWriter;
import java.io.*;
import java.util.Arrays;

public class Combination {
    public static void combination(int[] arr, int n, int r, int cnt, int idx) {
        if (cnt == r) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = idx; i < n; i++) {
            arr[cnt] = i;
            combination(arr, n, r, cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        combination(new int[3], 3, 2, 0, 0);
        br.close();
        bw.close();
    }
}
