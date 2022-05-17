package baekjoon.string;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q_1427_SortInside {
    public static class IntCompare implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2,o1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Integer[] arr = new Integer[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr, new IntCompare());

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]+"");
        }
        br.close();
        bw.close();
    }
}
