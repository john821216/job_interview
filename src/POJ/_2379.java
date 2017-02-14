package POJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _2379 {
	static int C;
	static int N;
	static Team[] t;
	static Judgement[] j;
	static boolean[] question = new boolean[21];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		C = input.nextInt();
		N = input.nextInt();
		t = new Team[C];
		j = new Judgement[N];
		for (int i = 0; i < N; i++) {
			j[i] = new Judgement(input.nextInt(), input.nextInt(),
					input.nextInt(), input.nextInt());
		}
		
		for(int i = 0; i < C ; i++){
			t[i] = new Team();
			t[i].index =i+1;
		}
		Arrays.sort(j , new JudgementComparator());
		
		for(int i = 0 ; i < N ; i++){
			int team = j[i].teamNumber-1;
			int qNumber = j[i].questionNumber;
			int triedTime =j[i].submitTime;
			int result = j[i].result;
			if(result == 1){
				if(t[team].isSolved[qNumber]){
					//do nothing
					continue;
				} else{
					t[team].ac++;
					t[team].isSolved[qNumber] = true;
					t[team].timeCost += t[team].triedTime[qNumber] * 1200 + triedTime;
				}		
				
			}else{
				t[team].triedTime[qNumber]++;
			}
		}
		Arrays.sort(t, new teamComparator());
		
		for(int i = 0 ; i < C ; i++){
			if(i==0){
				System.out.println(t[i].index);
			} else{
				System.out.println(" " + t[i].index);
			}
		}

	}
}

class teamComparator implements Comparator<Team>{

	@Override
	public int compare(Team o1, Team o2) {
		if(o1.ac == o2.ac){
			if(o1.timeCost == o2.timeCost){
				return o1.index - o2.index;
			} else{
				return o1.timeCost - o2.timeCost; 
			}
		} else{
			return o2.ac-o1.ac;
		}
		
	}
	
}

class JudgementComparator implements Comparator<Judgement> {

	@Override
	public int compare(Judgement o1, Judgement o2) {
		return o1.submitTime - o2.submitTime;
	}

}

class Judgement {

	public Judgement(int teamNumber, int questionNumber, int submitTime,
			int result) {
		this.teamNumber = teamNumber;
		this.questionNumber = questionNumber;
		this.submitTime = submitTime;
		this.result = result;
	}

	int teamNumber;
	int questionNumber;
	int submitTime;
	int result;
}

class Team {
	int index;
	int timeCost = 0;
	int ac=0;
	boolean[] isSolved = new boolean[21];
	int[] triedTime = new int[21];
}
