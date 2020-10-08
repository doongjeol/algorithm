package mathmatics;

import java.io.*;

public class Q_1373_BinaryOct {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        long num = 0;

        for(int i=str.length() ; i>=0 ; i--){
            num = 0;
            for (int j = 0; j < 3; j++) {
                i = i - 1;
                if (i < 0)
                    break;
                num += (long) Math.pow(2, j) * (str.charAt(i) - '0');
            }
            if(i!=0)
                i=i+1;
                sb.append(num);
        }


        bw.write(sb.reverse()+"");

        br.close();
        bw.close();
    }
}