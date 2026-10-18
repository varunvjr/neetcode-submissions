class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp[i][j] will store the minimum cost to reach node i with exactly j stops
        int[][] dp = new int[n][k + 2];  // We need k+1 stops, but use k+2 for easier handling
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);  // Initialize all costs to infinity
        }
        dp[src][0] = 0;  // Cost to reach source with 0 stops is 0
        
        // Process each stop from 0 to k (inclusive)
        for (int stops = 1; stops <= k + 1; stops++) {
            // Copy the previous stop's values to dp[stops]
            for (int i = 0; i < n; i++) {
                dp[i][stops] = dp[i][stops - 1];
            }
            
            // Relax all edges for the current stop count
            for (int[] flight : flights) {
                int u = flight[0];  // source airport
                int v = flight[1];  // destination airport
                int cost = flight[2];  // cost of the flight

                if (dp[u][stops - 1] != Integer.MAX_VALUE) {
                    dp[v][stops] = Math.min(dp[v][stops], dp[u][stops - 1] + cost);
                }
            }
        }
        
        // The minimum cost to reach dst with at most k stops is in dp[dst][0..k+1]
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            minCost = Math.min(minCost, dp[dst][i]);
        }
        
        return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
    }
}