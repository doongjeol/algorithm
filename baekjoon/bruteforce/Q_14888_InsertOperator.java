package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_14888_InsertOperator {
    public static int n = 0;
    public static int[] a;
    public static int[] operator = new int[4];
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static void solution(int depth, int result) {
        if(depth == n){
            max = Math.max(max,result);
            min = Math.min(min,result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                operator[i] --;
                switch (i){
                    case 0 :
                        solution(depth + 1, result + a[depth]);
                        break;
                    case 1 :
                        solution(depth + 1, result - a[depth]);
                        break;
                    case 2 :
                        solution(depth + 1, result * a[depth]);
                        break;
                    case 3 :
                        solution(depth + 1, result / a[depth]);
                        break;
                }
                operator[i] ++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        solution(1,a[0]);

        bw.write(max+"\n");
        bw.write(min+"\n");


        br.close();
        bw.close();
    }
}
