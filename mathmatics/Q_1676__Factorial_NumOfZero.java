package mathmatics;

import java.io.*;

public class Q_1676__Factorial_NumOfZero {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        factorial(n);
        bw.write(count+"\n");

        br.close();
        bw.close();
    }

    public static void factorial(int n) {
//        if(n == 0)
//            return 1;
//        else {
//            int result = n * factorial(n - 1);
//            if(result % 10 == 0) {
//                count++;
//                return result;
//            } else return 1;
//        }
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
            if (result % 10 == 0) {
                count ++;
            } else break;
        }
    }
}
