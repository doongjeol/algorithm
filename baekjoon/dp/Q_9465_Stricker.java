package baekjoon.dp;
import java.io.*;
import java.util.StringTokenizer;

public class Q_9465_Stricker {
    public static int solution(int[][] sticker){
        int[][] a = new int[3][sticker.length];
        int max = 0;

        for(int i=1 ; i<sticker.length ; i++){
            a[0][i] = Math.max(a[0][i - 1], Math.max(a[1][i - 1], a[2][i - 1]));
            a[1][i] = Math.max(a[0][i - 1], a[2][i - 1]) + sticker[0][i];
            a[2][i] = Math.max(a[0][i - 1], a[1][i - 1]) + sticker[1][i];
            max = Math.max(a[0][i], Math.max(a[0][i], a[2][i]));

        }

        return max;

    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // n열
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] sticker = new int[2][n]; // 스티커 점수
            for(int row = 0 ; row < 2 ; row ++) {
                for (int col = 0; col < n; i++) {
                    sticker[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(solution(sticker) + "\n");
        }
        br.close();
        bw.close();
    }
}
