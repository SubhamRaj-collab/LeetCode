class Solution {
    public int minimizeMax(int[] nums, int p) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int right = nums[n-1]-nums[0];
        int left = 0;
        int res = right-left;

        while(left <= right)
        {
            int mid = left+(right-left)/2;

            if(isPossible(nums, mid, p))
            {
                res = mid;
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }

        return res;

    }

    public boolean isPossible(int nums[], int target, int p)
    {
        for(int i = 1; i < nums.length; i++){

            if(nums[i]-nums[i-1] <= target)
            {
                i++;
                p--;
            }

        }

        return p<=0;
    }

}