class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hset = new HashSet<>();
        
        if(s.length()==0){
            return 0;
        }
        
        int i = 0 ;
        int j = 0 ;
        
        int ans = 1;
        int sum = 0;
        
        while(j<s.length()){
            if(!hset.contains(s.charAt(j))){
                hset.add(s.charAt(j));
                sum++;
                j++;
            }else{
                hset.remove(s.charAt(i));
                ans = Math.max(ans,sum);
                sum--;
                i++;
            }
        }
        
        ans = Math.max(ans,sum);
        return ans;
    }
}