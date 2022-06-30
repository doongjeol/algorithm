package programmers.implementation;
import java.io.*;
import java.util.HashMap;

public class Q_60057_CompressString {
    public static int solution(String s) {
        int answer = 1001;

        for (int standard = 1; standard < s.length(); standard++) {
            int count = 0;
            if(s.length() % standard != 0) continue;
            for (int i = 0; i < s.length(); i+= standard) {
                HashMap<String, Integer> hashMap = new HashMap<>();
                for (int j = i; j < i+standard; j++) {
                    String tmp = String.valueOf(s.charAt(j));
                    if(hashMap.containsKey(tmp)) {
                        int cnt = hashMap.get(tmp) + 1;
                        hashMap.replace(tmp, cnt);
                    } else {
                        hashMap.put(tmp, 1);
                    }
                }
                Object[] key = hashMap.keySet().toArray();
                for(Object o : key){
                    if(hashMap.get(o) > 1) {
                        count += 1;
                    }
                }
                count += key.length;
            }
            answer = Math.min(answer, count);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        String s = "ababcdcdababcdcd";
        System.out.println(solution(s));
    }
}
