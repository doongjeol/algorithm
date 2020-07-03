package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10992_Star17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i=0 ; i<num-1 ; i++){
            for(int j=0 ; j<num-i-1 ; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j=0 ; j<2*i-1 ; j++){
                System.out.print(" ");
            }
            if(i==0)
                System.out.println();
            else
                System.out.println("*");
        }
        for(int i=0 ; i<num*2-1 ; i++){
            System.out.print("*");
        }
    }
}
