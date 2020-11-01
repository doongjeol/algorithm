package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_11650_SortArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] array = new int[num][2];

        for(int i=0 ; i<num ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // return된 값이 양수이면 자리바꿈
                // 첫번째(o1) x와 두번째(o2) x가 같으면
                System.out.println(o1[0]);
                if(o1[0] == o2[0])
                    // y좌표 비교
                    return Integer.compare(o1[1], o2[1]);
                else
                    // x좌표 비교
                    return Integer.compare(o1[0], o2[0]);
            }
        });

        /*
        public static int compare(int x, int y)
            Parameter :
            x : the first int to compare
            y : the second int to compare

            Return :
            This method returns the value zero if (x==y),
            if (x < y) then it returns a value less than zero
            and if (x > y) then it returns a value greater than zero.
         */

    }

}
