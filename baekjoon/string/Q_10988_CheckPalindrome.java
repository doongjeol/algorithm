package baekjoon.string;
import java.io.*;

public class Q_10988_CheckPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int isPossible = 1;
        int length = str.length();

        for (int i = 0; i < length/2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                isPossible = 0;
            }
        }

        bw.write(isPossible+"");

        br.close();
        bw.close();
    }
}
