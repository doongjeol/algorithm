package baekjoon.tree;
import java.io.*;
import java.util.StringTokenizer;

public class Q_14426_FindPrefix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if (str.equals(s[j].substring(0, str.length()))) {
                    count += 1;
                    break;
                }
            }
        }

        bw.write(count +"\n");

        br.close();
        bw.close();
    }
}
