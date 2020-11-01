package baekjoon.string;

import java.io.*;

public class Q_11655_ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            int t = str.charAt(i);
            // 아스키코드 65~90 대문자, 97~122 소문자
            if(t >= 65 && t<=90 || t >=97 && t<=122) {
                t += 13;
                if (t > 90 && t <= 103 || t > 122 && t <= 135)
                    t -= 26;
            }
            result += (char) t;
        }

        bw.write(result + "\n");

        br.close();
        bw.close();
    }
}
