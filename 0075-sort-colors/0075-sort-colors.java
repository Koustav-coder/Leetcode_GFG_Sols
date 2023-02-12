class Solution {
     public int startingIndex = 0;
    public void sortColors(int[] nums) {
        sortByNumber(nums, 0);
        sortByNumber(nums, 1);
    }
    
    private void sortByNumber(int[] nums, int number) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number) {
                swap(nums, i, startingIndex);
                startingIndex += 1;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}