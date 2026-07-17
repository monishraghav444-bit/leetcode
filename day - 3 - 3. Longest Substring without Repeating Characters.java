class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);
            
            if (lastSeen.containsKey(currentChar) && lastSeen.get(currentChar) >= windowStart) {
                windowStart = lastSeen.get(currentChar) + 1;
            }
            
            lastSeen.put(currentChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        
        return maxLength;
    }
}
