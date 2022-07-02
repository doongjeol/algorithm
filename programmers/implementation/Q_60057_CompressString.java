package programmers.implementation;
import java.io.*;
import java.util.HashMap;

public class Q_60057_CompressString {
    public static int solution(String s) {
        int answer = 1001;
        for (int standard = 1; standard < s.length(); standard++) {
            int count = 0;
            if(s.length() % standard != 0) continue;
            String tmp = "";
            String str = "";
            int compress = 0;
            for (int i = 0; i < s.length(); i += standard) {
                str = "";
                for (int j = i; j < i+standard; j++) {
                    str += String.valueOf(s.charAt(j));
                }
                if(tmp.equals(str)){
                    compress += 1;
                } else {
                    compress = 0;
                }
                tmp = str;
                // 압축되지 않을 때
                if(compress == 0){
                    count += standard;

                // 압축되었을 때
                } else if(compress == 1) {
                    count += 1;
                }
            }
            answer = Math.min(answer, count);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        String s = "abcabcdede";
        System.out.println(solution(s));
    }
}
