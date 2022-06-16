package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.*;

public class Q_1302_BestSeller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> hashmap = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(hashmap.containsKey(str)) {
                int count = hashmap.get(str);
                hashmap.put(str, count+1);
            } else {
                hashmap.put(str, 1);
            }
        }

        List<Map.Entry<String, Integer>> enrtyList = new LinkedList<>(hashmap.entrySet());
        enrtyList.sort(new Comparator<Map.Entry<String, Integer>>() {
            int ret = 0;
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()){
                    if(o1.getKey().compareTo(o2.getKey()) < 0) {
                        ret = -1;
                    } else if(o1.getKey().compareTo(o2.getKey()) == 0) {
                        ret = 0;
                    } else if(o1.getKey().compareTo(o2.getKey()) > 0) {
                        ret = 1;
                    }
                } else {
                    ret = o2.getValue() - o1.getValue();
                }
                return ret;
            }
        });

        bw.write(enrtyList.get(0).getKey());
        br.close();
        bw.close();
    }
}
