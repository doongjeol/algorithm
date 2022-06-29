package programmers.implementation;
import java.io.*;

public class Q_77484_Lotto {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int question = 0;

        for (int j = 0; j < lottos.length; j++) {
            if(lottos[j] == 0) {
                question += 1;
            }
        }

        for (int i = 0; i < win_nums.length; i++) {
            for (int j = 0; j < lottos.length; j++) {
                if(win_nums[i] == lottos[j]) {
                    count += 1;
                }
            }
        }

        answer[0] = 7 - (count + question);
        answer[1] = 7 - count;
        if(answer[0] == 7){
            answer[0] = 6;
        }
        if(answer[1] == 7){
            answer[1] = 6;
        }

        System.out.print(answer[0] +" ");
        System.out.println(answer[1]);

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] lottos = {1,2,3,4,5,6};
        int[] win_nums = {7,8,9,10,11,12};

        solution(lottos, win_nums);

        br.close();
        bw.close();
    }
}
