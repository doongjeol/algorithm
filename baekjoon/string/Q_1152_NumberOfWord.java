package baekjoon.string;
import java.io.*;
import java.util.StringTokenizer;

public class Q_1152_NumberOfWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(st.countTokens()+"");

        br.close();
        bw.close();
    }
}
