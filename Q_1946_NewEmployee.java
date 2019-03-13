package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1946_NewEmployee {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<test ; i++) {
			int num = Integer.parseInt(br.readLine());
			List<Pair> list = new ArrayList<>();
			int count = 0;
			for(int j=0 ; j<num ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int score1 = Integer.parseInt(st.nextToken());
				int score2 = Integer.parseInt(st.nextToken());
				list.add(new Pair(score1, score2));
			}
			// 서류심사 성적 오름차순 정렬
			Collections.sort(list);
			
			for(int j=0 ; j<list.size()-1 ; j++) {
				// j+1번째 면접시험 성적이 j번째보다 안 좋을 때 탈락자++
				if(list.get(j).score2<list.get(j+1).score2) {
					count++;
					list.remove(j+1);
					j--;
				}
			}
			System.out.println(num-count);
//		for(int j=0; j<num ; j++)
//			System.out.print(list.get(j).score1+" ");
//		System.out.println();
		}
		
	}
	
	public static class Pair implements Comparable<Pair>{
		int score1;
		int score2;
		
		public Pair(int score1, int score2) {
			this.score1 = score1;
			this.score2 = score2;
		}
		
		@Override
		public int compareTo(Pair arg0) {
			if(this.score1 > arg0.score1) 
				return 1;
			else if(this.score1 < arg0.score1)
				return -1;
			else
				if(this.score2 > arg0.score2) 
					return 1;
				else if(this.score2 < arg0.score2) 
					return -1;
				else
					return 0;
		}


	}
	
}
