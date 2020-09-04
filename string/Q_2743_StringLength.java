package string;

import java.io.*;

public class Q_2743_StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        bw.write(str.length()+"\n");

        br.close();
        bw.close();


    }
}
