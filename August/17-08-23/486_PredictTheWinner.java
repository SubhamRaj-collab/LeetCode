public class 486_PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        
        int n = nums.length;
        int arr[][] = new int[n][n];

        for(int i = 0; i < n; i++)
            Arrays.fill(arr[i], -1);

        // The only advantage I have is the First Move. 
        int scoreA = solve(0, nums.length-1, nums, arr);

        int total = 0;
        for(int i = 0; i < nums.length; i++)
        {
            total += nums[i];
        }

        int scoreB = total-scoreA;

        if(scoreA >= scoreB)
        {
            return true;
        }
        else return false;

    }

    public int solve(int start, int end, int nums[], int dp[][])
    {
        if(start > end)
        {
            return 0;
        }

        if(dp[start][end] != -1)return dp[start][end];

        // When I am receiving, assume that I will receive the worst
        int scoreA = nums[start]+Math.min(solve(start+1, end-1, nums, dp), solve(start+2, end, nums, dp));

        int scoreB = nums[end]+Math.min(solve(start+1, end-1, nums, dp), solve(start, end-2, nums, dp));

        // When I will choose, I will choose the best.

        // With recursive leap of faith, when I will run this it will show me the optimal result.
        return dp[start][end] = Math.max(scoreA, scoreB);
    }

}
