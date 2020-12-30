package solutions.strings;
import java.util.Arrays;
public class StringSolutions {
    
    public static void main(String[] args){

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
}