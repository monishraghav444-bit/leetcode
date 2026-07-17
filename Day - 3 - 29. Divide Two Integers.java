class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow: INT_MIN / -1 exceeds INT_MAX
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine sign of result
        boolean negative = (dividend < 0) != (divisor < 0);
        
        // Work with absolute values as longs to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        long quotient = 0;
        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            quotient += multiple;
        }
        
        long result = negative ? -quotient : quotient;
        
        // Clamp to 32-bit signed integer range
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int) result;
    }
}
