package baekjoon.string;
import java.io.*;
import java.util.StringTokenizer;

/* https://st-lab.tistory.com/148 참조
Point !
덧셈 부분을 먼저 계산하고 빼준다
 */
public class Q_1541_LostBracket {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* solution */
        int sum = Integer.MAX_VALUE;
        // 먼저 뺄셈으로 토큰을 나눔
        StringTokenizer sub = new StringTokenizer(br.readLine(),"-");

        while(sub.hasMoreTokens()){
            int temp = 0;

            // 뺄셈으로 나눈 토큰을 덧셈으로 분리
            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            // 덧셈으로 나눈 토큰들을 모두 더하기 (뺄셈을 기준으로 나눠진 토큰 중 덧셈으로 이루어진 토큰들을 더한다 = 덧셈 먼저 수행)
            while(add.hasMoreTokens()){
                temp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            } else {
                sum -= temp; 
            }

        }

        bw.write(sum+"");

        br.close();
        bw.close();
    }
}
