package baekjoon.dfs_bfs;
import java.io.*;
import java.util.*;

public class Q_9205_Walk {
    static int n,sx,sy,dx,dy;
    public static int[][] map ;
    public static int[] beer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            beer = new int[21];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {  // j:0 - 상근이네, j:1 - 편의점, j:2 - 페스티벌 좌표
                map[j][0] = Integer.parseInt(st.nextToken());
                map[j][1] = Integer.parseInt(st.nextToken());
            }
        }

        bw.close();
        br.close();
    }
    public static int distance(int x1, int y1, int x2, int y2){
        int distance = Math.abs(x1 - x2) + Math.abs(x2 - y2);
        return distance;
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
//        q.add
        return false;
    }

    class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
}
