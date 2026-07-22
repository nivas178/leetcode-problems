class Solution {
    public int smallestNumber(int n) {
        int power = 1;
        while (power <= n) {
            power <<= 1;
        }
        return power - 1;
    }
}
