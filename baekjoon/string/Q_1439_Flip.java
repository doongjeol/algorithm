package baekjoon.string;
import java.io.*;
import java.util.StringTokenizer;

/* 연속된 1로 구성된 토큰의 개수와
연속된 0으로 구성된 토큰의 개수 중 작은쪽을 출력
* */
public class Q_1439_Flip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str, "0"); // 1의 토큰 개수
        StringTokenizer st0 = new StringTokenizer(str, "1");
        int min = Math.min(st1.countTokens(), st0.countTokens());

        bw.write(min+"");
        br.close();
        bw.close();
    }
}
