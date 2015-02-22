package programs;

public class MissingNumbers {

	public static void findNumbers(int[] a, int n){
		int x=0;
		for(int i=0; i<a.length;i++){
			x=x^a[i];
		}
		for(int i=1;i<=n;i++){
			x=x^i;
		}
		x = x &(~(x-1));
		int p=0, q=0;
		for(int i=0;i<a.length;i++){
			if((a[i] & x) == x){
				p=p^a[i];
			}
			else{
				q=q^a[i];
			}   
		}
		for(int i=1;i<=n;i++){
			if((i & x) == x){
				p=p^i;
			}
			else{
				q=q^i;
			}
		}

		System.out.println("p: "+p+" : "+q);
	}
	
	public static void main(String args[]) {
		int a[] = {1, 2, 4,5,6,7,9,10, 11, 12, 13, 14, 15};
		findNumbers(a, 15);
	}
}