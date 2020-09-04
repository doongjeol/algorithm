package string;

import java.io.*;

public class Q_10820_AnalyzeString {
    public static int[] result; // 0 : 소문자, 1 : 대문자, 2 : 숫자, 3 : 공백
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            String str = br.readLine();
            if(str != null) {
                result = new int[4];
                solution(str);
                bw.write(result[0]+" "+result[1]+" "+ result[2]+" "+result[3]+"\n");
            } else break;

        }

        bw.close();
        br.close();
    }

    public static void solution(String str){
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 97 && c <= 122) // 소문자
                result[0] += 1;
            else if(c <= 90 && c >= 65) // 대문자
                result[1] += 1;
            else if(c == 32) //공백
                result[3] += 1;
            else if(c <= 57 && c >= 48)// 숫자
                result[2] += 1;
        }
    }
}
