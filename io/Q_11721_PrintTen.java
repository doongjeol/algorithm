package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11721_PrintTen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int div = str.length()/10;
        int left = str.length()%10;
        int max = 10;
        for(int i=0 ; i<div+1 ; i++){
            if(i == div)
                max = left;
            for(int j=i*10 ; j<max+i*10 ; j++) {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}
