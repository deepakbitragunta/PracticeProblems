public class digitAdditionLL {
	
	public static  Node addDigits(Node num1, Node num2) {
		Node newList, temp;
		int carry, k;
		
		if(num1 == null) return num2;
		else if (num2 == null) return num1;
		else{
			 newList = null;
			 carry = 0;
		}
		
		while(num1.next != null && num2.next != null) {
			 k = (num1.data + num2.data + carry) % 10;
			carry = (num1.data + num2.data + carry) / 10;
			 
			if(newList == null) {
				 temp = new Node(k);
				newList = temp;
			}
			else {
				newList.appendValues(k);
			}
			num1 = num1.next;
			num2 = num2.next;
		}
		
		if(num1 != null || num2 != null) {
			if(num1 != null && num2 != null) {
				k = (num1.data + num2.data + carry) % 10;
				carry = (num1.data + num2.data + carry) / 10;
				
				if(newList == null) {
					temp = new Node(k);
					newList = temp;
				}
				else {
					newList.appendValues(k);
				}   
				num1 = num1.next; 
				num2 = num2.next;
			}
			
			while(num1 != null) {
				 k = (num1.data + carry) % 10;
				carry = (num1.data + carry) / 10;
				newList.appendValues(k);
				num1 = num1.next;
			}
			
			while(num2 != null) {
				 k = (num2.data + carry) % 10;
				carry = (num2.data + carry) / 10;
				newList.appendValues(k);
				num2 = num2.next;
			}
		
			newList.appendValues(carry);
		}
		return newList;
	}
	
	public static Node addDigits(Node n1, Node n2, int carry) {
		if(n1 == null && n2 == null) return null;
		int value = 0;
		if(n1 != null) 
			value += n1.data;
		
		if(n2 != null) 
			value += n2.data;
		value += carry;
		
		carry = value / 10;
		value = value % 10;
		
		Node newList =  addDigits((n1 == null) ? null : n1.next, (n2 == null) ? null : n2.next, carry);
		if(newList == null) {
			newList = new Node(carry);
			newList.appendValues(value);		
		}
		else {
			newList.appendValues(value);
		}
		return newList;
	}
	
	public static void main(String args[]) {
		Node head1 = new Node(7);
		head1.appendValues(6);
		head1.appendValues(9);
			
		
		Node head2 = new Node(5);
		head2.appendValues(7);
		head2.appendValues(8);
		head2.appendValues(9);
		head2.appendValues(9);
		head2.appendValues(9);
		
		Node newlist = addDigits(head1, head2);
		newlist = addDigits(head1, head2, 0);
		System.out.println("display list: \n");
		newlist.displayList();
	
	}

}