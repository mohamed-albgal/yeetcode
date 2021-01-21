class Solution {
/*
	given a String of digits, return all possible IP address that can be created from it
	0000 -> 0.0.0.0
	132123 -> 12.21.23, 132.1.2.3, 1.32.1.23, 1.3.212.3, 1.3.2.123

*/

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return new ArrayList<String>();
        ArrayList<String> ret = new ArrayList<String>();
	recur(s, ret, new ArrayList<Integer>());
	return ret;
    }

    public static void recur(String input, List<String> list, List<Integer> subList){
        if (input.equals("")){
            if (subList.size() == 4){
                list.add(subList.stream().map(Object::toString).collect(Collectors.joining(".")));
            }
            return;
        }

        for (int i = 3; i > 0; i--){
            if (i > input.length() || (i > 1 && input.charAt(0) == '0')) continue;
            String next = input.substring(0,i);
            int number = Integer.parseInt(next);
            if (number < 256){
                subList.add(number);
                recur(input.substring(next.length()), list,subList);
                subList.remove(subList.size()-1);
            }
        }
    }
}
