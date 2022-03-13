package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Q_1891_Quadrant {
    public static int d;
    public static int startNumber;
    public static int startNumR, startNumC;
    public static int[][] map;
    public static void solution(int n, String curNumber, int curD,int startR, int startC){
        if(curD == d+1){
            return;
        }
        int half = n/2;

        for (int i = startR; i < startR + n; i++) {
            for (int j = startC; j < startC + n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(map[i][j]) + curNumber);
                if(map[i][j] == startNumber){
                    startNumR = i;
                    startNumC = j;
                }
            }
        }

        solution(half,"2",curD+1,startR,startC); // 2사분면
        solution(half,"1",curD+1,startR,startC+half); // 1사분면
        solution(half,"3",curD+1,startR+half,startC); // 3사분면
        solution(half,"4",curD+1,startR+half,startC+half); // 4사분면

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        int n = (int) Math.pow(2,d);
        map = new int[n][n];

        startNumber = Integer.parseInt(st.nextToken());

        solution(n,"",0,0,0);

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bw.write(map[startNumR-y][startNumC+x]+"");


        br.close();
        bw.close();
    }

}
