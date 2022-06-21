package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q_2776_KingOfMemory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<Integer,Boolean> hashMap = new HashMap();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                hashMap.put(Integer.parseInt(st.nextToken()), true);
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int answer = Integer.parseInt(st.nextToken());

                if (hashMap.containsKey(answer)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }

        br.close();
        bw.close();
    }
}
