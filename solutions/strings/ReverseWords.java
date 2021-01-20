class ReverseWords {

    public String reverseWords(String s) {

    	//split on 1 or more whitespace characters
	    String[] tokens = s.trim().split("\\s+");
	    StringBuilder sb = new StringBuilder();

	    //grab from the end and append. Add a space, unless appending the final word
	    for (int i = tokens.length-1; i >= 0; i--){
	        sb.append(tokens[i]);
	        sb.append( i==0 ? "":" ");
	    }
	    return sb.toString();
	}
}