package baekjoon.string;
import java.io.*;

public class Q_7567_Bowl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String temp = str.charAt(0) + "";
        int length = 10;
        for (int i = 1; i < str.length(); i++) {
            String cur = str.charAt(i)+"";
            if (!cur.equals(temp)) {
                length += 10;
            } else {
                length += 5;
            }
            temp = cur;
        }

        bw.write(length+"");

        br.close();
        bw.close();
    }
}
