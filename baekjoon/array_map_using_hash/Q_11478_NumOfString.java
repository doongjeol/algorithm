package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.HashSet;

public class Q_11478_NumOfString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> set = new HashSet<>();

        String str = br.readLine();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = i; j < n; j++) {
                temp += str.substring(j, j + 1);
                set.add(temp);
            }
        }

        bw.write(set.size()+"");

        br.close();
        bw.close();
    }
}
