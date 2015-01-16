/*
 *  Java Program to Implement Queue using Two Stacks
 */
 
  // http://www.geeksforgeeks.org/queue-using-stacks/
 // http://www.sanfoundry.com/java-program-implement-queue-using-two-stacks/
package programs;

import java.util.*;
 
/* Class queueUsingStack */
class queueUsingStack
{
    Stack<Integer> s1 ;
    Stack<Integer> s2 ;
 
    /* Constructor */
    public queueUsingStack()
    {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    /*  Function to insert an element to the queue */
    public void insert(int data)
    {
            s1.push(data);
    }
	
	 /*  Function to remove front element from the queue */
    public int remove()
    {
	        
            int l = s1.size();
			int r = s2.size();
			if(l == 0 && r == 0) {
				throw new NoSuchElementException("Underflow Exception");   
			}
			
			if(r == 0) {
			// stack 2 empty, then push all elements from stack1 to stack2
			// Now we shifted the first element of the queue from bottom of stack1 to
			// top of stack2. Now we need to pop stack2
				for (int i = 0; i < l; i++)
					s2.push(s1.pop());                   
			}				   
			// if stack 2 is not empty, then our first element is at the top of stack 2
			// so pop from stack2 will give us the element.
			return s2.pop();
    }    
 
    /*  Function to check the front element of the queue */
    public int peek()
    {
    	int l = s1.size();
		int r = s2.size();
		if(l == 0 && r == 0) {
			throw new NoSuchElementException("Underflow Exception");   
		}
		
		if(l == 0) {
			return s2.firstElement();
		}
		else {
			return s1.firstElement();
		}      
        
    }        
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return s1.size() == 0 ;
    }    
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return s1.size();
    }    
    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.print("\nQueue = ");
        int l = getSize();
        Stack temp = s1;
        if (l == 0) {
        	 temp = s2; 
        	  l = s2.size();
        	if(l == 0) {
        		System.out.print("Empty\n");
        		return;
        	}	
        }	
        	
            /* Iterator wont return for stack in order */            
            for (int i = 0; i < l; i++)
                System.out.print(temp.get(i)+" ");                
            System.out.println();
        
    }
}
 
/*  Class QueueImplementUsingTwoStacks */
public class QueueUsingTwoStacks
{    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);    
        /* Creating object of class queueUsingStack */
        queueUsingStack qus = new queueUsingStack();            
        /* Perform Queue Operations */            
        System.out.println("Queue Using Two Stacks Test\n"); 
        char ch;         
        do
        {
            System.out.println("\nQueue Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");            
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                qus.insert( scan.nextInt() );                 
                break;                         
            case 2 : 
                try
                {
                    System.out.println("Removed Element = "+ qus.remove() );
                }
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;                         
            case 3 : 
                try
                {
                    System.out.println("Peek Element = "+ qus.peek() );
                }
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                          
            case 4 : 
                System.out.println("Empty status = "+ qus.isEmpty() );
                break;                
            case 5 : 
                System.out.println("Size = "+ qus.getSize() );
                break;                          
            default : 
                System.out.println("Wrong Entry \n ");
                break;    
            }                
            /* Display Queue */        
            qus.display();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
 
        } while (ch == 'Y'|| ch == 'y');                                                            
    } 
}