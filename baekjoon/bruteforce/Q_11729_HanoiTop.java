package baekjoon.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q_11729_HanoiTop {
    public static List<Data> list;

    public static void solution(int n, int x, int y) throws IOException {
        if(n > 1){
            solution(n - 1, x, 6 - x - y);
        }

        list.add(new Data(x,y));
        if (n > 1) {
            solution(n - 1, 6 - x - y, y);
        }

    }

    public static class Data{
        int x;
        int y;

        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        solution(n, 1, 3);
        bw.write(list.size()+"\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).x +" "+list.get(i).y);
            if(i != list.size()-1){
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }
}
