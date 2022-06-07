class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    
        int i,j,k;
        i=m-1;
        j=n-1;
        for(k=n+m-1;k>=0;k--)
        {
            if(i>=0&&(j==-1||nums1[i]>nums2[j]))
                nums1[k]=nums1[i--];
            else if(j>=0)
                nums1[k]=nums2[j--];
        }
    }
}
