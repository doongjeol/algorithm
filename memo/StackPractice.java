package memo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) {
        // LIFO
        List<Integer> list = new ArrayList<>();

        // stack에 추가
        list.add(1);
        list.add(2);
        list.add(3);

        // stack에 가장 나중에 들어간 것 확인만하기
        list.add(list.size() - 1);

        // stack에 가장 나중에 들어간 것 꺼내기
        list.remove(list.size() - 1);
    }
}
