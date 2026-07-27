class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];

       
        for (int num : nums) {
            count[num]++;
        }
        int runningSum = 0;
        int[] smaller = new int[101];
        for (int i = 0; i < 101; i++) {
            smaller[i] = runningSum;
            runningSum += count[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = smaller[nums[i]];
        }

        return result;
    }
}
