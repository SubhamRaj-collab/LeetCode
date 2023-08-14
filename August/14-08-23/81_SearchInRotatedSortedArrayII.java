class Solution {
    public boolean search(int[] nums, int target) {
        
        // for(int i = 0; i < nums.length; i++)
        // {
        //     if(nums[i] == target){
        //         return true;
        //     }
        // }

        // return false;

        int low = 0;
        int high = nums.length-1;

        while(low <= high)
        {
            int mid = low+(high-low)/2;

            if(nums[mid] == target)
            {
                return true;
            }

            if(nums[mid] == nums[high])
            {
                high--;
            }
            else if(nums[mid] < nums[high]) // Next step will be on the part which is sorted.
            {
                if(nums[mid] < target && target <= nums[high])
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            else
            {
                if(nums[low] <= target && target < nums[mid])
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
        }

        // Average T.C : O(log(n))
        // Worst T.C : O(n)
        
        return false;

    }

}