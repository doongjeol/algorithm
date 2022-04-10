package baekjoon.bruteforce;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q_15664_MandN10 {
    public static int n,m;
    public static int[] num;
    public static HashSet<String> hashSet = new HashSet<>();
    public static void permutation(int[] arr, boolean[] selected, int depth, BufferedWriter bw) throws IOException{
        if(depth == m){
            String str = "";
            for (int i = 0; i < arr.length; i++) {
                str += arr[i] +" ";
            }

            if(!hashSet.contains(str)){
                hashSet.add(str);
                bw.write(str +"\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(selected[i]) continue;
            arr[depth] = num[i];
            if(depth > 0 && arr[depth-1] > arr[depth]) continue;
            selected[i] = true;
            permutation(arr, selected, depth + 1, bw);
            selected[i] = false;
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        permutation(new int[m], new boolean[n], 0, bw);

        br.close();
        bw.close();
    }
}
