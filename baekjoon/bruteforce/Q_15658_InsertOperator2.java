package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_15658_InsertOperator2 {
    public static int n;
    public static int[] operator, num;
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
                switch (i) {
                    case 0:
                        solution(depth + 1, result + num[depth]);
                        break;
                    case 1:
                        solution(depth + 1, result - num[depth]);
                        break;
                    case 2:
                        solution(depth + 1, result * num[depth]);
                        break;
                    case 3:
                        solution(depth + 1, result / num[depth]);
                        break;
                }
            }
        }

    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        operator = new int[4];

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        solution(1,num[0]);

        bw.write(max+"\n");
        bw.write(min+"");

        br.close();
        bw.close();
    }
}
