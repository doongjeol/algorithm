package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_10951_AplusB4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
//        for(int i=0 ; i<5 ; i++) {
        while(true) {
            String str = br.readLine();
            if(str==null) break;
            else {
                StringTokenizer st = new StringTokenizer(str);
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                System.out.println(n + m);
            }

        }
//        }

    }
}

