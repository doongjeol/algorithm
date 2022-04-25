package baekjoon.bruteforce;
import java.io.*;

public class Q_10597_PermutationJoke {
    public static void permutation(int depth){

    }
    
    public static int getNumber(String str){
        int length = str.length();
        int lastNum = 0;
        if(length<10){
            lastNum = length;
        } else if (length >= 10) {
           lastNum = (length-9)/2 + 9;

        }
        return lastNum;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        bw.write(getNumber(str)+"");

        br.close();
        bw.close();
    }
}
