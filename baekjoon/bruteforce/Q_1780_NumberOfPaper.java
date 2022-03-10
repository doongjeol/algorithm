package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.*;

public class Q_1780_NumberOfPaper {
    public static void solution(int n,int startR, int startC){
        int div = n/3;

        for (int i = startR; i < 3; i++) {
            for (int j = startC; j < 3; j++) {

            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        br.close();
        bw.close();
    }
}
