package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_6603_Lotto {
    public static int[] arr;
    public static void combination(int[] array, int n, int r, int depth, int idx, BufferedWriter bw) throws IOException{
        if(depth == r){
            for (int i = 0; i < array.length; i++) {
                bw.write(array[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = idx; i < n; i++) {
            array[depth] = arr[i];
            combination(array, n, r, depth + 1, i + 1, bw);
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str.equals("0")) break;
            StringTokenizer st = new StringTokenizer(str);
            int length = Integer.parseInt(st.nextToken());
            arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            combination(new int[6], length, 6, 0, 0, bw);
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
