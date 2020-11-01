package baekjoon.mathmatics;

import java.io.*;
import java.util.StringTokenizer;

public class Q_1978_PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int m = Integer.parseInt(st.nextToken());
            count = 0;

            for(int j=1; j<=m ; j++){
                if (m % j == 0) {
                    count ++;
                }
            }

            if(count == 2){
                result ++;
            }
        }

        bw.write(result+"\n");

        br.close();
        bw.close();
    }

}
