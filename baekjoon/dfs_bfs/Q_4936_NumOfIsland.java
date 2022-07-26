package baekjoon.dfs_bfs;
import java.io.*;
import java.util.StringTokenizer;

public class Q_4936_NumOfIsland {
    public static int[][] arr;
    public static int w, h;

    public static int solution() {
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j);
                    result += 1;
                }
            }
        }

        return result;
    }
    public static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= h || y >= w) {
            return;
        } else if(arr[x][y] == 1){
            arr[x][y] = 0;

            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            dfs(x - 1, y - 1);
            dfs(x - 1, y + 1);
            dfs(x + 1, y - 1);
            dfs(x + 1, y + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0) break;
            arr = new int[h][w];
            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(solution()+"\n");
        }
        br.close();
        bw.close();
    }
}
