class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int m = res.size()-1;
            if (intervals[i][0] <= res.get(m)[1]) {
                res.get(m)[1] = Math.max(res.get(m)[1], intervals[i][1]);
            }
            else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
