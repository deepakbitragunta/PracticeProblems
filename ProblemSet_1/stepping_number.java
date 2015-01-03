public class stepping_number {

	static void Dfs(long s, long e , long length , long num)
    {
        if (length-1 == 0)
        {
            if ( s <= num && num <=e)
               System.out.println(num);
            return;
        }
        long lastDigit = num%10;
        if (lastDigit == 0)
        {
            Dfs(s , e,length-1 , num*10+1);
        }
        else if (lastDigit == 9)
        {
            Dfs(s, e, length - 1, num*10 + 8);
        }
        else
        {
            Dfs(s , e,length-1 , num*10+lastDigit-1);
            Dfs(s , e,length-1 , num*10+lastDigit+1);
        }
    }

   public static void Main(String[] args)
    {
        long s = 1;
        long e = 1000000000;
        long sLength = (int)Math.floor(Math.log10(s) + 1);
        long eLength = (int)Math.floor(Math.log10(e) + 1);
        for (long i = sLength; i <= eLength; ++i)
        {
	//no leading zero
            for (long j = 1; j < 10; ++j)
            {
                Dfs(s , e, i , j);
            }
        }
    }

}