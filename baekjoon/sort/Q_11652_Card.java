package baekjoon.sort;

import java.io.*;
import java.util.Arrays;

public class Q_11652_Card {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        /*
        int 범위   :	-2147483648 ~ 2147483647
        long 범위  :	-9223372036854775808 ~ 9223372036854775807
        2^62      : 4611686018427387904
        이므로 따라서 형을 long으로 지정해야함
         */

        Arrays.sort(arr);

        int count = 1;
        int max = 1;
        long result = arr[0];
        for (int i = 0; i < num-1; i++) {

            if(arr[i] == arr[i+1]) // 값이 같다면 count수를 늘림
                count += 1;
            else // 같지 않다면 count 수 초기화
                count = 1;

            if(max < count) {
                max = count; // max에 저장된 값보다 현재 count가 크다면 max에 저장
                result = arr[i]; // 결과는 해당 배열의 값
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result+"\n");
        br.close();
        bw.close();
    }
}
