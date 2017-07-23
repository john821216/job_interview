package Leetcode;

public class _517 {
	public static void main(String[] args) {
		_517 a = new _517();
		a.execute();
	}

	public void execute() {
		System.out.println(findMinMoves(new int[] { 1,0,5 }));
	}

	public int findMinMoves(int[] machines) {
		int avg;
		int sum = 0;
		for (int i : machines) {
			sum += i;
		}
		if (sum % machines.length != 0) {
			return -1;
		}
		avg = sum / machines.length;
		int[] move = new int[machines.length];
		int min = 0;

		for (int i = 0; i < machines.length - 1; i++) {
			if (machines[i] > avg) {
				move[i] += machines[i] -avg;
				machines[i+1] += machines[i] -avg;
				machines[i] = avg;
				min = Math.max(move[i], min);
			} else if (machines[i] < avg) {
				move[i+1] += avg - machines[i];
				min = Math.max(move[i+1], min);
				machines[i+1] -= avg - machines[i];
				machines[i] =avg;
			}
			for(int j : machines){
				System.out.print(j+ " ");
			}
			System.out.println();
			for(int j : move){
				System.out.print(j+ " ");
			}
			System.out.println();
			System.out.println();
			
		}
		
		return min;
	}
}
