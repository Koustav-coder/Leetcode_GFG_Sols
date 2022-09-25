class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;
        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
// Time Complexity - BigO(N) where N is the length of nums. We iterate through every element of nums exactly once.

// Space Complexity - BigO(1) No matter how long the input is, we are only ever using 2 variables: currentSubarray and maxSubarray.
