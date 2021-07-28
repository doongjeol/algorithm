package baekjoon.dfs_bfs;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2178_Maze_20210723 {
    public static int n,m;
    public static int[][] maze;
    public static int[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};


    public static void bfs(){
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(0, 0));
        visited[0][0] = 1; // 처음 칸도 지나는 것에 포함되므로 1로 처리

        while(!q.isEmpty()){
            Pair cur = q.poll();
            int curR = cur.r;
            int curC = cur.c;

            for(int i=0 ; i<4 ; i++){
                int nextR = curR + dx[i];
                int nextC = curC + dy[i];

                if(nextR < 0 || nextC < 0 || nextR >=n || nextC >=m) continue;
                if(maze[nextR][nextC] == 0) continue;
                if(maze[nextR][nextC] == 1 && visited[nextR][nextC] == 0) {
                    visited[nextR][nextC] = visited[curR][curC] + 1;
                    q.add(new Pair(nextR,nextC));
                }
            }

        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for(int j=0 ; j < m ; j++) {
                maze[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs();
        bw.write(visited[n-1][m-1]+"");

        br.close();
        bw.close();
    }

    public static class Pair{
        int r;
        int c;

        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
