package POJ;

import java.util.Scanner;

public class _3750 {
	static int numberOfPp;
	static People[] p;
	static int W, S;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		numberOfPp = input.nextInt();
		p = new People[numberOfPp];
		for(int i = 0 ; i < numberOfPp ; i++){
			p[i] = new People();
			p[i].name = input.next();
			p[i].index = i;
		}
		String in = input.next();
		
		W = Integer.parseInt(in.split(",")[0]);
		S = Integer.parseInt(in.split(",")[1]);
		
		W = (W %numberOfPp -1 + numberOfPp) %numberOfPp;
		int  maxTime = numberOfPp;
		for(int i = 0; i < maxTime ; i++){
			W = (W + S-1) % numberOfPp;
			System.out.println(p[W].name);
			//remove
			for(int j = W ; j < numberOfPp-1; j++){
				p[j] = p[j+1];
			}
			numberOfPp--;
		}
	}
}

class People{
	int index;
	String name;
}