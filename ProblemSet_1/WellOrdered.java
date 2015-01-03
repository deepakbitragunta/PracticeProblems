import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class WellOrdered {

	private static int stringCount=0, recursion_count = 0;
	
	private static void printWellOrderedString(String current, int charLeft) {
		if(charLeft == 0) {
			System.out.println(current);
		}
		
		char i;

		if(current.isEmpty()) i = 'a';
		else i = (char) (current.charAt(current.length() - 1) + 1);
		for(; i <= 'z' && charLeft > 0; ++i) 
				printWellOrderedString(current + i, charLeft - 1);
	}




	private static void getWellOrderedString(String currentString,int charsLeft)
	{
		recursion_count++;
		if(charsLeft==0)
		{	
			System.out.println(currentString);
				stringCount++;		
		}
		char i, j;
		
		if(currentString.isEmpty()) { 
			i='a';
			j = 'A';
		}
		else {
			char lastchar = currentString.charAt(currentString.length()- 1);
			
			if(lastchar >= 'a' && lastchar < 'z') {
				i=(char) (lastchar + 1);
				j = (char) (lastchar - 32 + 1) ;
			}
			else if(lastchar >= 'A' && lastchar < 'Z') {
				j = (char) (lastchar  + 1);
				i = (char) (lastchar + 32 + 1);
			}
			else {
				return;
			}
		}	
		for (;i <='z' && charsLeft > 0; i++)
		{
			getWellOrderedString(currentString+i, charsLeft-1);
		}
		for (;j <='Z' && charsLeft > 0; j++)
		{
			getWellOrderedString(currentString+j, charsLeft-1);
		}
	
		
	}
	public static void main(String args[])
	{
		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream("C:\\Users\\DeepakBitragunta\\Epic\\Epic\\src\\output.txt"));
			System.setOut(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getWellOrderedString_Intf(3, out);
		System.out.println("Total count: "+stringCount + " \n Recursion count: " + recursion_count);
	}
	private static void getWellOrderedString_Intf(int i, PrintStream out ) {
		getWellOrderedString("",i);
		
	}
}	