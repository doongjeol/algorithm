package baekjoon.bruteforce;
import java.io.*;

public class Q_10597_PermutationJoke {
    public static void permutation(int depth){

    }
    
    public static int getNumber(String str){
        int length = str.length();
        System.out.println(length);
        int share = length / 10;
        int lastNum = 0;
        int temp = 1;
        int sum = 0;
        for (int i = 1; i <= 16; i++) {
            if(i % 10 == 0){
                temp += 1;
            }
            sum += 1 * temp;
        }
        System.out.println(sum);


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
