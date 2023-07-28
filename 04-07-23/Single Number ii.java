//https://leetcode.com/problems/single-number-ii/description/

class Solution {
    public int singleNumber(int[] nums) {
        
        // int n = nums.length;

        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i = 0; i < n; i++)
        // {
        //     if(map.containsKey(nums[i]))
        //     {
        //         map.put(nums[i], map.get(nums[i])+1);
        //     }
        //     else
        //         map.put(nums[i], 1);
        // }

        // for(Map.Entry<Integer, Integer> entry: map.entrySet())
        // {
        //     if(entry.getValue() == 1)return entry.getKey();
        // }

        // return -1;

        // Passes solution but the answer is not correct as how it is asked in the question.

        // int n = nums.length;
        // if(n==1)return nums[0];

        // Arrays.sort(nums);

        // for(int i = 0; i < n; i++)
        // {
        //     if(i==0)
        //     {
        //         if(nums[i]!=nums[i+1])return nums[i];
        //     }
        //     else if(i==n-1)
        //     {
        //         if(nums[i]!=nums[i-1])return nums[i];
        //     }
        //     else
        //     {
        //         if(nums[i] != nums[i-1] && nums[i] != nums[i+1])return nums[i];
        //     }
        // }

        // return -1;
        //Passes all test cases, but TC: O(nlogn)
        //SC: O(1)

        // int n = nums.length;
        // int ans = 0;

        // //Iterating over each bit of all numbers in nums array. 
        // for(int i = 0; i < 32; i++)
        // {
        //     int sum = 0;
        //     for(int j = 0; j < n; j++)
        //     {
        //         int num = nums[j];
        //         num = num>>i;
        //         num = num&1;
        //         sum += num;
        //     }
        //     sum %= 3;
        //     sum = sum << i;
        //     ans = ans|sum;
        // }

        // return ans;

        // //This is the correct answer, done using bit manipulation on all 32 bits of every number.
        // //TC: O(32*n) SC:O(1)

        int n = nums.length;
        int ones = 0;
        int twos = 0;

        for(int i = 0; i < n; i++)
        {
            ones = (ones^nums[i])&(~twos);
            twos = (twos^nums[i])&(~ones);
        }

        return ones;
        //Most optimal solution with TC:O(n) and SC:O(1)

    }
}