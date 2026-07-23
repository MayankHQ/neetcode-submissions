class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newString = new String(chars);
            // if(!hash.containsKey(newString)){
            //     hash.put(newString, new ArrayList<>());
            // }
            hash.putIfAbsent(newString, new ArrayList<>());
            hash.get(newString).add(str);
        }
        return new ArrayList<>(hash.values());
    }
}
