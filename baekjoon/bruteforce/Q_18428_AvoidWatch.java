package baekjoon.bruteforce;
import java.io.*;
import java.util.StringTokenizer;

public class Q_18428_AvoidWatch {
    public static void solution() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        br.close();
        bw.close();
    }
}
