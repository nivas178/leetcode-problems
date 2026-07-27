class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] counts = new int[101];
        int goodPairs = 0;

        for (int num : nums) {
            goodPairs += counts[num];
            counts[num]++;
        }

        return goodPairs;
    }
}
