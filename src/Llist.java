public class Llist {
	public static void main(String[] args) {
		Llist l = new Llist();
		l.execute();
	}

	public void execute() {
		l s = new l(1);
		s.next = new l(2);
		s.next.next = new l(3);
		s.next.next.next = new l(4);

		l ss = new l(0);
		l start = ss;
		l end = ss;
		start.next = s.next;
		System.out.println(start.val + " " + end.val);
		end = end.next.next;
		System.out.println(start.val + " " + end.val);

	}
}

class l {
	l next;
	int val;

	l(int val) {
		this.val = val;
	}
}
