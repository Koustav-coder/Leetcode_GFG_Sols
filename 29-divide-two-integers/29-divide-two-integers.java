class Solution {
    public int divide(int dividend, int divisor) {
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int quotient = 0;
        
        while (dividend - divisor >= 0) {
            
            int count = 0; // counts how many doubles of 'divisor' fit in 'dividend' and in any remainders
            int prevDouble = divisor;
            int currDouble = divisor + divisor;
            
            while (dividend - currDouble >= 0) {
                count++;
                prevDouble += prevDouble;
                currDouble += currDouble;
            }
            
            int currQuotient = (int) Math.pow(2, count); // current quotient, same as left shift:  1 << count
            quotient += currQuotient;
            dividend -= prevDouble; // 'dividend' becomes the remainder for the next iteration
        }
        
        return sign == 1 ? quotient : -quotient;
    }
}