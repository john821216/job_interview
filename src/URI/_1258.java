package URI;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _1258 {
	static int numberOfPeople;
	static tShirt[] t;
	static boolean firstEnter = false;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			numberOfPeople = input.nextInt();

			if(numberOfPeople==0) break;
			if(!firstEnter){
				firstEnter = true;
			} else{
				System.out.println();
			}
			t = new tShirt[numberOfPeople];
			PriorityQueue<tShirt> p = new PriorityQueue<tShirt>(
					new tShirtComparator());
			input.nextLine();
			for (int i = 0; i < numberOfPeople; i++) {
				String name = input.nextLine();
				String colorAndSize = input.nextLine();
				t[i] = new tShirt(name, colorAndSize.split(" ")[0],
						colorAndSize.split(" ")[1]);
				p.add(t[i]);
			}

			while (p.size() != 0) {
				tShirt t = p.poll();
				System.out.println(t.color + " " + t.size + " " + t.name);
			}
		}
	}
}

class tShirt {
	String name;
	String color;
	String size;
	int sizeNumber;

	public tShirt(String name, String color, String size) {
		this.name = name;
		this.color = color;
		this.size = size;
		if (size.equals("P")) {
			sizeNumber = 0;
		} else if (size.equals("M")) {
			sizeNumber = 1;
		} else {
			sizeNumber = 2;
		}

	}
}

class tShirtComparator implements Comparator<tShirt> {

	@Override
	public int compare(tShirt o1, tShirt o2) {
		if (o1.color.equals(o2.color)) {
			if (o1.size.equals(o2.size)) {
				return o1.name.compareTo(o2.name);
			} else {
				return o1.sizeNumber - o2.sizeNumber;
			}
		} else {
			return o1.color.compareTo(o2.color);
		}
	}

}
