package programmers;

import java.util.*;

public class Q_42586_DevelopFunction {
    public static int[] solution(int[] progresses, int[] speeds){
        int complete; // 기능 수
        int days = 1; // 날짜
        List<Integer> list = new ArrayList<>(); // 결과가 들어있는 리스트
        Queue<Integer> q = new LinkedList<>(); // 최초 작업량을 담은 큐
        Queue<Integer> sq = new LinkedList<>(); // 처리 속도를 담은 큐

        // 작업량을 큐에 넣기
        for (int i = 0; i < progresses.length; i++) {
            q.add(progresses[i]);
        }

        // 처리 속도를 큐에 넣기
        for (int i = 0; i < speeds.length; i++) {
            sq.add(speeds[i]);
        }

        while (!q.isEmpty()) {
            complete = 0;
            /* 총 작업량이 100이 넘을 때
            * 큐가 비어있지 않고, 총 작업량이 넘으면 완성한 기능을 +1 해주고, q에서 꺼내준다.
            * 다음 큐도 검사한 후 100이 넘지 않은 작업량이 나타나면 while문을 빠져나와 list에 add해준다 */
            if(q.peek() + sq.peek() * days >= 100){
                while(!q.isEmpty() && q.peek() + sq.peek() * days >= 100){
                    complete += 1;
                    q.poll();
                    sq.poll();
                }
                list.add(complete);
            }
            days += 1;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] answer = solution(progresses, speeds);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
