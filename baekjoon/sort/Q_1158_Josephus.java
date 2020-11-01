package baekjoon.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1158_Josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int index = k-1;

        for (int i = 1; i <=n; i++) {
            list.add(i);
        }

        bw.write("<");

        while(!list.isEmpty()) {
            if(list.size() != 1)
                bw.write(list.get(index) + ", ");
            else
                bw.write(list.get(index)+"");
            list.remove(index);
            index = index + k;
            if (index < list.size()) {
                index -= 1;
            } else {
                while(index > list.size()) {
                    index = index - list.size();
                    if(list.size() == 0)
                        break;
                }
                index -= 1;
            }
        }
        bw.write(">");
        br.close();
        bw.close();
    }
}
