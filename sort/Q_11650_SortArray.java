package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_11650_SortArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] array = new int[num][2];
        List<array> list = new ArrayList<>();

        for(int i=0 ; i<num ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new array(x, y));
//            for(int j=0 ; j<2 ; j++) {
//                array[i][j] = Integer.parseInt(st.nextToken());
//            }
        }

        for(int i=0 ; i<num ; i++) {
            if(list.get(i).x > list.get(i+1).x)
                break;
        }




    }

    static class array{
        int x;
        int y;

        public array(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
