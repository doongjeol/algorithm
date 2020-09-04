package sort;

import java.io.*;
import java.util.StringTokenizer;

public class Q_11004_KthNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quicksort(arr,0,n-1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(arr[k-1] +"\n");

        br.close();
        bw.close();
    }

    public static void quicksort(int[] arr, int left, int right){
        // left : 0
        // right : 맨 끝
        int pl = left; // 왼쪽 (pivot 보다 작음) 방향->
        int pr = right; // 오른쪽 (pivot 보다 큼) <-방향
        int pivot = arr[(pl+pr) / 2]; // 나눠진 그룹의 중간

        while(pl < pr) {
            while (arr[pl] < pivot) pl++;
            while (arr[pr] > pivot) pr--;
            // while 문에서 빠져나온 값은 있어야 할 자리에 있는 값이 아니므로 자리를 바꿔야함
            // 확인했는데도 i, j가 만나지 않았다면 swap
            if (pl <= pr) {
                swap(arr, pl, pr);
                pl++;
                pr--;
            }
        }

        // pr이 아직 맨 처음에 도달하지 않았다면 그룹을 나눔 left ~ pr
        if(left < pr)  quicksort(arr,left,pr);
        // pl이 아직 맨 뒤에 도달하지 않았다면 그룹을 나눔 pl ~ right
        if(right > pl) quicksort(arr,pl,right);

    }

    public static void swap(int[] arr, int pl, int pr) {
        int temp = arr[pl];
        arr[pl] = arr[pr];
        arr[pr] = temp;
    }
}
