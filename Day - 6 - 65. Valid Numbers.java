class Solution {
    public boolean isNumber(String s) {
        int i = 0, n = s.length();
        
        // Skip leading sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        
        boolean sawDigits = false;
        boolean sawDot = false;
        
        // Parse digits and optional dot (the integer/decimal part)
        while (i < n && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
            if (Character.isDigit(s.charAt(i))) {
                sawDigits = true;
            } else { // it's a dot
                if (sawDot) return false; // more than one dot
                sawDot = true;
            }
            i++;
        }
        
        // Must have at least one digit in the mantissa
        if (!sawDigits) return false;
        
        // Handle optional exponent
        if (i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            
            // Optional sign after e/E
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            
            boolean sawExpDigits = false;
            while (i < n && Character.isDigit(s.charAt(i))) {
                sawExpDigits = true;
                i++;
            }
            
            // Exponent must have at least one digit
            if (!sawExpDigits) return false;
        }
        
        // Valid only if we consumed the entire string
        return i == n;
    }
}
