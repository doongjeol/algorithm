package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.*;

/* 순서를 유지하면서 중복은 허용하지 않는 자료구조가 필요해 ! */
public class Q_13414_RegisterForCourses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String student = br.readLine();
            if(set.contains(student)){
                set.remove(student);
            }
            set.add(student);
        }

        Object[] key = set.toArray();
        if(key.length < k){
            k = key.length;
        }
        for (int i = 0; i < k; i++) {
            bw.write(key[i]+"\n");
        }

        br.close();
        bw.close();
    }
}
