
class ValidAnagrams{


	    public static boolean isAnagram(String s, String t) {

        //array of length 26, representing the indices of the letters in the alphabet (a=0, b=1...z=25)
        int[] alphabet = new int[26];

        //increment the index of every letter in "s"
        for (char letter : s.toLowerCase().toCharArray())  {
            alphabet[letter-'a']++;
        }
        //do the same for "t" but decrement instead
        for(char letter: t.toLowerCase().toCharArray())    {
            alphabet[letter-'a']--;
        }
        //if the array is back to its original state(all zeros), then anagrams are found (in yoda voice)
        return s.length() == t.length() && Arrays.equals(alphabet, new int[26]);
    }
}