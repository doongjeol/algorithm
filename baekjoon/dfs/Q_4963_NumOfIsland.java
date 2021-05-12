package baekjoon.dfs;
import java.io.*;
import java.util.StringTokenizer;

public class Q_4963_NumOfIsland {
    public static int w,h;
    public static int[][] map;
    public static void solution(){

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String firstLine = br.readLine();
            if(firstLine == null) break;
            StringTokenizer st = new StringTokenizer(firstLine);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            map = new int[w][h];

            for (int i = 0; i < w; i++) {
                String str = br.readLine();
                for (int j = 0; j < h; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }



        }

        br.close();
        bw.close();
    }
}
