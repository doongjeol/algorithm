package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.*;
import java.util.StringTokenizer;

public class Q_1780_NumberOfPaper {
    public static int[][] map;
    public static int[] result;
    public static void solution(int n,int startR, int startC){
        int div = n/3;
        int temp = map[startR][startC];
        boolean flag = true;

        for (int i = startR; i < startR+n; i++) {
            for (int j = startC; j < startC+n; j++) {
                if(temp != map[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if(temp == -1 && flag){
            result[0] += 1;
            return;
        }

        if(temp == 0 && flag){
            result[1] += 1;
            return;
        }

        if(temp == 1 && flag){
            result[2] += 1;
            return;
        }

        solution(div, startR, startC); // 0 0
        solution(div, startR, startC + div); // 0 1
        solution(div, startR,startC + 2*div); // 0 2
        solution(div, startR + div, startC); // 1 0
        solution(div, startR + div, startC + div); // 1 1
        solution(div, startR + div, startC + 2*div); // 1 2
        solution(div, startR + 2*div, startC); // 2 0
        solution(div, startR + 2*div, startC + div); // 2 1
        solution(div, startR + 2*div, startC + 2*div); // 2 2

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        result = new int[3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        solution(n, 0, 0);

        for (int i = 0; i < 3; i++) {
            bw.write(result[i]+"\n");
        }
        br.close();
        bw.close();
    }
}
