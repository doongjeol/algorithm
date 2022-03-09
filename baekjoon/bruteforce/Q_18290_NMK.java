package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_18290_NMK {
    public static int[][] data;
    public static int max = -40001;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};
    
    public static void combination(int n, int m, boolean[][] visited, int idx, int count, int k){
        if(count == k){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(visited[i][j]) {
                        sum += data[i][j];
                    }
                }
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = idx; i < n*m ; i++) {
            boolean flag = false;
            int r = i/m;
            int c = i%m;

            for (int dir = 0; dir < 4; dir++) {
                int nextR = r + dx[dir];
                int nextC = c + dy[dir];

                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m ) {
                    continue;
                } else if(visited[nextR][nextC]){
                    flag = true;
                }
            }

            if(!flag){
                visited[r][c] = true;
                combination(n, m, visited,i+1, count+1,k);
                visited[r][c] = false;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        data = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        combination(n, m, visited, 0, 0, k);

        bw.write(max+"");

        br.close();
        bw.close();
    }
}
