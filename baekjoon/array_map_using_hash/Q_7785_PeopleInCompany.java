package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.*;

public class Q_7785_PeopleInCompany {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String type = st.nextToken();
            if(type.equals("enter")) {
                hashMap.put(name, true);
            } else if(type.equals("leave")){
                hashMap.replace(name,false);
            }
        }

        Object[] arrKey = hashMap.keySet().toArray();
        Arrays.sort(arrKey, Collections.reverseOrder());

        for(Object s : arrKey) {
            if(hashMap.get(s))
                bw.write(s+"\n");
        }

        br.close();
        bw.close();
    }
}
