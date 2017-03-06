package POJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _2003 {
	static People_2003 root;
	static HashMap<String, People_2003> m;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		m = new HashMap<String, People_2003>();
		root = new People_2003(input.nextLine());
		m.put(root.name, root);
		
		while(input.hasNext()){
			String nextStr = input.nextLine();
			
			//hire
			if(nextStr.split(" ").length ==3){
				hire(nextStr.split(" ")[0], nextStr.split(" ")[2]);
			//fire
			} else if(nextStr.split(" ").length ==2 ){
//				System.out.println("Fire: " +nextStr.split(" ")[1] );
				fire(nextStr.split(" ")[1]);
			//print	
			} else{
				print(root, 0);
				for(int i = 0 ; i< 60 ; i++){
					System.out.print("-");
				}
				
				System.out.println();
			}
		}
	}
	
	//a hires b
	public static void hire(String aStr , String bStr){
		People_2003 p = m.get(aStr);
		People_2003 bp = new People_2003(bStr);
		p.children.add(bp);
		bp.f =p;
		m.put(bStr, bp);
	}
	
	public static void fire(String str){
		People_2003 p = m.get(str);
		while(p.children.size() > 0){
//			System.out.println(p.name +" " + p.children.get(0).name);
			m.remove(p.name);
			p.name = p.children.get(0).name;
//			System.out.println("F : " + p.f.name);
			m.put(p.name, p);
			p= p.children.get(0);
			
		}
//		System.out.println("58: " + p.f.children.get(0).name );
		p.f.children.remove(p);
	}
	
	public static void print(People_2003 p, int dep){
		People_2003 cur = p;
		String print="";
		
		for(int i =0 ; i < dep ; i++){
			print += "+";
		}
		System.out.println(print + cur.name);
		
		for(int i =0 ; i <cur.children.size() ; i++){
//			System.out.println(cur.children.get(i).name);
			print(cur.children.get(i), dep+1);
		}
	}
}

class People_2003 {

	People_2003(String name) {
		this.name = name;
//		childIndex = 0;
	}

	String name;
	ArrayList<People_2003> children = new ArrayList<People_2003>();
	People_2003 f;
//	int childIndex;
}
