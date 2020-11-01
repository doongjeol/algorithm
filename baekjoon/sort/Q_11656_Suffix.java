package baekjoon.sort;

import java.io.*;
import java.util.Arrays;

public class Q_11656_Suffix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] result = new String[str.length()];

        for(int i=0 ; i<str.length() ; i++){
            result[i] = str.substring(i);
        }

        Arrays.sort(result);

        for (int i = 0; i < result.length; i++) {
            bw.write(result[i]+"\n");
        }

        br.close();
        bw.close();
    }
}
