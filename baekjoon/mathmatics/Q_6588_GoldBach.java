package baekjoon.mathmatics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q_6588_GoldBach {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
        }

        br.close();
        bw.close();
    }

    public static void solution(int n){
        int a = 0;
        int b = 0;

        int count = 0;
        List list = new ArrayList<Integer>();


        for (int i = 1; i < n; i++) {
            for(int j=0 ; j<=n ; j++) {
                if (n % j == 0)
                    count++;
            }
            if(count == 2){
                list.add(i);
            }


        }

    }
}
