package baekjoon.dfs_bfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_14502_Laboratory {
    public static int[][] map;
    public static int n,m;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int result = Integer.MIN_VALUE;
    // 벽 세우기
    public static void dfs(int count){
        // 벽 3개를 다 세웠으면 바이러스 퍼뜨리기
        if(count == 3) {
            bfs();
            return;
        }

        // 벽 3개를 아직 세우지 않았다면 세우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 빈칸이라면
                if(map[i][j] == 0){
                    map[i][j] = 1; // 벽 세우기
                    dfs(count + 1);
                    map[i][j] = 0; // 다시 돌려놓기
                }
            }
        }
        
    }

    // 바이러스 퍼뜨리기
    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();

        int[][] tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 바이러스라면 큐에 넣기
                if(tempMap[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            // 마지막 위치일 때 return
            if(cur.r == n && cur.c == m) return;
            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dx[i];
                int nextC = cur.c + dy[i];

                if(nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) continue;
                if(tempMap[nextR][nextC] == 0){
                    tempMap[nextR][nextC] = 2;
                    q.add(new Pair(nextR, nextC));
                }
            }
        }

        getArea(tempMap);
    }

    public static void getArea(int[][] tempMap){
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tempMap[i][j] == 0){
                    count += 1;
                }
            }
        }

        result = Math.max(count, result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        bw.write(result +"");
        br.close();
        bw.close();
    }
    public static class Pair{
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
