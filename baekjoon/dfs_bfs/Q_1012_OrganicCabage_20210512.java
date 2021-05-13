package baekjoon.dfs_bfs;
import java.io.*;
import java.util.StringTokenizer;

public class Q_1012_OrganicCabage_20210512 {
    public static int m,n;
    public static int[][] map;
    public static int solution(){
        int result = 0;
        // dfs 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 배추가 심어져있을 때만 방문
                if(map[i][j] == 1){
                    dfs(i, j);
                    result ++;
                }
            }


        }
        return result;

    }

    public static void dfs(int row, int col){
        if(row < 0 || col < 0 || row >=n || col >=m) return;

        if(map[row][col] == 1){
            // 방문처리
            map[row][col] = 0;

            // 상, 하, 좌, 우 방문 처리
            dfs(row - 1, col);
            dfs(row + 1, col);
            dfs(row, col - 1);
            dfs(row, col + 1);
        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < t; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[n][m];

            for(int i=0 ; i<k ; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                map[row][col] = 1;
            }

            // 메소드 호출
            System.out.println(solution());

        }

        br.close();
        bw.close();
    }
}
