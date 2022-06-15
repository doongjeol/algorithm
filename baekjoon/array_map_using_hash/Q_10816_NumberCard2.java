package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q_10816_NumberCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int count = map.get(num)+1;
                map.put(num,count);
            }
        }

        int sang = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sang; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(num)){
                bw.write("0 ");
            } else {
                bw.write(map.get(num)+" ");
            }
        }

        map.get(10);
        br.close();
        bw.close();
    }
}
