package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_1107_RemoteController {
    public static int[] noButton;
    public static String n;
    public static String str ="";
    public static int count;
    public static void solution(int depth){
        if(depth == n.length())
            return;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < noButton.length; j++) {
                if(n.charAt(depth)-'0' == j) continue;
            }

            if(n.charAt(depth)-'0' == i) {
                System.out.println(str);
                str += String.valueOf(i);
                count += 1;
                solution(depth + 1);
            }

        }

    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = br.readLine();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        noButton = new int[m];

        for (int i = 0; i < m; i++) {
            noButton[i] = Integer.parseInt(st.nextToken());
        }

        solution(0);
        int resultNum = Integer.parseInt(str);
        int num = Integer.parseInt(n);
        bw.write(count + Math.abs(resultNum - num) + "");

        br.close();
        bw.close();
    }
}
