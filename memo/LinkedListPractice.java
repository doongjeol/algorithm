package memo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListPractice {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // list에 추가
        list.add(1);
        list.add(2);
        list.add(3);

        int prev = 0;
        int next = prev+1;

        list.remove(next);

    }
}
