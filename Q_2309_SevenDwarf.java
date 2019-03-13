package backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q_2309_SevenDwarf {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dwarf = new int[9];
		int sum = 0;
		int difference = 0;
		int dwarf1 = 0, dwarf2 = 0;
		int[][] sumArray = new int[9][9];
//		int[] result = new int[7];
		List resultArray = new ArrayList();
		
		//입력
		for(int i=0; i<dwarf.length ;i++) {
			dwarf[i] = sc.nextInt();
		}
		
		//배열요소의 전체 합
		for(int i=0; i<dwarf.length ;i++) {
			sum += dwarf[i];
		}
		
		difference = sum - 100;
		
		//합의 배열
		for(int i=0; i<dwarf.length;i++) {
			for(int j=0; j<dwarf.length; j++) {
				sumArray[i][j] = dwarf[i]+dwarf[j];
			}
		}
		
		for(int i=0; i<dwarf.length;i++) {
			for(int j=0; j<dwarf.length; j++) {
				if(sumArray[i][j] == difference && i != j) {
					dwarf1 = i;
					dwarf2 = j;
				}
			}
		}
		
		for(int i=0; i < dwarf.length ; i++) {
			resultArray.add(dwarf[i]);
		}
		
		resultArray.remove(dwarf1);
		resultArray.remove(dwarf2);
		Collections.sort(resultArray);


		for(int i=0; i < resultArray.size() ; i++) {
			System.out.println(resultArray.get(i));
		}
		
	}
	
	// 배열로 풀었을 경우
//		int k=0;
//		for(int i=0; i < result.length ; i++) {
//			if(k == dwarf1 || k == dwarf2) {
//				k++;
//				i--;
//			} else {
//				result[i] = dwarf[k];
//			}
//			k++;
//		}
	
	
	
//		Arrays.sort(result);
//		
//		for(int i=0; i<result.length; i++) {
//			System.out.println(result[i]);
//		}
}