class Solution {
    // declares a class name groupAnagrams 
    public List<List<String>> groupAnagrams(String[] strs) {
        //Map to group anagrams by tjeir character frequency signature
        Map<String, List<String>> map = new HashMap<>();
        // Iterate over each word in the  input array
        for(String word: strs){
            // initialize a frequency count for 26 lowerc ase letters
            int [] count = new int[26];
            for(char c : word.toCharArray() ){
                count[c-'a']++; // increment the count for this character
            }
            // convert the count array into a unique key string 
            StringBuilder keyBuilder = new StringBuilder();
            for(int i=0;i<26;i++){
                keyBuilder.append(count[i]);
                keyBuilder.append('-');
            }
            String key = keyBuilder.toString();
            // group words by this key in the map

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);

        }
        // return all the grouped list
        return new ArrayList<>(map.values());
        
    }
}