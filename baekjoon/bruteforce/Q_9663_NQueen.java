package baekjoon.bruteforce;
import java.io.*;

public class Q_9663_NQueen {
    public static int result = 0;

    public static void combination(int row, int n, boolean[][] visited, int[][] index){
        if(row == n){
            result ++;
            return;
        }

        out : for (int col = 0; col < n; col++) {
            for (int i = 0; i < row; i++) {
                if(index[i][1] == col && row > 0) continue out;
                if(Math.abs(index[i][1] - col) == Math.abs(index[i][0] - row) && row>0) continue out;
            }
            if(!visited[row][col]){
                index[row][0] = row;
                index[row][1] = col;
                visited[row][col] = true;
                combination(row+1, n, visited, index);
                visited[row][col] = false;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        combination(0,n, new boolean[n][n], new int[n][2]);
        bw.write(result+"");
            
        br.close();
        bw.close();
    }
}
