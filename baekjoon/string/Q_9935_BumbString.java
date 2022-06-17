package baekjoon.string;
import java.io.*;

/*
문자열이 백만이므로
* */

public class Q_9935_BumbString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bumb = br.readLine();

        while(str.contains(bumb)){
            String[] split = str.split(bumb);
            String result = "";
            for (int i = 0; i < split.length; i++) {
                result += split[i];
            }
            str = result;
        }


        br.close();
        bw.close();
    }
}
