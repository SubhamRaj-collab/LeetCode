// https://leetcode.com/problems/word-break/description/

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<>();
        for(String str: wordDict)
        {
            set.add(str);
        }

        int dp[] = new int[s.length()+1];
        Arrays.fill(dp, -1);

        return solve(0, s, set, dp);

    }

    public boolean solve(int idx, String s, Set<String> set, int dp[])
    {
        if(idx == s.length()){
            return true;
        }

        if(dp[idx] != -1){
            return dp[idx]==1?true:false;
        }
        // True and False, both must be stored so that we do not have to find again.

        String str = "";

        boolean isTrue = false;

        for(int i = idx; i < s.length(); i++)
        {
            str += s.charAt(i);
            if(set.contains(str) && solve(i+1, s, set, dp))
            {
                dp[idx] = 1;
                return true;
            }
        }
        
        dp[idx] = 0;
        return false;

    }

    /*

    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> words = new HashSet<>();

        for(String str: wordDict)
        {
            words.add(str);
        }

        Map<String, Boolean> memo = new HashMap<>();

        return solve(s, words, memo);

    }

    public boolean solve(String s, Set<String> words, Map<String, Boolean> memo)
    {
        if(memo.containsKey(s))return memo.get(s);
        if(words.contains(s))return true;

        for(int i = 1; i <= s.length(); i++)
        {
            String str = s.substring(0, i);

            if(words.contains(str) && solve(s.substring(i), words, memo))
            {
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);
        return false;

    }

    */

}