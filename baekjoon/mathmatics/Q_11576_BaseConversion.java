package baekjoon.mathmatics;

import java.io.*;
import java.util.StringTokenizer;

public class Q_11576_BaseConversion {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // a진법
        int b = Integer.parseInt(st.nextToken()); // b진법
        int m = Integer.parseInt(br.readLine()); // 자리수의 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb = new StringBuilder();
            solution(a,b,st.nextToken());
            bw.write(sb.reverse().toString()+" ");
        }

        br.close();
        bw.close();

    }

    public static void solution (int a, int b, String numstr){
        int numDeci = 0;

        // a진법을 10진법으로
        if(a > 10){
            for (int i = 0; i < numstr.length(); i++) {
                numDeci += Math.pow(a, numstr.length() - 1 - i) * (numstr.charAt(i) - '0');
            }
        } else {
            for (int i = 0; i < numstr.length(); i++) {
                numDeci += Math.pow(a, numstr.length() - 1 - i) * (numstr.charAt(i) - '0');
            }
        }

        int share = numDeci;
        int rest = 0;

        // 10진법으로 변환된 수를 b진법으로
        while (share > 0) {
            share = share / b;
            rest = share % b;

            System.out.println(rest);
            sb.append(rest);
        }
    }
}
