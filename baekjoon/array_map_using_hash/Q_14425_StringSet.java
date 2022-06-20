package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q_14425_StringSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Boolean> hashMap = new HashMap();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            hashMap.put(str,true);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if(hashMap.containsKey(str)){
                count += 1;
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }
}
