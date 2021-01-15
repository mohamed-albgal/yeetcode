package solutions.strings;

import java.util.Arrays;
public class StringSolutions {

    public static void main(String[] args){

        //add a int array straight to a hashset
    }

    // 1

    public static boolean isAnagram(final String s, final String t) {


        if (s.length() != t.length()) return false;

        final char[] letterboard = new char[256];
        final char[] cleared = new char[256];

        for (final char elt : s.toCharArray()) {
            letterboard[elt]++;
        }

        for(final char elt: t.toCharArray()) {
            letterboard[elt]--;
        }

        return Arrays.equals(letterboard, cleared);
    }

    //2

    /**
     * Given aab -> 2A1B
     *
     * do not count dupes gt 9
     *  (12 'a's) aaaaaaaaaaa -> 9A3A
     *
     *
     */
    public String runLengthEncoding(String string) {
		StringBuilder sb = new StringBuilder();
		char[] letters = string.toCharArray();
		int left = 0;
		int right = 0;
		int len = letters.length;

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
    //3 /*yet to solve text-justify*/
    //4
    public String reverseWords(String s) {
        String normalSpaced = s.trim().replaceAll("\\s+"," ");
        StringBuilder sb = new StringBuilder();
        int j = normalSpaced.length();
        for (int i = normalSpaced.length()-1; i >= 0; i--){
            char letter = normalSpaced.charAt(i);
            if (letter == ' ' || i == 0){
                int start = i == 0 ? i : i +1;
                sb.append(normalSpaced.substring(start, j));
                sb.append( i == 0 ? "":" ");
                j = i;
            }
        }
        return sb.toString();
    }
}