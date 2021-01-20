import java.util.Map;
import java.util.HashMap;

class WordSearch {
        /*
		given a board of letters. Are the letters of "word" horiozontally/vertically adjacent?

        */
        public boolean exist(char[][] board, String word) {
        Map<Character,HashMap<Character,Integer>> adj = new HashMap<>();
        int count = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                char current = board[i][j];
                count++;
                HashMap<Character,Integer> mapping = adj.getOrDefault(current,new HashMap<>());
                if (i > 0) {
                    char up = board[i-1][j];
                    mapping.put(up,mapping.getOrDefault(up, 0) + 1);
                }
                if (i < board.length-1 ){
                    char down = board[i+1][j];
                    mapping.put(down,mapping.getOrDefault(down,0)+1);
                }
                if (j > 0){
                    char left = board[i][j-1];
                    mapping.put(left,mapping.getOrDefault(left,0)+1);
                }
                if (j < board[0].length-1){
                    char right = board[i][j+1];
                    mapping.put(right,mapping.getOrDefault(right,0)+1);
                }
                adj.put(current,mapping);
            }

        }
        if (word.length() > count) return false;

        for (int l = 0; l < word.length(); l++){
            char curr = word.charAt(l);
            if(!adj.containsKey(curr)) break;
            if(l == word.length()-1) return true;
            char next = word.charAt(l +1);
            if (adj.get(curr).containsKey(next)){
                //remove the link to curr from next, or decrement if more than 1
                HashMap<Character,Integer> m = adj.get(next);
                if(!m.remove(curr,1)) m.put(curr,m.get(curr)-1);
            }else break;
        }
        return false;
    }
}