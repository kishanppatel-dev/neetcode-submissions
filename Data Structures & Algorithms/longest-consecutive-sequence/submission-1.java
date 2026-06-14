class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> st = new HashSet<>();

        for (int i : nums) {
            st.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;

            if (!st.contains(nums[i] - 1)) {
                int curr = nums[i];
                while (st.contains(curr+1)) {
                    curr = curr+1;
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }

        return res;
    }
}
