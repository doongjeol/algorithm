package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Q_2630_MakeColorPaper {
    public static int[][] map;
    public static int[] result;
    public static void solution(int n, int startR, int startC){
        int half = n/2;
        int sum = 0;
        for (int i = startR; i < startR + n; i++) {
            for (int j = startC; j < startC + n; j++) {
                sum += map[i][j];

            }
        }
        if(sum == 0){
            result[0] += 1;
            return;
        }

        if(sum == n*n){
            result[1] += 1;
            return;
        }

        solution(half, startR, startC);// 2사분면
        solution(half, startR, startC + half); // 1사분면
        solution(half, startR + half, startC); // 3사분면
        solution(half, startR + half, startC + half); // 4사분면
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        result = new int[2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(n,0,0);
        bw.write(result[0]+"\n");
        bw.write(result[1]+"\n");

        br.close();
        bw.close();
    }
}
