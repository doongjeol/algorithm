package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Q_1891_Quadrant {
    public static int d;
    public static String startNumber;
    public static long startNumR, startNumC;
    public static String answer = "";

    public static void findIndex(int depth, long cr, long cc){
        if(depth == d){
            startNumR = cr;
            startNumC = cc;
            return;
        }

        int position = startNumber.charAt(depth) - '0';

        if(position == 1){
            findIndex(depth + 1, 2 * cr, 2 * cc + 1);
        } else if(position == 2){
            findIndex(depth + 1, 2 * cr, 2 * cc);
        } else if(position == 3){
            findIndex(depth + 1, 2 * cr + 1, 2 * cc);
        } else if(position == 4){
            findIndex(depth + 1, 2 * cr + 1, 2 * cc + 1);
        }

    }

    public static void solution(int depth, long cr, long cc){
        if(depth == d){
            return;
        }

        long r = cr % 2;
        long c = cc % 2;

        if(r == 0 && c == 1){
            answer += String.valueOf(1);
        } else if(r == 0 && c == 0){
            answer += String.valueOf(2);
        } else if (r == 1 && c == 0) {
            answer += String.valueOf(3);
        } else if (r == 1 && r == 1) {
            answer += String.valueOf(4);
        }

        solution(depth + 1, cr / 2, cc / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        startNumber = st.nextToken();

        findIndex(0,0,0);
        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long moveR = startNumR - y;
        long moveC = startNumC + x;

        if(moveR < 0 || moveC < 0 || moveR >= Math.pow(2,d) || moveC >= Math.pow(2,d)){
            bw.write("-1");
        } else {
            solution(0, moveR, moveC);
            for (int i = answer.length()-1; i >=0 ; i--) {
                bw.write(answer.charAt(i));
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

}
