package programmers.mathmatics;

public class Q_1835_TakeAGroupPhoto {
    public static int count;
    public static String[] inputData;
    public static int solution(int n, String[] data) {
        int answer = 0;
        count = 0;
        inputData = data;
        String[] friend = {"A", " C", " F", " J", " M", " N", " R", " T"};

        int length = friend.length;
        permutation(friend, new String[length], length, new boolean[length], 0);
        answer = count;
        System.out.println(count);
        return answer;
    }

    public static void permutation(String[] friend, String[] arr, int r, boolean[] selected, int depth){
        if(depth == r){
            if(isCorrect(arr)) {
                count += 1;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(selected[i]) continue;
            arr[depth] = friend[i];
            selected[i] = true;
            permutation(friend, arr, r, selected, depth + 1);
            selected[i] = false;
        }
    }

    public static boolean isCorrect(String[] arr){
        for (int i = 0; i < inputData.length; i++) {
            String first = String.valueOf(inputData[i].charAt(0));
            String second = String.valueOf(inputData[i].charAt(2));
            char mark = inputData[i].charAt(3);
            int space = inputData[i].charAt(4) - '0';

            int f1 = 0;
            int f2 = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j].equals(first)){
                    f1 = j;
                } else if(arr[j].equals(second)){
                    f2 = j;
                }
            }

            int distance = Math.abs(f1-f2);
            if(mark == '='){
                if(distance != space) return false;
            } else if(mark == '>'){
                if(distance <= space) return false;
            } else if (distance >= space){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        solution(n, data);
    }
}
