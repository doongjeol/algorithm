package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_1546_Average {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Double> list = new ArrayList<>();
		int maxScore = 0;
		for(int i=0 ; i<num ; i++) {
			int score = Integer.parseInt(st.nextToken());
			list.add((double)score);
			maxScore = Math.max(maxScore, score);
		}
		
		double sum = 0;
		for(int i=0 ; i<list.size() ; i++) {
			list.set(i,list.get(i)/maxScore*100);
			sum += list.get(i);
		}
		
		System.out.println(sum/num);
	}
}
