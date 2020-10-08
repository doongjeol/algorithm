package mathmatics;

import java.io.*;

public class Q_1212_OctToBinary {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        boolean isFirst = false;
        for (int i = 0; i < str.length(); i++) {
            if(i == 0)
                isFirst = true;
            else
                isFirst = false;
            solution(str.charAt(i)-'0',isFirst);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    public static void solution(long n, boolean isFirst){
        StringBuilder sbTemp = new StringBuilder();
        int count = 0;

        if(isFirst && n == 0){
            sb.append(0);
        }
        while(n>0){
            long share = n / 2;
            long rest = n % 2;

            sbTemp.append(rest);
            n = share;
            count ++;

        }
        if(!isFirst) {
            while (count < 3) {
                sbTemp.append(0);
                count++;
            }
        }
        sbTemp.reverse();
        sb.append(sbTemp.toString());

    }
}
