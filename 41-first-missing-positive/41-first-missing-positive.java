class Solution 
{
   public int firstMissingPositive(int[] nums) 
   {
      Arrays.sort(nums);
      int i=0;
      int mis=1;
      while(i<nums.length)
      {
         if(nums[i]==mis)
         {
              mis++;
              i++;
         }
         else if(nums[i]<mis)
         {
              i++;
         }
         else
         {
              return mis;
         }
      }
          return mis;
   }
}    