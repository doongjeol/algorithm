package string;

import java.io.*;
import java.util.StringTokenizer;

public class Q_10824_FourNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1,000,000 문자열 더하기 1,000,000 는 10,000,001,000,000 이므로 long 타입으로 선언
        long ab = Long.parseLong(st.nextToken() + st.nextToken());
        long cd = Long.parseLong(st.nextToken() + st.nextToken());
        bw.write(ab+cd+"\n");

        bw.close();
        br.close();

    }
}
