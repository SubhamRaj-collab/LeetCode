class Solution {
    public boolean increasingTriplet(int[] nums) {

        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;

        for(int num: nums)
        {
            if(num <= max1)max1 = num;
            // It doesn't matter, if a new Number comes as max1, after a max2 is assigned. If a number arrives that is greater than max1 and max2 variable than it means that it is the thirs number of the increasing subsequence for which the first two numbers must be there.
            else if(num <= max2)max2 = num;
            else return true;
        }

        return false;

        // TC: O(n), SC: O(1)

        // int n = nums.length;
        // int dp[] = new int[n];

        // for(int i = 0; i < n; i++)
        // {
        //     for(int j = 0; j < i; j++)
        //     {
        //         if(nums[j] < nums[i])
        //         {
        //             dp[i] = dp[j]+1;
        //         }

        //         if(dp[i] >= 2)return true;
        //     }
        // }

        // return false;

        // O(n^2)
        // Will not work for this question

        // int n = nums.length;

        // int leftMin[] = new int[n];
        // int rightMax[] = new int[n];
        // leftMin[0] = nums[0];
        // rightMax[n-1] = nums[n-1];

        // for(int i = 1; i < n; i++)
        // {
        //     leftMin[i] = Math.min(leftMin[i-1], nums[i]);
        // }

        // for(int i = n-2; i >= 0; i--)
        // {
        //     rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        // }

        // for(int i = 0; i < n; i++)
        // {
        //     if(nums[i] > leftMin[i] && nums[i] < rightMax[i])return true;
        // }

        // return false;

        //TC: O(n) SC: O(1)

    }

}