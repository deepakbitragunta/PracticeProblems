package programs;

public class BuynSell {
    public static int maxProfit(int[] prices) {
        int min = 0 ;
        int diff = 0, max_diff = 0;
        int i, n = prices.length;
        int buy = 0, sell = 0;
        
        for(i = 0; i < n; ++i) {
            if(prices[i] < prices[min]) {
                min = i;
            }
            diff = prices[i] - prices[min];
            if(diff > max_diff) {
                buy = min;
                sell = i;
                max_diff = diff;
            }
        }
        return max_diff;
    }
	
	public static void main(String args[]) {
		int prices[] = {3,58,2,60,18,1,58};
		System.out.println(maxProfit(prices));
}
}	