//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
//LeetCode 1493:

class Solution {
    public int longestSubarray(int[] nums) {
        
        // int n = nums.length;
        // List<Integer> list = new ArrayList<>();

        // for(int i = 0; i < n; i++)
        // {
        //     if(i > 0 && nums[i] == 0 && nums[i-1] == 0)
        //     {
        //         list.add(0);
        //         while(i < n && nums[i] != 1)
        //         {
        //             i++;
        //         }
        //         i--;
        //     }
        //     if(nums[i]==1)
        //     {
        //         int count = 0;
        //         while(i < n && nums[i]==1)
        //         {   
        //             count++;
        //             i++;
        //         }
        //         list.add(count);
        //     }
        // }

        // if(list.size() == 1)
        // {
        //     if(list.get(0) != 0 && n == list.get(0))return list.get(0)-1;
        //     else
        //     {
        //         return list.get(0);
        //     }   
        // }
        // else
        // {
        //     int max = 0;
        //     for(int i = 0; i < list.size()-1; i++)
        //     {
        //         int num = list.get(i)+list.get(i+1);
        //         max = Math.max(max, num);
        //     }
        //     return max;
        // }

        // //TC: O(n), SC:O(n)

        int n = nums.length;
        int ans = 0;

        int left = 0;
        int zeroes = 0;

        //We are taking only that subarray through iterating, which contains only one zero.
        for(int right = 0; right < n; right++)
        {
            if(nums[right] == 0)
            {
                zeroes++;
            }

            while(zeroes > 1)
            {
                if(nums[left] == 0)zeroes--;
                left++;
            }

            ans = Math.max(ans, right-left+1-zeroes);
        }

        //If the total array contains only ones, and a number must be deleted, so we have to delete a one.
        return ans==n?ans-1:ans;

        //Better/Optimal Solution  TC: O(n) SC: O(1)

    }
}