package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.*;

public class Q_2910_SortFrequency {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        LinkedHashMap<String, Integer> hashMapList = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String str = st.nextToken();
            if(hashMapList.containsKey(str)) {
                int count = hashMapList.get(str) + 1;
                hashMapList.put(str, count);
            } else {
                hashMapList.put(str, 1);
            }
        }


        LinkedHashMap<String,Integer> result = sortMapByValue(hashMapList, 1);
        Object[] key = result.keySet().toArray();
        for (int i = 0; i < key.length; i++) {
            int count = result.get(key[i]);
            while(count > 0) {
                bw.write(key[i] + " ");
                count -- ;
            }
        }

        br.close();
        bw.close();
    }
    public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map, Integer orderBy) {
        /***
         * Sort Map type data by value
         * @param map - unsorted Map type data [target]
         * @param orderBy - 0: ASC, 1: DESC
         * @return sorted LinkedHashMap type data by value.
         */
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        if(orderBy == 0) {
            Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        }
        else {
            Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        }

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

}
