package baekjoon.mathmatics;

import java.io.*;

public class Q_11653_fip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; i++) {
                if (num % i == 0) {
                    count++;
                }
            }
        }

        br.close();
        bw.close();
    }

    public static void solution(int n) {
        int share = 0;
        int rest = 0;

        while(share !=0){
            share = n/2;
            rest = n%2;
        }
    }
}