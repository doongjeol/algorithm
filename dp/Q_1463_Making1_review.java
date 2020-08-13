package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1463_Making1_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[1000000+1];
        array[0] = 0;
        array[1] = 0;
        for(int i=2 ; i<num+1 ; i++){
            if(i%6 == 0){
                array[i] = Math.min(array[i/3],array[i/2]);
                array[i] = Math.min(array[i], array[i - 1]) + 1;
            } else if(i%2 == 0){
                array[i] = Math.min(array[i/2],array[i-1]) + 1;
            } else if(i%3 == 0){
                array[i] = Math.min(array[i/3],array[i-1]) + 1;
            } else{
                array[i] = array[i-1] + 1;
            }
        }
        System.out.println(array[num]);

    }
}
