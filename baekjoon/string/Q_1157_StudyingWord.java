package baekjoon.string;
import java.io.*;
import java.util.Locale;

public class Q_1157_StudyingWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toLowerCase(Locale.ROOT);

        int[] num = new int[26];

        for (int i = 0; i < str.length() ; i++) {
            int index = str.charAt(i) - 'a';
            num[index] += 1;
        }

        int max = 0;
        String result = "?";
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
                result = (char) (i + 'a')+"";
            } else if(max != 0 && max == num[i]){
                result = "?";
            }
        }
        bw.write(result.toUpperCase(Locale.ROOT));

        br.close();
        bw.close();
    }
}
