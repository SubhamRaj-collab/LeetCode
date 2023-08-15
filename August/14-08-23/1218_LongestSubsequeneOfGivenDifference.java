public class 1218_LongestSubsequeneOfGivenDifference {
    
    public int longestSubsequence(int[] arr, int difference) {
        
        // int n = arr.length;
        // int num[] = new int[n];
        // //Making a different array for storing occurences insures to find longest AP among same elements also.
        // int max = 0;

        // Map<Integer, Integer> map = new HashMap<>();
        // //Using HashMap we can map a number with its index and find whether it has occured already while we are traversing backwards.

        // for(int i = n-1; i >= 0; i--)
        // {
        //     int target = arr[i]+difference;

        //     if(map.containsKey(target))
        //     {
        //         int k = num[map.get(target)]+1;
        //         num[i] = k;
        //     }
        //     else
        //     {
        //         num[i]++;
        //     }

        //     map.put(arr[i], i);
        //     max = Math.max(max, num[i]);

        // }

        // return max;

        // int n = arr.length;
        // int max = 0;

        // Map<Integer, Integer> map = new HashMap<>();

        // for(int i = n-1; i >= 0; i--)
        // {
        //     int target = arr[i]+difference;
        //     int k = 1;

        //     if(map.containsKey(target))
        //     {
        //         k += map.get(target);
        //     }

        //     map.put(arr[i], k);
        //     max = Math.max(max, k);

        // }

        // return max;

        int n = arr.length;
        int numArr[] = new int[40004];
        int max = 0;

        for(int i = 0; i < n; i++)
        {
            numArr[arr[i]+20001] = numArr[arr[i]+20001-difference]+1;
            max = Math.max(max, numArr[arr[i]+20001]);
        }

        return max;

        //This is only possible because: -104 <= arr[i], difference <= 104

    }

}
