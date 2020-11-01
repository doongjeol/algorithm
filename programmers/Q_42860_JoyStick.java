package programmers;

import java.io.*;

public class Q_42860_JoyStick {
    public static int solution(String name) {
        int answer = 0;
        int max = 'Z' - 'A' + 1;

        for (int i = 0; i <name.length() ; i++) {
            int alpha = name.charAt(i) - 'A' + 1; // 알파벳
            if(alpha == 1 && i==name.length()-1){
                break;
            } else if(alpha <= 13 && alpha > 1){
                answer += (alpha - 1) + 1;
            } else if(alpha > 13){
                answer += (max - (alpha - 1)) + 1;
            }

            if (i == name.length() - 1)
                answer--;
        }
        return answer;
    }

    public static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        br.close();
        return name;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = solution(input());

        bw.write(answer+"\n");
        bw.close();
    }

}
