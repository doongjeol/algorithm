package baekjoon.bruteforce;
import java.io.*;

public class Q_1342_StringOfLuck {
    public static int[] a = new int[26];
    public static String str = "";
    public static int result;
    public static void solution(int depth, int selected) {
        if(depth == str.length()){
            result += 1;
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0) continue;
            if(selected == i) continue;
            a[i] --;
            solution(depth + 1, i);
            a[i] ++;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0' - 49;
            a[index] += 1;
        }

        solution(0,-1);
        bw.write(result+"");

        br.close();
        bw.close();
    }
}
