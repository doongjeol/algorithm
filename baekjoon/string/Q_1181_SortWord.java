package baekjoon.string;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q_1181_SortWord {
    public static Word[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        order = new Word[n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            order[i] = new Word(str.length(),str);
        }

        Arrays.sort(order, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return 0;
            }
        });

        br.close();
        bw.close();
    }

    public static class Word{
        int length;
        String word;

        public Word(int length, String word) {
            this.length = length;
            this.word = word;
        }
    }
}
