package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1931_MeetingRoom {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();
		int max = 0;
		for(int i=0 ; i<n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int term = end - start;
			max = Math.max(max, end);
			
			list.add(new Pair(term, start));
		}
		
		Collections.sort(list);
		
		int result = 0;
		int time = 0;
		for(int i=0 ; i<list.size()-1 ; i++) {
			if(time >= max)
				break;
			else {
				time += list.get(i).term;
				System.out.println(list.get(i).start);
				result ++;
			}
			if(list.get(i+1).start <= list.get(i).start)
				list.remove(i+1);
		}
		
		System.out.println(result);
	}
	
	public static class Pair implements Comparable<Pair>{
		int term;
		int start;
		
		public Pair(int term, int start) {
			this.term = term;
			this.start = start;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.term > o.term)
				return 1;
			else if(this.term < o.term)
				return -1;
			else
				if(this.start > o.start)
					return 1;
				else if(this.start < o.start)
					return -1;
				else
					return 0;
		}
		
		
	}
}
