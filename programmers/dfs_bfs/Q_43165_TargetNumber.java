package programmers.dfs_bfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_43165_TargetNumber {


    public static int[][] graph;
    public static int solution(int[] numbers, int target){
        int answer = 0;


        return answer;

    }

    public static int dfs(int[] numbers, int target, int prevSum, int index){
        int answer = 0;
        int count = 0;
        int temp = answer;

        if(index == numbers.length -1) {
            if(answer == target)
                return count + 1;
            return  count;
        }

        int curSumPlus = prevSum + numbers[index];
        int curSumMinus = prevSum - numbers[index];

        count += dfs(numbers, target, curSumMinus, index+1);
        count += dfs(numbers, target, curSumPlus, index+1);

        answer = temp;

        return count;


    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = st.countTokens();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        System.out.println(solution(numbers,target));

        br.close();
        bw.close();
    }
}
