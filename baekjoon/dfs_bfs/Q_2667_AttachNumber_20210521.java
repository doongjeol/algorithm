package baekjoon.dfs_bfs;
import java.io.*;
import java.util.*;

public class Q_2667_AttachNumber_20210521 {
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    // 상좌하우
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int count;
    public static List<Integer> result = new ArrayList();
    public static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

    }
    
    public static void dfs(int curR, int curC){
        // 방문 처리
        visited[curR][curC] = true;
        count ++;

        for (int dir = 0; dir < 4; dir++) {
            int nextR = curR + dx[dir];
            int nextC = curC + dy[dir];

            // 범위를 벗어나면 반복문 넘어가기
            if(nextR < 0 || nextC < 0 || nextR >= n || nextC >=n) continue;
            else if(map[nextR][nextC] == 1 && !visited[nextR][nextC]){
                dfs(nextR, nextC);
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0 ; i<n ; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        solution();

        Collections.sort(result); // list 오름차순 정렬
        bw.write(result.size()+"\n");
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i)+"\n");
        }
        br.close();
        bw.close();
    }
}
