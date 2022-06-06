package baekjoon.string;
import java.io.*;

/* 공통적인 알파벳은 적어주고 그렇지 않은 위치는 ?로 적어준다
* */
public class Q_1032_CommandPrompt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        boolean isSame = true;

        for (int i = 0; i < str[0].length(); i++) {
            char c = str[0].charAt(i);
            isSame = true;

            /* 입력받은 n개의 문자열 중 첫번째 문자열의 i번째 문자 기준으로
            문자가 같은 지 비교
             */
            for (int j = 1; j < n; j++) {
                if (c != str[j].charAt(i)) {
                    isSame = false;
                    break;
                }

            }
            if(isSame){
                sb.append(c);
            } else {
                sb.append('?');
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
