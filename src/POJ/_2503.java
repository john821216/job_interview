package POJ;

import java.util.HashMap;
import java.util.Scanner;

public class _2503 {
	static HashMap<String, String > h;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		h = new HashMap<String, String>();
		while(true){
			String line = input.nextLine();
			if(line.equals("")){
				break;
			} else{
				h.put(line.split(" ")[1], line.split(" ")[0]);
//				System.out.println(line.split(" ")[0]);
			}
		}
		
		while(input.hasNext()){
			String an = h.get(input.next());
			if(an==null) System.out.println("eh");
			else System.out.println(an);
		}
	}
}
