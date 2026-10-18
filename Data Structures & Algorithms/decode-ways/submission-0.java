class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize dp array with -1
        return countWays(dp, 0, s);
    }

    public int countWays(int[] dp, int i, String s) {
        if (i == s.length()) return 1; // Reached end of string
        if (s.charAt(i) == '0') return 0; // '0' cannot be decoded
        if (dp[i] != -1) return dp[i]; // Return cached result

        // Single-character decoding
        dp[i] = countWays(dp, i + 1, s);

        // Two-character decoding if valid
        if (i + 1 < s.length() && (s.charAt(i) == '1' || 
            (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
            dp[i] += countWays(dp, i + 2, s);
        }

        return dp[i];
    }
}
