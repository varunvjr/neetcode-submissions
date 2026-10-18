

class Solution {
    public int coinChange(int[] coins, int amount) {
        int cache[] = new int[amount + 1];
        Arrays.fill(cache, -1);
        int result = dfs(coins, amount, cache);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int dfs(int[] coins, int amount, int[] cache) {
        if (amount == 0) return 0; // No coins needed for amount = 0
        if (amount < 0) return Integer.MAX_VALUE; // Impossible case

        if (cache[amount] != -1) return cache[amount]; // Return cached result

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subResult = dfs(coins, amount - coin, cache);
            if (subResult != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + subResult);
            }
        }

        cache[amount] = minCoins;
        return minCoins;
    }
}
