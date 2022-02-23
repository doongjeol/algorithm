package baekjoon.bruteforce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_1759_MakePassword {
    public static char[] character;
    public static void combination(char[] arr, int n, int r, int depth, int idx, int countVowel, int countCons){
        if(depth == r){
            if (countVowel >= 1 && countCons >= 2) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
            }
            return;
        }

        for(int i = idx ; i<n ; i++){
            arr[depth] = character[i];
            if(!isVowel(arr[depth])) {
                combination(arr, n, r, depth + 1, i + 1, countVowel, countCons+1);
            }
            if(isVowel(arr[depth])) {
                combination(arr, n, r, depth + 1, i + 1, countVowel+1, countCons);
            }
        }
    }

    public static boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        character = new char[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c ; i++) {
            character[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(character);
        combination(new char[r], c, r, 0, 0, 0, 0);

        br.close();
    }

}
