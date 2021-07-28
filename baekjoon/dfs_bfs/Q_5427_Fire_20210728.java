package baekjoon.dfs_bfs;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_5427_Fire_20210728 {
    public static int w,h; // h : 행 | w : 열
    public static char[][] map;
    public static int[][] visited;
    public static int fireR, fireC,sangR, sangC;
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,-1,0,1};
    public static boolean isSuccess; // 탈출 성공 여부

    public static void bfs(){
        isSuccess = false;
        Queue<Pair> fireQ = new LinkedList<>();
        Queue<Pair> sangQ = new LinkedList<>();

        fireQ.add(new Pair(fireR, fireC));
        sangQ.add(new Pair(sangR, sangC));
        visited[sangR][sangC] = 0;

        while(!sangQ.isEmpty()) {
            Pair fireCur = fireQ.poll();
            Pair sangCur = sangQ.poll();

            int fireCurR = fireCur.r;
            int fireCurC = fireCur.c;
            int sangCurR = sangCur.r;
            int sangCurC = sangCur.c;

            if(sangCurR == 0 || sangCurR == (h-1) || sangCurC == 0 || sangCurC == (w-1)) {
                isSuccess = true;
                break;
            }

            for (int i = 0; i < 4; i++) {

                int fireNextR = fireCurR + dr[i];
                int fireNextC = fireCurC + dc[i];
                int sangNextR = sangCurR + dr[i];
                int sangNextC = sangCurC + dc[i];

                if (fireNextR < 0 || fireNextC < 0 || fireNextR >= h || fireNextC >= w) continue;
                if (sangNextR < 0 || sangNextC < 0 || sangNextR >= h || sangNextC >= w) continue;
                if (map[fireNextR][fireNextC] == '.' || map[fireNextR][fireNextC] == '*') {
                    map[fireNextR][fireNextC] = '*';
                    fireQ.add(new Pair(fireNextR, fireNextC));
                }
                if (map[sangNextR][sangNextC] == '.' && visited[sangNextR][sangNextC] == -1) {
                    visited[sangNextR][sangNextC] = visited[sangCurR][sangCurC] + 1;
                    sangQ.add(new Pair(sangNextR,sangNextC));
                }

            }
        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        visited = new int[h][w];

        for (int i = 0; i < h; i++) {
            String temp = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = temp.charAt(j);
                visited[i][j] = -1; // 초기화
                if(map[i][j] == '*') {
                    fireR = i;
                    fireC = j;
                }
                if(map[i][j] == '@'){
                    sangR = i;
                    sangC = j;
                }
            }

            bfs();
            bw.write(isSuccess+"");
        }

        br.close();
        bw.close();
    }

    static class Pair{
        int r;
        int c;

        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
