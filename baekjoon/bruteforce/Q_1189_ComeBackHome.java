package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_1189_ComeBackHome {
    public static int r,c,k,result;
    public static char[][] map ;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void solution(int curR, int curC, int depth){
        if (curR == r - 1 && curC == c - 1) {
            if(depth == 4){
                result += 1;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            curR = curR + dx[i];
            curC = curC + dy[i];
            if(curR < 0 || curC < 0 || curR >= r || curC >= c) continue;
            if(map[curR][curC] == 'T') continue;
            solution(curR, curC, depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(0);
            }
        }

        solution(r-1,0,0);
        bw.write(result+"");

        br.close();
        bw.close();
    }
}
