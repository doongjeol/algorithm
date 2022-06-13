package baekjoon.string;
import java.io.*;
import java.util.StringTokenizer;

public class Q_1120_String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int result = a.length();

        for (int i = 0; i <= b.length() - a.length() ; i++) {
            int count = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    count++;
                }
            }

            result = Math.min(count, result);
        }
        bw.write(result+"");
        br.close();
        bw.close();
    }
}
