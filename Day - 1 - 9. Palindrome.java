class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes (due to the '-' sign)
        // Numbers ending in 0 are never palindromes unless the number itself is 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            x /= 10;
            reversedHalf = reversedHalf * 10 + digit;
        }
        
        // Even number of digits: x == reversedHalf
        // Odd number of digits: middle digit doesn't matter, so drop it with reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
