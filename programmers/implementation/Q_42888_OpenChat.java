package programmers.implementation;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Q_42888_OpenChat {
    public static String[] solution(String[] record) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String type = st.nextToken();
            String uuid = st.nextToken();
            String nick = "";
            switch (type){
                case "Enter":
                    nick = st.nextToken();
                    hashMap.put(uuid, nick);
                    break;
                case "Change":
                    nick = st.nextToken();
                    hashMap.put(uuid, nick);
                    hashMap.replace(uuid, nick);
                    break;
            }
        }

        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            
            String type = st.nextToken();
            String uuid = st.nextToken();
            switch (type){
                case "Enter":
                    list.add(hashMap.get(uuid)+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add(hashMap.get(uuid)+"님이 나갔습니다.");
                    break;
            }
        }

        answer = list.toArray(new String[list.size()]);

        return answer;
    }
    public static void main(String[] args) throws IOException {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] answer = solution(solution(record));
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
        }

    }
}
