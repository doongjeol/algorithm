package baekjoon.dp;
import java.io.*;
import java.util.StringTokenizer;

public class Q_9465_Stricker {
    public static int solution(int[][] sticker){
        int n = sticker[0].length;
        int[][] a = new int[3][n];
        int max = 0;
        
        a[0][0] = 0;
        a[1][0] = sticker[0][0];
        a[2][0] = sticker[1][0];

        for(int col=1 ; col<n; col++){
            a[0][col] = Math.max(a[0][col - 1], Math.max(a[1][col - 1], a[2][col - 1]));
            a[1][col] = Math.max(a[0][col - 1], a[2][col - 1]) + sticker[0][col];
            a[2][col] = Math.max(a[0][col - 1], a[1][col - 1]) + sticker[1][col];
        }

        max = Math.max(a[0][n-1], Math.max(a[1][n-1], a[2][n-1]));

        return max;

    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // n열
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[][] sticker = new int[2][n]; // 스티커 점수
            for (int col = 0; col < n; col++) {
                sticker[0][col] = Integer.parseInt(st.nextToken());
                sticker[1][col] = Integer.parseInt(st2.nextToken());
            }

            bw.write(solution(sticker) + "\n");
        }
        br.close();
        bw.close();
    }

    public static void print(int[][] array) {
        for(int i=0 ; i<array.length ; i++) {
            for(int j=0 ; j<array[0].length ; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
