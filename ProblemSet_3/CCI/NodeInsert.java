import java.util.LinkedList;

public class NodeInsert {

	public static void insert(LinkedList<Integer> list, int num) {
		if(list == null) {
			list = new LinkedList<Integer>();
		}
		if(list.size() == 0) {
			list.add(num);
		}
		int i = 0;
		while(num > list.get(i)) {
			i++;
		}
		list.add(i, num);	
	}
	
	public static void main(String args[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i < 20; i = i + 2) 
			list.add(i);
		for(int i = 23; i < 40; i = i + 2) 
			list.add(i);
		insert(list, 22);
		System.out.println(list.toString());
	}
}