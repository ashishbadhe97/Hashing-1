// Word Pattern
// https://leetcode.com/problems/word-pattern/

/**
 * Time Complexity :  O(n) since we iterate over all characters
 * Space Complexity : O(1) since only lower case letters (26) are stored in map
 * 
 */

class Solution {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> pMap = new HashMap();
        HashMap<String, Character> sMap = new HashMap();

        String[] words = s.split(" "); 

        if(pattern.length() != words.length){
            return false;
        }

        for(int i = 0 ; i < pattern.length() ; i++){
            char pChar = pattern.charAt(i);
            String word = words[i];

            if(pMap.containsKey(pChar)){
                if(!pMap.get(pChar).equals(word)){   // if same word is not mapped to char as in ith index of pattern
                    return false;
                }
            }else{
                pMap.put(pChar, word);
            }

            if(sMap.containsKey(word)){
                if(!sMap.get(word).equals(pChar)){  // if same char is not mapped to word as in ith index of words
                    return false;
                }
            }else{
                sMap.put(word, pChar);
            }

        }

        return true;
    }
}
