package baekjoon.mathmatics;

import java.io.*;

public class Q_2089_MinusBinary {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        solution(num);
        bw.write(sb.reverse().toString());

        br.close();
        bw.close();
    }

    public static void solution(int num) {
        int share = num;
        int rest = 0;

        if (num == 0) {
            sb.append(num);
        } else{
            while (share != 1) {
                share = (int) Math.ceil((double)share / -2); // 올림 처리를 해줘야 함
                rest = Math.abs(share % -2); //

                sb.append(rest);
            }
        }
    }
}
