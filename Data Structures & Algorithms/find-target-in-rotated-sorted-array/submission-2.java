class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int m = l + (r - l) / 2;

            // Target found
            if (nums[m] == target) {
                return m;
            }

            // Left half is sorted
            if (nums[l] <= nums[m]) {

                // Target lies in left sorted half
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } 
                else {
                    l = m + 1;
                }

            }
            // Right half is sorted
            else {

                // Target lies in right sorted half
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } 
                else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}