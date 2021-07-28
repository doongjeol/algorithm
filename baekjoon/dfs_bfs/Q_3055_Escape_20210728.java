package baekjoon.dfs_bfs;
import java.io.*;
import java.util.StringTokenizer;

public class Q_3055_Escape_20210728 {
    public static int r,c;
    public static int sr, sc, dr, dc;
    public static char[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void bfs(){

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'S'){
                    sr = i;
                    sc = j;
                }
                if(map[i][j] == 'D'){
                    dr = i;
                    dc = j;
                }
            }
        }

        br.close();
        bw.close();
    }
}
