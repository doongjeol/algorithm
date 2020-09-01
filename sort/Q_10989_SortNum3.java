package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q_10989_SortNum3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return 1;
                else if(o1==o2)
                    return 0;
                else
                    return -1;
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < num; i++) {
            bw.write(list.get(i)+"\n");
        }

        br.close();
        bw.close();

    }
}
