package programmers;

import java.io.*;
import java.util.StringTokenizer;

public class Q_42862_GymClothes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 전체 학생의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = st.countTokens();
        int[] lost = new int[length]; // 체육복을 도난당한 학생들의 번호가 담긴 배열
        for (int i = 0; i < length; i++) {
            lost[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        length = st.countTokens();
        int[] reserve = new int[st.countTokens()]; // 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
        for (int i = 0; i < length; i++) {
            reserve[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution(n, lost, reserve)+"\n");

        br.close();
        bw.close();

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n+1]; // 체육복 현황 | -1 : 잃어버림 0 : 체육복 있음 1 : 체육복 여분 있음
        // 체육복 잃어버린 학생 차감
        for (int j = 0; j < lost.length; j++)
            clothes[lost[j]] -= 1;

        // 체육복 여유있는 학생 더함
        for (int j = 0; j < reserve.length; j++)
            clothes[reserve[j]] += 1;

        for(int i=1 ; i<clothes.length-1 ; i++) {
            System.out.print(i +" : ");

            // 오른쪽 배열이 여분이 있으면 체육복 넘겨주기 (왼쪽 방향으로 체육복 토스)
            if (clothes[i] <0 && clothes[i+1] > 0){
                clothes[i] ++;
                clothes[i+1] --;

            // 왼쪽 배열이 여분이 있으면 체육복 넘겨주기 (오른쪽 방향으로 체육복 토스)
            } else if(clothes[i] <0 && clothes[i-1] > 0) {
                clothes[i] ++;
                clothes[i-1] --;
            } else{
                System.out.println();
            }
        }

        int minusCount = 0; // 체육복이 없는 학생 카운트
        for(int i=1 ; i<clothes.length ; i++) {
            if(clothes[i] < 0)
                minusCount++;
        }



        answer = n - minusCount;

        return answer;
    }

    public static void print(int[] clothes){
        for(int i=1 ; i<clothes.length ; i++) {
            System.out.print(clothes[i]+" ");
        }
        System.out.println();
    }
}
