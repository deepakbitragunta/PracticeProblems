package programs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Polynomial {

	Map<Integer, Integer> polyMap; 
	
	Polynomial(ArrayList<Integer> degree, ArrayList<Integer> coeff) {
		if(degree.size() != coeff.size()) { System.out.println("Invalid Inputs"); }
		else{
				polyMap = new HashMap<Integer, Integer>();
				int temp_c = 0, temp_d = 0;
				
				for(int i = 0; i < degree.size(); ++i) {
					temp_d = degree.get(i);
					temp_c = coeff.get(i);			
					if(polyMap.containsKey(temp_d)) {
						temp_c = polyMap.get(temp_d) + temp_c;
					}
					polyMap.put(temp_d, temp_c);
				}	
				
			}
		}
	
	Polynomial polyAddition(Polynomial polyB ) {
		Map<Integer, Integer> polySum = new HashMap<Integer, Integer>();
		Map<Integer, Integer> poly1 = this.polyMap;
		Map<Integer, Integer> poly2 = polyB.polyMap;
		
		int degree = 0, coeff = 0;
		for(Map.Entry<Integer, Integer> entry: poly1.entrySet()) {
			 degree = entry.getKey();
			 coeff = entry.getValue();
			
			if(poly2.containsKey(degree)) {
				coeff = poly2.get(degree) + coeff;
			}
			polySum.put(degree, coeff);
		}
		
		for(Map.Entry<Integer, Integer> entry: poly2.entrySet()) {
			degree = entry.getKey();
			coeff = entry.getValue();			
			if(polySum.containsKey(degree)) {
				continue;
			}
			else {
				polySum.put(degree, coeff);
			}
		}
		
		Polynomial sum = new Polynomial(new ArrayList<Integer>(polySum.keySet()),new ArrayList<Integer>(polySum.values()));
		
		return 	sum;
	}

	void printPolynomial() {
	
		int degree = 0, coeff = 0;
		
		for(Map.Entry<Integer, Integer> entry: polyMap.entrySet()) {
			degree = entry.getKey();
			coeff = entry.getValue();
			if(degree == 0) {
				System.out.print(coeff);
			} else {
				if (coeff <= 0) {
					System.out.print(coeff + " (x ^ " + degree + ")  ");
				}
				else {
					System.out.print(" + " + coeff + " (x ^ " + degree + ") ");
				}
			}
		}	
		
	}
	
	Polynomial polyDerivative() {
		
		Map<Integer, Integer> polyDervitaive = new HashMap<Integer, Integer>();
		int degree = 0, coeff = 0;

		
		for(Map.Entry<Integer, Integer> entry: polyMap.entrySet()) {
			degree = entry.getKey();
			coeff = entry.getValue();			
			
			if(degree == 0) { 
				continue; 
			}		
			coeff  = coeff * degree;
			degree -= 1;
			
			polyDervitaive.put(degree, coeff);
		}
		
		Polynomial dervitative = new Polynomial(new ArrayList<Integer>(polyDervitaive.keySet()),new ArrayList<Integer>(polyDervitaive.values()));
		
		return 	dervitative;
	}
	
	public static void main(String args[]) {
		ArrayList<Integer> deg1 = new ArrayList<Integer>();
		ArrayList<Integer> coef1 = new ArrayList<Integer>();
		
		deg1.add(1); 
		deg1.add(2); 
		deg1.add(3); 
		deg1.add(2); 
		
		coef1.add(1);
		coef1.add(2); 
		coef1.add(-13); 
		coef1.add(2); 
		
	/*	int deg2[] = {2,4,5,1,7,8,9,10,0};
		int coeff2[] = {11, -1,-4,6,29,10};
		int deg3[] =   {-2, 5,6,8,1,3,-5,2};
		int coeff3[] = {10, -1};
	*/
		
		Polynomial poly1 = new Polynomial (deg1, coef1);
		System.out.println("Polynomial 1 : ");
		poly1.printPolynomial();
		
		
		Polynomial poly2 = new Polynomial (deg1, coef1);
		System.out.println(" \n Polynomial 2 : ");
		poly2.printPolynomial();
		
		Polynomial sum = poly1.polyAddition(poly2);
		System.out.println("\n Sum of poly 1 and poly 2 : ");
		sum.printPolynomial();
		
		Polynomial derv = poly1.polyDerivative();
		System.out.println("\n Derivative of poly 1  : ");
		derv.printPolynomial();
	}
}