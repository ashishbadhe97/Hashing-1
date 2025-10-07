// 205. Isomorphic Strings
// https://leetcode.com/problems/isomorphic-strings/description/

/**
 * Time Complexity :  O(n) since we iterate over all characters
 * Space Complexity : O(1) + O(1) for 1 for hashmap and 1 for hashset of maximum 26 size
 */


class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> sMap = new HashMap(); 
        HashSet<Character> set = new HashSet();

        for(int i = 0 ; i < s.length() ; i++){  // O(n)
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar) != tChar){
                    return false;
                }
            }else{
                if(set.contains(tChar)){
                    return false;
                }
                sMap.put(sChar, tChar);
                set.add(tChar);
            }
        }

        return true;
    }
}