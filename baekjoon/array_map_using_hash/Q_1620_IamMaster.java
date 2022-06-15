package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q_1620_IamMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> mapStr = new HashMap<>();
        HashMap<Integer, String> mapInt = new HashMap<>();
        for (int i = 1; i < n+1; i++) {
            String str = br.readLine();
            mapStr.put(str, i);
            mapInt.put(i, str);
        }

        for (int i = 0; i < m; i++) {
            String quiz = br.readLine();
            if(quiz.charAt(0) <= '9'){
                int q = Integer.parseInt(quiz);
                bw.write(mapInt.get(q)+"\n");
            } else {
                bw.write(mapStr.get(quiz)+"\n");
            }
        }

        br.close();
        bw.close();
    }
}
