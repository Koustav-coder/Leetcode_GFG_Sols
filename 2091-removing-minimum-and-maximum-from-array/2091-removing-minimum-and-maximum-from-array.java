class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minindx= 0, maxindx = 0;

        for (int i = 0; i < n; i++){
            if (nums[i] < nums[minindx]){
                minindx = i;
            }
            if (nums[i] > nums[maxindx]){
                maxindx = i;
            }
        }

        int l = Math.min(minindx, maxindx);
        int r = Math.max(minindx, maxindx);

        return Math.min(Math.min(r + 1, n - l), l + 1 + n - r);
        
    }
}