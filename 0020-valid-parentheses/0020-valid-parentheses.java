class Solution {
    public boolean isValid(String s) {
        Map<Character,Character>map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character>stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            char letter=s.charAt(i);
            if(map.containsKey(letter))
            {
                if(stack.isEmpty())
                    return false;
                if(map.get(letter)!=stack.pollLast())
                    return false;
                
            }
            else{
                stack.offer(letter);
            }
                         
                   
            }
        
        return stack.isEmpty();
            
    } 
}