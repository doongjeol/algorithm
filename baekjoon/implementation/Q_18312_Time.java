package baekjoon.implementation;
import java.io.*;
import java.util.StringTokenizer;

public class Q_18312_Time {
    public static int solution(int n, String k){
        int max = 59 + 60*59 + 60*60*n;
        int sec = -1;
        int min = 0;
        int hour = 0;

        int result = 0;
        String strSec = "";
        String strMin = "";
        String strHour = "";
        String strTime = "";
        for(int temp=0 ; temp <= max ; temp++){
            sec = sec + 1;

            if(sec >= 60){
                min += 1;
                sec = 0;
            }
            if(min >= 60){
                hour += 1;
                min = 0;
            }

            strSec = String.valueOf(sec);
            strMin = String.valueOf(min);
            strHour = String.valueOf(hour);

            if(strSec.length() == 1)
                strSec = "0" + strSec;
            if(strMin.length() == 1)
                strMin = "0" + strMin;
            if(strHour.length() == 1)
                strHour = "0" + strHour;

            strTime = strHour + strMin + strSec;

//            System.out.println(strHour+"시 " + strMin+"분 "+ strSec+"초");

            // String으로 풀기
            for(int j=0 ; j<strTime.length() ; j++){
                if(strTime.charAt(j) == k.charAt(0)){
                    result++;
                    break;
                }
            }

        }

        return result;

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String k = st.nextToken();

        System.out.println(solution(n,k));

        br.close();
        bw.close();
    }
}

/** 실수한 부분
 *  1. sec = 0 으로 설정하여 1초부터 시작하게한 것
 *  2. 숫자가 한 자리수 일 때, 앞에 0문자를 붙여주지 않았던 것
 **/