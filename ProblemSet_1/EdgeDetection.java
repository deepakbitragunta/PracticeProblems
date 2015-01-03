public class EdgeDetection {

	public static int[] processEdges(int image[], int height, int width, int threshold) {
		if(image == null) {
			return null;
		}
		if(width == 1) {
			return null;
		}
		
		if(image.length < width || image.length % width > 0) {
			return null;
		}
		
		int n = image.length;
		
		int left, right, top, bottom, k, value, diff;
		int output[] = new int[n];
		
		for(int row = 0; row < n; row += width) {
			for(int col = row; col < row + width; col++) {
				boolean exceed = false;
				value = image[col];
				
				if(col - 1 >= 0) {
					 left = image[col - 1];
					 diff = Math.abs(left - value);
					 if(diff >= threshold)  {
						 exceed = true;
					 } 
				}
				if(col + 1 < width) {
					right =image[col + 1];
					diff = Math.abs(right - value);
					 if(diff >= threshold)  {
						 exceed = true;
					 } 
				}
				if(col + width < n) {
					bottom = image[ width + col];
					diff = Math.abs(bottom - value);
					 if(diff >= threshold)  {
						 exceed = true;
					 } 
				}
				if(col - width  >= 0) {
					top = image[col - width];
					diff = Math.abs(top - value);
					 if(diff >= threshold)  {
						 exceed = true;
					 } 
				}
				if(exceed) 
					output[col] = value;
				 
			}
		}
	
		return output;	
	}		
	

	public static void main(String args[]) {
	
		int image[] = {1,3,4,5,2,4,6,3,5,6,7,3,8,2,12,52};
		int threshold = 3;
		
		int [] output = processEdges(image, 4, 4, threshold);
		for(int i = 0; i < output.length; ++i) {
			System.out.println(output[i]);
		}
}
}