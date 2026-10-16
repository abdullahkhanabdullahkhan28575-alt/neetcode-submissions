class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res=new HashMap<>();
        for(String s:strs){
            char [] charArray=s.toCharArray();
            Arrays.sort(charArray);
            String sorted=new String (charArray);
            res.putIfAbsent(sorted,new ArrayList<>());
            res.get(sorted).add(s);
        }
        return new ArrayList<>(res.values());

        
    }
}
