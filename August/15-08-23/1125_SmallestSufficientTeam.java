class Solution {

    // List<Integer> minArr = new ArrayList<>();

    // List<Integer> minPeople = new ArrayList<>();

    int dp[][];
    boolean choice[][];

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        // int n = req_skills.length;
        
        // List<Integer> l = new ArrayList<>();
        // Set<String> set = new HashSet<>();
        // solve(0, set, people, l, n);
        
        // int res[] = new int[minArr.size()];
        // for(int i = 0; i < minArr.size(); i++)
        // {
        //     res[i] = minArr.get(i);
        // }

        // return res;
        
        // If I use a data structure instead of a data type, then I have to make a new Data Structure at every point in recursion. But If I use a data type, than it is easier to use in recursion or Back Tracking.
        // So, we will use BitMasking.

        /*
        Running only because of limited test cases. But not the right solution.
        
        // int totSkills = req_skills.length;

        // Map<String, Integer> map = new HashMap<>();

        // for(int i = 0; i < totSkills; i++)
        // {
        //     map.put(req_skills[i], i);
        // }

        // int peopleBits[] = new int[people.size()];

        // for(int i = 0; i < people.size(); i++)
        // {
        //     for(int j = 0; j < people.get(i).size(); j++)
        //     {
        //         peopleBits[i] = ((1<<(map.get(people.get(i).get(j))))|peopleBits[i]);
        //     }
        // }

        // List<Integer> taken = new ArrayList<>();
        // int takenBit = 0;
        // int reqSkills = (1<<totSkills)-1;
        // helper(0, reqSkills, peopleBits, taken, takenBit);

        // int res[] = new int[minPeople.size()];
        // for(int i = 0; i < minPeople.size(); i++)
        // {
        //     res[i] = minPeople.get(i);
        // }

        // return res;
        */

        int skillsLen = req_skills.length;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < skillsLen; i++)
        {
            map.put(req_skills[i], i);
        }

        int peopleSkills[] = new int[people.size()];

        for(int i = 0; i < people.size(); i++)
        {
            for(int j = 0; j < people.get(i).size(); j++)
            {
                peopleSkills[i] |= (1<<(map.get(people.get(i).get(j))));
            }
        } 

        // AS, the length is maximum 16.
        int req_mask = (1<<skillsLen)-1;
        dp = new int[1<<skillsLen][people.size()];
        choice = new boolean[1<<skillsLen][people.size()];

        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                dp[i][j] = -1;
            }
        }

        int help = helper(peopleSkills, 0, 0, req_mask);

        List<Integer> list = new ArrayList<>();
        int mask = 0;
        for(int i = 0; i < peopleSkills.length; i++)
        {
            if(choice[mask][i])
            {
                list.add(i);
                mask |= peopleSkills[i];
            }
            if(mask == req_mask)
            {
                break;
            }
        }

        int res[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            res[i] = list.get(i);
        }

        return res;
    }

    public int helper(int peopleSkills[], int person, int bitMask, int req_mask)
    {
        if(bitMask == req_mask)
        {
            return 0;
        }
        if(person == peopleSkills.length)
        {
            // As people.length is maximum 60.
            return 10000;
        }

        if(dp[bitMask][person] != -1)
        {
            return dp[bitMask][person];
        }

        int take = helper(peopleSkills, person+1, bitMask|peopleSkills[person], req_mask)+1;
        int notTake = helper(peopleSkills, person+1, bitMask, req_mask);

        if(take < notTake)
        {
            choice[bitMask][person] = true;
        }

        return dp[bitMask][person] = Math.min(take, notTake);
    }

    /*
    only because of limited testcases, this program is running. Else, it should not run, because we are not using DP in it.
        public void helper(int person, int reqSkills, int peopleBits[], List<Integer> taken, int takenBit)
        {
            if(minPeople.size() > 0 && taken.size() >= minPeople.size() || person == peopleBits.length)
            {
                return;
            }

            taken.add(person);
            if(reqSkills == (takenBit|(peopleBits[person])))
            {
                minPeople = new ArrayList<>(taken);
                taken.remove(taken.size()-1);
                return;
            }
            if((takenBit|(peopleBits[person])) > takenBit)
            {
                helper(person+1, reqSkills, peopleBits, taken, (takenBit|(peopleBits[person])));    //taken
            }
            
            taken.remove(taken.size()-1);

            helper(person+1, reqSkills, peopleBits, taken, takenBit);     // not taken
        }
    */

    // public void solve(int idx, Set<String> set, List<List<String>> people, List<Integer> l, int n)
    // {
    //     if(idx >= people.size())
    //     {
    //         if(set.size() == n)
    //         {
    //             if(minArr.size() == 0 || l.size() < minArr.size())
    //             {
    //                 minArr = new ArrayList<>();
    //                 for(Integer item: l)
    //                 {
    //                     minArr.add(item);
    //                 }
    //             }
    //         }
    //         return;
    //     }

    //     Set<String> s = new HashSet<>(set);
    //     List<Integer> newList1 = new ArrayList<>(l);
    //     newList1.add(idx);
    //     for(int i = 0; i < people.get(idx).size(); i++)
    //     {
    //         s.add(people.get(idx).get(i));
    //     }
    //     solve(idx+1, s, people, newList1, n);

    //     Set<String> s2 = new HashSet<>(set);
    //     List<Integer> newList2 = new ArrayList<>(l);
    //     solve(idx+1, s2, people, newList2, n);

    // }

}