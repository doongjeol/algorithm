package baekjoon.string;

import java.io.*;
import java.util.*;

public class Q_1181_SortingWord_fail {
    public static class Word {
        int length;
        String wordStr;

        public Word(String wordStr) {
            this.length = wordStr.length();
            this.wordStr = wordStr;
        }
    }

    public static class WordCompare implements Comparator<Word> {
        int ret;

        @Override
        public int compare(Word o1, Word o2) {
            if(o1.length > o2.length){ // 문자열 길이 오름차순
                ret = 1;
            } else if(o1.length == o2.length){
                ret = o1.wordStr.compareTo(o2.wordStr);
            } else if(o1.length < o2.length){
                ret = -1;
            }
            return ret;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Word> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            list.add(new Word(str));
        }

        for (int i = 0; i < n; i++) {
            bw.write(list.get(i).wordStr+"\n");
        }

        // 정렬
        Collections.sort(list, new WordCompare());

        for (int i = 0; i < n; i++) {
            bw.write(list.get(i).wordStr+"\n");
        }
        br.close();
        bw.close();
    }
}
