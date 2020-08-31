package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q_10825_KoreanEnglishMath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Student(name, korean, english, math));
        }


        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.korean==o2.korean && o1.english == o2.english && o1.math == o2.math)
                    return o1.name.compareTo(o2.name);
                else if(o1.korean==o2.korean && o1.english==o2.english)
                    return Integer.compare(o2.math, o1.math);
                else if(o1.korean==o2.korean)
                    return Integer.compare(o1.english, o2.english);
                else return Integer.compare(o2.korean, o1.korean);
            }
        });

        for (int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i).name);
        }

    }

    public static class Student {
        String name;
        int korean ;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
