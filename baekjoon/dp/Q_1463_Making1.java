package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1463_Making1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(solution(num));
    }

    public static int solution(int num){
        int[] resultArry = new int[num+1];
        resultArry[0] = 0;
        resultArry[1] = 0;
        int result = 0;
        for(int i=2 ; i<=num ; i++){
            resultArry[i] = resultArry[i-1] + 1;
            if(i%2 == 0)
                resultArry[i] = Math.min(resultArry[i],resultArry[i/2] + 1);
            if(i%3 == 0)
                resultArry[i] = Math.min(resultArry[i],resultArry[i/3] + 1);
        }

        return resultArry[num];
    }


}
