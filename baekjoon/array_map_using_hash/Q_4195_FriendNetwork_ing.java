package baekjoon.array_map_using_hash;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q_4195_FriendNetwork_ing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            HashMap<String,Integer> hashMap = new HashMap();
            String f1 = "";
            String f2 = "";
            for (int j = 0; j < f; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                f1 = st.nextToken();
                f2 = st.nextToken();
                System.out.println(f1 +" " +f2);
                if(hashMap.containsKey(f1)){
                    int count = hashMap.get(f1) + 1;
                    hashMap.replace(f1, count);
                    System.out.println(f1);
                } else if (!hashMap.containsKey(f1)){
                    hashMap.put(f1,1);
                    System.out.println(f1);
                }

                if (hashMap.containsKey(f2)){
                    int count = hashMap.get(f2) + 1;
                    hashMap.replace(f2, count);
                    System.out.println(f2);
                } else if (!hashMap.containsKey(f2)){
                    hashMap.put(f2,1);
                    System.out.println(f2);
                }
            }

            int result = 0;
            for (int j = 0; j < f; j++) {
                result = hashMap.get(f1) + hashMap.get(f2);
                bw.write(result+"\n");
            }

        }
        br.close();
        bw.close();
    }
}
