class Solution {
    public long countSubarrays(int[] A, int minK, int maxK) {
        int lb = -1, lmin = -1, lmax = -1;
        int n = A.length;
        long count=0;

        for (int i=0; i<n; i++) {
            if (A[i] >= minK && A[i] <= maxK) {
                lmin = (A[i] == minK) ? i:lmin;
                lmax = (A[i] == maxK) ? i:lmax;
                count+= Math.max(0, Math.min(lmin, lmax) - lb);
            } else {
                lb = i;
                lmin = -1;
                lmax = -1;
            }
        }

        return count;
    }
}