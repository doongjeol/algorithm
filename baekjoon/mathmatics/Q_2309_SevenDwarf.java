package baekjoon.mathmatics;
import java.io.*;
import java.util.Arrays;

public class Q_2309_SevenDwarf {
    public static int[] result;
    public static int[] dwarf = new int[9];
    public static void combination(int[] arr, int n, int r, int count, int depth){
        if(count == r){
            int sum = 0;
            for(int i=0 ; i<arr.length ; i++){
                sum += arr[i];
            }

            if(sum == 100 && result == null){
                result = arr.clone();

            }
            return;
        }

        for(int i=depth ; i<n ; i++){
            arr[count] = dwarf[i];
            combination(arr, n, r, count+1, i+1);

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < dwarf.length; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        combination(new int[7], dwarf.length, 7, 0, 0);
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            bw.write(result[i]+"\n");
        }

        br.close();
        bw.close();
    }
}
