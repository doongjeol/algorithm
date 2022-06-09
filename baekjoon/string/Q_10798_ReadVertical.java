package baekjoon.string;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q_10798_ReadVertical {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        List<String>[] list = new ArrayList[5];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<String>();
        }

        int max = 0;
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            max = Math.max(str.length(), max);
            for (int j = 0; j < str.length(); j++) {
                list[i].add(str.charAt(j)+"");
            }
        }

        for (int col = 0; col < max; col++) {
            for (int row = 0; row < list.length; row++) {
                if(list[row].size()-1 < col) continue;
                bw.write(list[row].get(col));
            }
        }

        br.close();
        bw.close();
    }
}
