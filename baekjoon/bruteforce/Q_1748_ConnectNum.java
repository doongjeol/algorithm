package baekjoon.bruteforce;
import java.io.*;

public class Q_1748_ConnectNum {

    public static int solution(int n){
        int result = 0;
        int unit = 1;
        int length = 10;
        for (int i = 1; i <= n; i++) {
            if(i % length == 0){
                unit ++;
                length *= 10;
            }
            result  += unit;

        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(solution(n)+"");

        br.close();
        bw.close();
    }
}
