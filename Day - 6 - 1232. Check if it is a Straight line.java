class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int dx = coordinates[1][0] - x0, dy = coordinates[1][1] - y0;
        
        for (int i = 2; i < coordinates.length; i++) {
            int dxi = coordinates[i][0] - x0;
            int dyi = coordinates[i][1] - y0;
            
            // Cross product check: dx*dyi - dy*dxi must be 0 for collinearity
            if (dx * dyi - dy * dxi != 0) {
                return false;
            }
        }
        
        return true;
    }
}
