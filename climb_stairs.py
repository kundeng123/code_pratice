#for two steps problem, dp[i] = dp[i-1] + dp[i-2]
#time complexity: single loop up to n, O(n)
#space complexity: dp array size of n. O(n)
class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        
        dp = [0] * (n+1)
        dp[1] = 1
        dp[2] = 2
        
        for i in range(3, n+1):
            dp[i] = dp[i-1] + dp[i-2];
            
        
        #print(dp)
        
        return dp[n]

#for three steps problem, dp[i] = dp[i-1] + dp[i-2] + dp[i-3]