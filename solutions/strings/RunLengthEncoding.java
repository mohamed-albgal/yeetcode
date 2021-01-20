

class RunLengthEncoding {

	    public String runLengthEncoding(String string) {
		StringBuilder sb = new StringBuilder();
		char[] letters = string.toCharArray();
		int left = 0, right = 0, len = string.length();

		while (left < len){

			char curr = letters[left];
			while (right < len && right - left + 1 < 10 && letters[right] == curr ){
				right++;
			}

			sb.append(right - left);
			sb.append(curr);
			left = right;
		}

    return sb.toString();
	}
}