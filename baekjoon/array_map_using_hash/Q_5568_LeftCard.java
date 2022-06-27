package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.HashSet;

public class Q_5568_LeftCard {
    public static HashSet<String> hashSet = new HashSet();
    public static void permutation(int n, int k, boolean[] selected, int depth, int[] arr, int[] result){
        if(depth == k){
            String temp = "";
            for (int i = 0; i < result.length; i++) {
                temp += String.valueOf(result[i]);
            }

            hashSet.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(selected[i]) continue;
            result[depth] = arr[i];
            selected[i] = true;
            permutation(n, k, selected, depth + 1, arr, result);
            selected[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        permutation(n, k, new boolean[n], 0, arr, new int[k]);

        bw.write(hashSet.size()+"");
        br.close();
        bw.close();
    }
}
