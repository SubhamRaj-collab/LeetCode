// https://leetcode.com/problems/maximum-running-time-of-n-computers/description/

class Solution {
    public long maxRunTime(int n, int[] batteries) {

        // Minimum time n computers can run is the minimum value of batteries.
        // And the maximum time n computers can run is the avg of all the batteries divided among all computers.
        
        long start = Integer.MAX_VALUE, end = Integer.MAX_VALUE, res = 0;

        long total = 0;
        for(int i = 0; i < batteries.length; i++)
        {
            start = Math.min(start, batteries[i]);
            total += batteries[i];
        }

        end = total/n;

        while(start <= end)
        {
            long mid = start+(end-start)/2;

            if(isPossible(n, batteries, mid))
            {
                res = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return res;

    }

    // A battery can be used only in one computer, so even if the battery is more than the avgTime required, it will only give power to the computer at everytime during the avgTime duration.
    
    // If it is possible that the battery can run avgTime time duration, then isPossible function will return true else it will return false. 

    public boolean isPossible(int n, int batteries[], long avgTime)
    {
        long total = 0;

        for(Integer item: batteries)
        {
            if(item >= avgTime)
            {
                total += avgTime;
            }
            else
            {
                total += item;
            }
        }

        return total >= avgTime*n ? true : false;
    }

}

// TC: log(maxTime) * k
    // k = length of the batteries array
    // maxTime = sum of all the batteries / no of computers

// TC: 10^5 * log(10^5 * 10^9 (max should be taken = sum))
// TC: 10^5 * log(10^14)

// SC: log(maxTime) * k
// Same