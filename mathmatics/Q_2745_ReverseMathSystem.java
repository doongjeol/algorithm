package mathmatics;

import java.io.*;
import java.util.StringTokenizer;

public class Q_2745_ReverseMathSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        bw.write(solution(n,b)+"\n");

        br.close();
        bw.close();
    }

    public static int solution(String n, int b) {
        int result = 0;

        for (int i = n.length()-1; i >=0 ; i--) {
            int num = n.charAt(i);
            if(num >= 'A') {
                num = num - 'A' + 10;
            } else {
                num -= '0';
            }

            result += (int) Math.pow(b,n.length()-1-i)*num;

        }

        return result;
    }
}
