package mathmatics;

import java.io.*;
import java.util.StringTokenizer;

public class Q_10430_Rest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int result1 = (A + B) % C;
        int result2 = ((A % C) + (B % C)) % C;
        int result3 = (A * B) % C;
        int result4 = ((A % C) * (B % C)) % C;

        bw.write(result1+"\n");
        bw.write(result2+"\n");
        bw.write(result3+"\n");
        bw.write(result4+"\n");

        br.close();
        bw.close();
    }
}
