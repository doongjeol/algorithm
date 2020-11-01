package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q_10814_SortAge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list.add(new Member(age, name));
        }

        list.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return Integer.compare(o1.age,o2.age);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).age+" "+list.get(i).name);
        }
    }

    static class Member{
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    /*
        public static int compare(int x, int y)
            Parameter :
            x : the first int to compare
            y : the second int to compare

            Return :
            This method returns the value zero if (x==y) : 자리 안바꿈
            if (x < y) then it returns a value less than zero : sort하면 작으니까 자리바꿈
            and if (x > y) then it returns a value greater than zero. : sort하면 작지않으니까 자리 안바꿈
         */
}
