package baekjoon.dfs_bfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_16236_BabyShark {
    public static int[][] map, time;
    public static int startR, startC, n;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startR, startC, 2));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dx[i];
                int nextC = cur.c + dy[i];

                if(nextR < 0 || nextC < 0 || nextR >= n || nextC >= n) continue;
                if(cur.size < map[nextR][nextC]) continue;
                if(cur.size > map[nextR][nextC]) {
                    time[nextR][nextC] = time[cur.r][cur.c] + 1;
                    q.add(new Pair(nextR, nextC, cur.size + map[nextR][nextC]));
                    map[nextR][nextC] = 0;
                    if(isEnd(cur.size + map[nextR][nextC])) return;
                } else if(cur.size == map[nextR][nextC] || map[nextR][nextC] == 0){
                    time[nextR][nextC] = time[cur.r][cur.c] + 1;
                    q.add(new Pair(nextR, nextC, cur.size));
                    if(isEnd(cur.size)) return;
                }
            }

        }
    }
    public static boolean isEnd(int curSize){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(curSize < map[i][j]) return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        time = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    startR = i;
                    startC = j;
                }
            }
        }
        bfs();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, time[i][j]);
            }
        }

        bw.write(result +"");

        br.close();
        bw.close();
    }
    public static class Pair{
        int r;
        int c;
        int size;

        Pair(int r, int c, int size){
            this.r = r;
            this.c = c;
            this.size = size;
        }
    }
}
