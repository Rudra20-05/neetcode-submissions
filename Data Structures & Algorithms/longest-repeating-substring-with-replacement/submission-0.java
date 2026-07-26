class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> count = new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            count.put(ch, count.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, count.get(ch));

            while ((right - left + 1) - maxFreq > k) {

                count.put(s.charAt(left),
                        count.get(s.charAt(left)) - 1);

                left++;
            }

            maxLength = Math.max(maxLength,
                    right - left + 1);
        }

        return maxLength;
    }
}