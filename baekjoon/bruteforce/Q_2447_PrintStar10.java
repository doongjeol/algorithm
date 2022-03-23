package baekjoon.bruteforce;

import java.io.*;

/* 12%에서 자꾸 틀림.. ㅠㅠ*/
public class Q_2447_PrintStar10 {
    public static char[][] result;
    public static int count;
    public static void solution(int n, int depth, int startR, int startC, int position) {

        if (depth == count) {
            return;
        }

        int div = n / 3;

        star(n,startR,startC,position);

        if(position != 4) {
            solution(div, depth + 1, startR, startC, 0);
            solution(div, depth + 1, startR, startC + div, 1);
            solution(div, depth + 1, startR, startC + 2 * div, 2);
            solution(div, depth + 1, startR + div, startC, 3);
            solution(div, depth + 1, startR + div, startC + div, 4);
            solution(div, depth + 1, startR + div, startC + 2 * div, 5);
            solution(div, depth + 1, startR + 2 * div, startC, 6);
            solution(div, depth + 1, startR + 2 * div, startC + div, 7);
            solution(div, depth + 1, startR + 2 * div, startC + 2 * div, 8);
        }
    }

    public static void star(int n, int startR, int startC, int position){
        for (int i = startR; i < startR + n; i++) {
            for (int j = startC; j < startC + n; j++) {
                if(position == 4){
                    result[i][j] = ' ';
                } else{
                    result[i][j] = '*';
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        result = new char[n][n];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = ' ';
            }
        }
        count = (int)(Math.log10(n)/Math.log10(3));
        solution(n,-1,0,0,-1);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                bw.write(result[i][j]+"");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
