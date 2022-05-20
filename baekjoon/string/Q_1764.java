package baekjoon.string;
import java.io.*;
import java.util.*;

public class Q_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i <m; i++) {
            String tmp = br.readLine();
            if(hashSet.contains(tmp)) {
                result.add(tmp);
            }
        }

        Collections.sort(result);
        bw.write(result.size()+"\n");
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i)+"\n");
        }

        br.close();
        bw.close();
    }
}

/*
* HashSet의 contains()는 O(1), ArrayList의 contains()는 O(n)이다. HashSet은 map을 기반으로 구현되고, ArrayList는 indexOf()를 사용해서 contain여부를 결정한다고 한다.처음에 ArrayList를 사용해서 시간초과가 났는데, 효율성이 필요한 문제라면 HashSet을 사용해야겠다.
* https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1764-%EB%93%A3%EB%B3%B4%EC%9E%A1-JAVA%EC%9E%90%EB%B0%94 참조
* */
