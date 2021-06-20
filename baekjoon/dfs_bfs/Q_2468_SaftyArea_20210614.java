package baekjoon.dfs_bfs;
import java.io.*;
import java.util.StringTokenizer;

public class Q_2468_SaftyArea_20210614 {
    public static int n;
    public static int maxHeight;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int count;
    public static int result;

    public static int solution(){
        for(int rain = 0 ; rain <= maxHeight+1 ; rain++){
            visited = new boolean[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if(!visited[r][c] && map[r][c] > rain) {
                        dfs(r, c, rain);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
            count = 0;
        }

        return result;

    }

    public static void dfs(int curR, int curC, int rain){
        visited[curR][curC] = true;

        for(int dir = 0 ; dir<4 ; dir ++){
            int nextR = curR + dx[dir];
            int nextC = curC + dy[dir];

            if(nextR <0 || nextC <0 || nextR >=n || nextC >=n) continue;
            else if(!visited[nextR][nextC] && map[nextR][nextC] > rain)
                dfs(nextR, nextC, rain);
        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        bw.write(solution()+"");

        br.close();
        bw.close();
    }
}
