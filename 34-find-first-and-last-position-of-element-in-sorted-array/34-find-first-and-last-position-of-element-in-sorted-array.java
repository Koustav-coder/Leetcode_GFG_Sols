class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[]{-1,-1};
        boolean lc = true; 
        boolean rc = true;
        while((lc || rc) && left <= right){
            if(nums[left] == target && lc){
                result[0] = left;
                lc = false;
            }
            if(nums[right]== target && rc){
                result[1] = right;
                rc = false; 
            }
            if(lc == false){
                right--;
            }else{
                left++;
            }
        }
        return result; 
    }
}