package baekjoon.string;
import java.io.*;

public class Q_8958_OXQuiz {
    public static int solution(String str){
        int score = 0;
        int total = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='O'){
                score += 1;
                total += score;
            } else {
                score = 0;
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();

            bw.write(solution(str)+"\n");


        }
        br.close();
        bw.close();
    }
}
