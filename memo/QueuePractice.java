package memo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueuePractice {
    public static void main(String[] args) {
        //FIFO
        List<Integer> list = new ArrayList<>();

        // 큐에 추가
        list.add(1);
        list.add(2);
        list.add(3);

        // 큐에 가장 먼저 들어간 것 확인만하기
        list.get(0);

        // 큐에 가장 먼저 들어간 것 꺼내기
        list.remove(0);

    }
}
