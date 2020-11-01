package baekjoon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1924_2007 {
    static int[] maxDateArry = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int date = 0;
        int maxDate = day;
        String result = "";

        for(int i=1 ; i<month ; i++){
            maxDate += maxDateArry[i];
        }
        date = maxDate%7;
        result = result(date);
        System.out.print(result);
    }

    public static String result(int date){
        String result = "";

        switch (date){
            case 0 :
                result = "SUN";
                break;
            case 1 :
                result = "MON";
                break;
            case 2 :
                result = "TUE";
                break;
            case 3 :
                result = "WED";
                break;
            case 4 :
                result = "THU";
                break;
            case 5 :
                result = "FRI";
                break;
            case 6 :
                result = "SAT";
                break;
            default :
                result = "";
                break;
        }

        return result;
    }
}
