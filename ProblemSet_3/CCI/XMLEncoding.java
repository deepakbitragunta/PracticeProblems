public class XMLEncoding {

	private Map<String, Byte> tagMap;
	private static final Byte[] END = {0, 1};
	private List<String> tokens;
	private int current;
	
	byte[] encode(char[] input) throws IoException {
		tokenize(input);
		current = 0;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		encodeTokens(out);
		return out.toByteArray();
	}
	
	void encodeTokens(ByteArrayOutputStream out) {
		nextToken("<");
		
		String tagName = nextToken();
		out.write(getTagCode(tagName));
		
		while(!hasNextTokens(">") && !hasNextTokens("/", ">")) {
				
			String key = nextToken();
			nextToken("=");
			String value = nextToken();
			
			out.write(getTagCode(key));
			for(c : value.toCharArray()){
				out.write(c);
			}
			
			out.write(end[0]);
			out.write(end[1]);
		}
			// End of attributes;
			out.write(end[0]);
			out.write(end[1]);	
		}
		
		if(hasNextTokens("/", ">")){
			nextToken("/");
			nextToken(">");
		} else {
			nextToken(">");
			while(!hasNextTokens("<", "/")) {
				encodeTokens(out);
			}
			
			nextToken("<");
			nextToken("/");
			nextToken(tagName);
			nextToken(">");
		}
		out.write(End[0]);
		out.write(End[1]);
}
//  Shannon-Fano coding, Huffman coding, 	Arithmetic coding

			
		}
	
	}
	




}