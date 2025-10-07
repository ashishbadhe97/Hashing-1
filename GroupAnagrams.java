// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/description/


// Solution 1

/**
 * Time Complexity :  O(n) * K log K, where n is the size of array and K is the average size of each string
 * Space Complexity : O(n) since in worst case no string is anagram, hence once entry for each string
 */



class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap();

        for(int i = 0 ; i < strs.length ; i++){

            char word[] = strs[i].toCharArray();
            Arrays.sort(word);
            String sortedStr = new String(word);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<String>());
            }

            map.get(sortedStr).add(strs[i]);
        }

        return new ArrayList<List<String>>(map.values());
    }
}

// Solution 2


/**
 * Time Complexity :  O(n) * O(K) , where n is number of strings and K is average length of string
 * Space Complexity : O(n) since we take 1 hashmap whose size in worst case would be n. hashtable is always O(26) hence can be ignored
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap();

        for(String word : strs){ // O(n)

            int hashtable[] = new int[26];

            for(char c : word.toCharArray()){ // O(k)
                hashtable[c - 'a']++;
            }

            String key = Arrays.toString(hashtable);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());

    }
}