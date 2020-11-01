package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q_10866_Deque {
    public static Deque<Integer> d = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = "";
            int x = 0;
            if(st.countTokens() == 2){
                command = st.nextToken();
                x = Integer.parseInt(st.nextToken());
            }else {
                command = st.nextToken();
            }
            solution(command,x);
        }
    }

    public static void solution(String command, int x){
        switch (command) {
            case "push_front":
                d.addFirst(x);
                break;
            case "push_back":
                d.add(x);
                break;
            case "pop_front":
                if(d.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(d.pop());
                break;
            case "pop_back":
                if(d.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(d.removeLast());
                break;
            case "size":
                System.out.println(d.size());
                break;
            case "empty":
                if(d.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
                break;
            case "front":
                if(d.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(d.peekFirst());
                break;
            case "back":
                if(d.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(d.peekLast());
                break;

        }
    }
}
