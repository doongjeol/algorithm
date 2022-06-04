package baekjoon.string;
import java.io.*;

public class Q_WhiteArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] map = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int result = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row % 2 == 0 && col %2 == 0 && map[row][col] == 'F') {
                    result += 1;
                } else if (row %2 == 1 && col %2 == 1 && map[row][col] == 'F'){
                    result += 1;
                }
            }
        }

        bw.write(result+"");
        br.close();
        bw.close();
    }
}
