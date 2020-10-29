package mathmatics;

import java.io.*;

public class Q_10872_Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(factorial(n)+"\n");


        br.close();
        bw.close();
    }

    public static int factorial(int n) {
        if(n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
