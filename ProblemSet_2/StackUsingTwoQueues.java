/*
 *  Java Program to Implement Stack using Two Queues
 */
 package programs;
 
 // http://www.geeksforgeeks.org/implement-stack-using-queue/
 // http://www.sanfoundry.com/java-program-implement-stack-using-two-queues/
 
import java.util.*;
 
/* Class stackUsingQueue */
class stackUsingQueue
{
    Queue<Integer> q1 ;
    Queue<Integer> q2 ;
 
    /* Constructor */
    public stackUsingQueue()
    {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }    
    /*  Function to push an element to the stack */
    public void push(int data)
    {
        /* if no element is present in queue q1 then
         * enqueue the new element into q1  */         
        if (q1.size() == 0)
            q1.add(data);
        else
        {
            /* if elements are present in q1 then
             * dequeue all the elements to 
             * temporary queue q2 */             
            int l = q1.size();
            for (int i = 0; i < l; i++)
                q2.add(q1.remove());                
            /* enqueue the new element into q1 */
            q1.add(data);        
            /* dequeue all the elements from
             * temporary queue q2 to q1 */                 
            for (int i = 0; i < l; i++)
                q1.add(q2.remove());
        }
    }    
    /*  Function to remove top element from the stack */
    public int pop()
    {
        if (q1.size() == 0)
            throw new NoSuchElementException("Underflow Exception");        
        return q1.remove();
    }    
    /*  Function to check the top element of the stack */
    public int peek()
    {
        if (q1.size() == 0)
            throw new NoSuchElementException("Underflow Exception");            
        return q1.peek();
    }        
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return q1.size() == 0 ;
    }
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return q1.size();
    }    
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        int l = getSize();
        if (l == 0)
            System.out.print("Empty\n");
        else
        {
            Iterator it = q1.iterator();
            while (it.hasNext())
                System.out.print(it.next()+" ");
            System.out.println();
        }
    }
}
/*  Class StackImplementUsingTwoQueues  */
public class StackUsingTwoQueues
{    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);      
        stackUsingQueue suq1 = new stackUsingQueue();                  
        /* Perform Stack Operations */          
        System.out.println("Stack Using Two Queues Test\n");  
        char ch;     
        do 
        {
            System.out.println("\nStack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");            
            int choice = scan.nextInt();
            switch (choice) 
            {
            case 1 : 
                System.out.println("Enter integer element to push");
                suq1.push( scan.nextInt() );                 
                break;                          
            case 2 : 
                try
                {
                    System.out.println("Popped Element = "+ suq1.pop() );
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }        
                break;                         
            case 3 : 
                try
                {
                    System.out.println("Peek Element = "+ suq1.peek() );
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("Empty status = "+ suq1.isEmpty() );
                break;                
            case 5 : 
                System.out.println("Size = "+ suq1.getSize() ); 
                break;            
            default :  
                System.out.println("Wrong Entry \n ");
                break;
            }                 
            /* Display Stack */        
            suq1.display();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);            
        } while (ch == 'Y'|| ch == 'y');                 
    }
}