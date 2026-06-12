class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String str : strs) {
            char[] keyArr = str.toCharArray();
            Arrays.sort(keyArr);
            String key = String.valueOf(keyArr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }
}
