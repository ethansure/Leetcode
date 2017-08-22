class Solution {
    public int mySqrt(int x) {
        long z = x;
        while (z*z > x){
            z = (z + x/z) / 2;   
        }
        return (int) z;
    }
}