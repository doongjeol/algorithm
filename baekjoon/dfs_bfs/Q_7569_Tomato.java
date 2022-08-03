package baekjoon.dfs_bfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7569_Tomato {
    public static int m,n,h;
    public static int[][][] box;
    public static int[] dr = {-1, 0, 1, 0, 0, 0};
    public static int[] dc = {0, -1, 0, 1, 0, 0};
    public static int[] dh = {0, 0, 0, 0, -1, 1};
    public static int result = 0;
    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    // 익은 토마토라면 큐에 넣기
                    if(box[j][k][i] == 1){
                        box[j][k][i] = 0;
                        q.add(new Pair(j, k, i));
                        visited[j][k][i] = true;
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Pair cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int nextR = cur.row + dr[i];
                int nextC = cur.col + dc[i];
                int nextH = cur.height + dh[i];

                if(nextR < 0 || nextC < 0 || nextH < 0 || nextR >= n || nextC >= m || nextH >= h) continue;
                if(box[nextR][nextC][nextH] == -1) continue;
                if(!visited[nextR][nextC][nextH] && box[nextR][nextC][nextH] == -2){
                    q.add(new Pair(nextR, nextC, nextH));
                    box[nextR][nextC][nextH] = box[cur.row][cur.col][cur.height] + 1;
                    visited[nextR][nextC][nextH] = true;
                }
            }
        }
    }

    public static void isCheck(){
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(box[j][k][i] == -2) {
                        result = -1;
                        return;
                    }
                    result = Math.max(box[j][k][i], result);
                }
            }
        }
    }

    public static boolean startCheck(){
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(box[j][k][i] == -2) return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[n][m][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[j][k][i] = Integer.parseInt(st.nextToken());
                    if(box[j][k][i] == 0) box[j][k][i] = -2;
                }
            }
        }

        if(!startCheck()) {
            bfs();
            isCheck();
        }
        bw.write(result+"");

        br.close();
        bw.close();
    }
    public static class Pair{
        int row;
        int col;
        int height;

        public Pair(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
