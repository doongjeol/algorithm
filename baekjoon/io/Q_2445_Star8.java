package baekjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2445_Star8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i=0 ; i<num ; i++){
            for(int j=0 ; j<i+1 ; j++){
                System.out.print("*");
            }
            for(int j=i+1 ; j<num*2-i-1 ; j++){
                System.out.print(" ");
            }
            for(int j=num*2-i-1 ; j<num*2 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=0 ; i<num-1 ; i++){
            for(int j=0 ; j<num-i-1 ; j++){
                System.out.print("*");
            }
            for(int j=num-i-1 ; j<num+1+i ; j++){
                System.out.print(" ");
            }
            for(int j=num+1+i ; j<num*2 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
