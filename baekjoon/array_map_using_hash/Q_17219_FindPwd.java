package baekjoon.array_map_using_hash;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q_17219_FindPwd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap <String, String> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hashMap.put(st.nextToken(), st.nextToken());

        }

        String[] quiz = new String[m];
        for (int i = 0; i < m; i++) {
            quiz[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            bw.write(hashMap.get(quiz[i])+"\n");
        }
        br.close();
        bw.close();
    }
}
