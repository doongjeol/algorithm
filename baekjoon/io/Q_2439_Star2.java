package baekjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2439_Star2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] star = new String[num];

        for(int i=0 ; i<num ; i++){
            star[i] = " ";
        }

        for(int i=num-1 ; i>=0 ; i--){
            star[i] ="*";
            for(int j=0 ; j<num ; j++){
                System.out.print(star[j]);
            }
            System.out.println();
        }
    }
}
