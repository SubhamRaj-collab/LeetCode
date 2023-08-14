public class 1218_LongestSubsequeneOfGivenDifference {
    
    public int longestSubsequence(int[] arr, int difference) {
        
        int n = arr.length;
        int num[] = new int[n];
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = n-1; i >= 0; i--)
        {
            int target = arr[i]+difference;

            if(map.containsKey(target))
            {
                int k = num[map.get(target)]+1;
                num[i] = k;
            }
            else
            {
                num[i]++;
            }

            map.put(arr[i], i);
            max = Math.max(max, num[i]);

        }

        return max;

    }

}
