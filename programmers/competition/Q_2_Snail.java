package programmers.competition;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q_2_Snail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] result = solution(n);

        for (int i = 0; i < result.length; i++) {
            for(int j=0 ; j< result.length ; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    public static int[][] solution(int n) {
        int[] answer = {};
        int[][] a = new int[n][n];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max += i;
        }

        boolean wh = false; // false : 세로, true : 가로
        int num = 0;
        /*// 아래로 :0
        a[아래++][고정];
        // 오른쪽 :1
        a[전행=][전열+1 ++];
        // 위로 :2
        a[전행-1 --][전열 --];

        */
        int downX_min = 0;
        int downX_max = n;
        int downY = 0;
        int right_min = 0;
        int right_max = n;
        int upX = n-1-1;
        int upY = n-1-1;
        int index = 0;

        while(true) {
            System.out.println(index+"*");
            if(index == n)
                break;

            // 아래로
            for (int i = downX_min; i < downX_max; i++) {
                a[i][downY] = 0;
            }
            index++;
            downX_max -= 1;
            right_min = downY + 1;

            // 오른쪽으로
            for (int j = right_min; j < right_max; j++) {
                a[downX_max][j] = 1;
            }
            index++;
            upX = downX_max - 1;
            upY = right_max - 1 - 1;

            // 위로
            for (int i = upX; i >= 1; i--) {
                a[i][upY] = 2;
                upY--;
                downX_min = i-1;
            }
            index++;
            downY =upY;

        }

        return a;
    }
}
