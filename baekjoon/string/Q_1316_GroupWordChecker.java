package baekjoon.string;

import java.io.*;

public class Q_1316_GroupWordChecker {
    public static int result = 0;
    public static boolean isGroup = true;
    public static void solution(String str) {
        int[] alphabet = new int[26];
        int index = str.charAt(0) - 'a';
        alphabet[index] += 1;
        for (int i = 1; i < str.length(); i++) {
            index = str.charAt(i) - 'a';
            int preIndex = str.charAt(i-1) -'a';
            if(alphabet[index] > 0 && index != preIndex) {
                isGroup = false;
                break;
            }
            alphabet[index] += 1;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            isGroup = true; // 초기화
            solution(str);
            if(isGroup) result+=1;
        }

        bw.write(result+"");

        br.close();
        bw.close();
    }
}
