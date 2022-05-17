package baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q_1181_SortingWord {

    public static class WordCompare implements Comparator<String> {
        int ret;

        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length()){ // 문자열 길이 오름차순
                ret = 1;
            } else if(o1.length() == o2.length()){
                ret = o1.compareTo(o2);
            } else if(o1.length() < o2.length()){
                ret = -1;
            }
            return ret;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if(!list.contains(str)) {
                list.add(str);
            }
        }

        // 정렬
        Collections.sort(list, new WordCompare());

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i)+"\n");
        }
        br.close();
        bw.close();
    }
}
