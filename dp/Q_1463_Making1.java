package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1463_Making1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = num;

        while(num != 1){
            
        }

    }

    public static int divideByThree (int x){
        int result = x/3;

        return result;
    }

    public static int divideByTwo (int x){
        int result = x/2;

        return result;
    }

    public static int minusOne (int x){
        int result = x-1;

        return result;
    }

    public static boolean isOne (int x){
        if(x == 1)
            return true;
        else
            return false;
    }
}
