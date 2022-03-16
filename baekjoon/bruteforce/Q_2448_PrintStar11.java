package baekjoon.bruteforce;
import java.io.*;

public class Q_2448_PrintStar11 {
    public static char[][] result;
    public static void solution(int n, int startR, int startC, int position, int depth){

        int half = n/2;
        printStar(n,startR,startC,position);

        solution(half,startR,startC,0,depth+1);
        solution(half, startR, startC + half, 1,depth+1);
        solution(half, startR + half, startC, 2,depth+1);
        solution(half, startR + half, startC + half, 3,depth+1);
    }

    public static void printStar(int n, int startR, int startC, int position){
//        for (int i = startR; i < startR + n; i++) {
//            for (int j = startC; j < startC + n; j++) {
                switch (position){
                    case 0 :
                        result[startR][startC + n - 1] = '*';
                        result[startR + 1][startC + n - 2] = '*';
                        result[startR + 2][startC] = '*';
                        result[startR + 2][startC + 1] = '*';
                        result[startR + 2][startC + 2] = '*';
                        break;
                    case 1 :
                        result[startR + 1][startC + 1] = '*';
                        result[startR + 2][startC + 1] = '*';
                        result[startR + 2][startC + 2] = '*';
                        break;
                    case 2 :
                    case 3 :
                        result[startR][startC + n - 1] = '*';
                        result[startR + 1][startC + n - 2] = '*';
                        result[startR + 2][startC] = '*';
                        result[startR + 2][startC + 1] = '*';
                        result[startR + 2][startC + 2] = '*';
                        result[startR + 1][startC + 1] = '*';
                        result[startR + 2][startC + 1] = '*';
                        result[startR + 2][startC + 2] = '*';
                        break;
                }
//            }
//        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        result = new char[n][n];

        solution(n,0,0,2,0);
        br.close();
        bw.close();
    }
}
