package baekjoon.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorPractice {
    public static class Number {
        int o;

        public Number(int o) {
            this.o = o;
        }
    }
    public static class OCompare implements Comparator<Number> {

        @Override
        public int compare(Number o1, Number o2) {
            return Integer.compare(o2.o, o1.o);
        }
    }
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        Number n1 = new Number(5);
        Number n2 = new Number(3);
        list.add(n1);
        list.add(n2);

        Collections.sort(list, new OCompare());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).o);
        }
    }
}
