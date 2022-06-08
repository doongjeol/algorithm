package baekjoon.string;
import java.io.*;
import java.util.StringTokenizer;

public class Q_9093_FlipWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = st.countTokens();
            String[] str = new String[length];
            for (int j = 0; j < length; j++) {
                str[j] = st.nextToken();

                String temp = "";
                for (int k = str[j].length()-1 ; k >= 0; k--) {
                    temp += str[j].charAt(k);
                }
                str[j] = temp;
                if(j != length -1) {
                    bw.write(str[j] + " ");
                } else {
                    bw.write(str[j]+"\n");
                }
            }
        }
        br.close();
        bw.close();
    }
}
