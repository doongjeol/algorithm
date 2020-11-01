package programmers;


import java.io.*;

public class Q_42883_MakeHighNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        int k = Integer.parseInt(br.readLine());

        bw.write(solution(num,k));
        br.close();
        bw.close();
    }

    public static String solution(String number, int k) {
        String answer = number;
        StringBuilder sb = new StringBuilder(answer);
        sb.deleteCharAt(0);

        return answer;
    }
}
