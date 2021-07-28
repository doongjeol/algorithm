package baekjoon.dfs_bfs;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_6593_SangbumBuilding_20210728 {
    public static int l,r,c; // l : 층 수 | r : 행 | c : 열
    public static int sl,sr,sc;
    public static int el,er,ec;
    public static char[][][] building;
    public static int[][][] visited;
    public static int[] dl = {0, 0, 0, 0, -1, 1};
    public static int[] dr = {-1, 0, 1, 0, 0, 0};
    public static int[] dc = {0, -1, 0, 1, 0, 0};

    public static void bfs(){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sl, sr, sc));
        visited[sl][sr][sc] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int curL = cur.l;
            int curR = cur.r;
            int curC = cur.c;

            for (int i = 0; i < 6; i++) {
                int nextL = curL + dl[i];
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if (nextL < 0 || nextL >= l || nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) continue;
                if (building[nextL][nextR][nextC] != '#' && visited[nextL][nextR][nextC] == -1){
                    q.add(new Pair(nextL, nextR, nextC));
                    visited[nextL][nextR][nextC] = visited[curL][curR][curC] + 1;
                }

            }

        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0) break;

            building = new char[l][r][c];
            visited = new int[l][r][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String temp = br.readLine();
                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = temp.charAt(k);
                        visited[i][j][k] = -1; // -1로 초기화
                        if(building[i][j][k] == 'S'){
                            sl = i;
                            sr = j;
                            sc = k;
                        }
                        if(building[i][j][k] == 'E'){
                            el = i;
                            er = j;
                            ec = k;
                        }

                    }
                }
                br.readLine();
            }

            bfs();
            if(visited[el][er][ec] == -1){
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in "+visited[el][er][ec]+" minute(s).\n");
            }

        }

        br.close();
        bw.close();
    }

    public static class Pair{
        int l;
        int r;
        int c;

        public Pair(int l, int r, int c){
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
}
