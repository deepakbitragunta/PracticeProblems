import java.util.Scanner;
import java.util.ArrayList;

public class sum_triangle{

	public static ArrayList<Integer> makeSumTriangle(ArrayList<Integer> triangle) {
		if(triangle.size() == 1) {
			return triangle;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < triangle.size() - 1; ++i) {
			temp.add(triangle.get(i) + triangle.get(i + 1));
		}
		temp = makeSumTriangle(temp);
		for(int i = 0; i <= temp.size() - 1; ++i) {
			System.out.print(temp.get(i) + " ");
			temp.remove(i);
		}
		System.out.println("");
		return triangle;
	}

	public static void main(String args[]) {
		
		ArrayList<Integer> triangle = new ArrayList<Integer>();
		System.out.println("Enter number of initial elements: \n");  
   	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; ++i) {
			triangle.add(sc.nextInt());
		}

		triangle = makeSumTriangle(triangle);
		for(int i = triangle.size() - 1; i >= 0; --i) {
			System.out.print(triangle.get(i) + " " );
		}
	}
}