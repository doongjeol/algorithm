package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11726_2xnTileing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[1000];

        array[0] = 0;
        array[1] = 2;
        array[2] = 2;
        array[3] = 2;

        for(int i=4 ; i<=num ; i++){
            if(i%2 == 0) {
                array[i] = array[i - 2] * 2 * 2;
                System.out.println(i+" : "+array[i]);
            }
            else
                array[i] = array[i-1] * (i/2+1) * 2;
        }
        System.out.println(array[num]%10007);

    }
}
