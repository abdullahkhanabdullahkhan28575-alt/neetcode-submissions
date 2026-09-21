class Solution {
    public int lengthOfLongestSubstring(String s) {
        int rev =0;


        for(int i=0; i<s.length(); i++){
            Set<Character> charset=new HashSet();

            for(int j=i; j<s.length(); j++){
                if(charset.contains(s.charAt(j))){
                    break;
                }
                charset.add(s.charAt(j));


            }
            rev=Math.max(rev,charset.size());
        }
        return rev;
        
    }
}
