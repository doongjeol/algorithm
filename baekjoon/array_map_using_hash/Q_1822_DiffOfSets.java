package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q_1822_DiffOfSets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());

        HashSet<Integer> result = new HashSet();

        st = new StringTokenizer(br.readLine());
        int[] a = new int[na];
        HashSet<Integer> b = new HashSet<>();
        for (int i = 0; i < na; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nb; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < a.length; i++) {
            if(!b.contains(a[i])){
                result.add(a[i]);
            }
        }
        
        bw.write(result.size()+"\n");

        Object[] arr = result.toArray();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length ; i++) {
            bw.write(arr[i]+" ");
        }

        br.close();
        bw.close();
    }
}
