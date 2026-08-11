class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0] * (amount + 1)

        for i in range(1, amount+1):
            mini = float('inf')

            for coin in coins:
                diff = i - coin
                if diff < 0:
                    continue
                mini = min(mini, 1 + dp[diff])
            
            dp[i] = mini
        
        return dp[amount] if dp[amount] < float('inf') else -1