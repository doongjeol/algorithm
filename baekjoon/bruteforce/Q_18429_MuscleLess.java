package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_18429_MuscleLess {
    public static int n,k;
    public static int[] kit;
    public static int answer;

    public static void permutation(int depth,int[] arr, boolean[] checked){
        if(depth == n){
            int result = 500;
            for (int i = 0; i < arr.length; i++) {
                result += kit[arr[i]] - k;
                if(result < 500) return;
            }
            answer += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            arr[depth] = i;
            permutation(depth + 1, arr, checked);
            checked[i] = false;

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kit = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0, new int[n], new boolean[n]);
        bw.write(answer+"");

        br.close();
        bw.close();
    }
}
