package baekjoon.bruteforce;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_15659_InsertOperator3 {
    public static int n;
    public static int[] num;
    public static int[] operator = new int[4];
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static Stack<String> stack;
    public static void solution(int depth, String[] result){
        if(depth == n){
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operator[i] > 0){
                operator[i] --;
                switch (i){
                    case 0 :
                        result[depth - 1] = "+";
                        break;
                    case 1 :
                        result[depth - 1] = "-";
                        break;
                    case 2 :
                        result[depth - 1] = "*";
                        break;
                    case 3 :
                        result[depth - 1] = "/";
                        break;

                }
                solution(depth +1, result);
                operator[i] ++;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println((1+""));

        br.close();
        bw.close();
    }
}
