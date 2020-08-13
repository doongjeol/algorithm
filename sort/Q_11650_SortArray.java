package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11650_SortArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] array = new int[num][2];

        for(int i=0 ; i<num ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<2 ; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
