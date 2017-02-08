package POJ;

import java.util.Scanner;

public class _2259 {
	static int numberOfTeam;
	static int[] belong;
	static int[] pos;
	static int start;
	static int end;
	static int cur;
	static int count=1;
	static Element[] e;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			start = -1;
			end = -1;
			cur = 0;
			numberOfTeam = input.nextInt();
			if (numberOfTeam == 0)
				break;
			e = new Element[200050];
			for(int i = 0 ; i < e.length ; i++){
				e[i] = new Element();
			}
			belong = new int[1000000];
			pos = new int[numberOfTeam];
			for (int i = 0; i < numberOfTeam; i++) {
				int numberOfMember = input.nextInt();
				pos[i] = -1;
				for (int j = 0; j < numberOfMember; j++) {
					belong[input.nextInt()] = i;
				}
			}
			System.out.println("Scenario #" + count++);

			while (true) {
				String instr = input.next();
				if (instr.equals("STOP")){
					System.out.println();
					break;
				}
				if (instr.equals("ENQUEUE")) {
					int num = input.nextInt();
					if (pos[belong[num]] == -1) {
						e[cur].val = num;
						e[cur].next = -1;
						pos[belong[num]] = cur;
//						System.out.println("51 "+ cur + " " +e[cur].val +" " +e[cur].next +" " + pos[belong[num]]);
						if (start == -1) {
							start = cur;
						} 
						if( end == -1) end=cur;
						else if( end >= 0){
							e[end].next = cur;
							end = cur;
						}
					} else{
						e[cur].val = num;
						e[cur].next = e[pos[belong[num]]].next;
						e[pos[belong[num]]].next = cur;
//						System.out.println("64 " + cur+" "+ e[cur].val +" " +e[cur].next +" " + pos[belong[num]]);

						if(pos[belong[num]]== end){
							end = cur;
						}
						pos[belong[num]] = cur;
//						System.out.println("69 "+ end );
					}
					cur++;
				} else if (instr.equals("DEQUEUE")) {
					System.out.println(e[start].val);
//					System.out.println("74 " +pos[belong[e[start].val]] +" " + start);
					if(start == pos[belong[e[start].val]]){
						 pos[belong[e[start].val]] = -1;
					}
//					System.out.println("78 " + e[start].next);
//					System.out.println();
					start = e[start].next;
//					System.out.println("79 "+ start +" " +e[start].next); 
				}
			}
		}
	}
}

class Element {
	int val=-1;
	int next=-1;
}
