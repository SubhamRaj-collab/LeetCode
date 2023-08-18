class Solution {
    
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int a = roads.length;
        int b = 0;

        if(a != 0)
            b = roads[0].length;

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 0; i < a; i++)
        {
            int x = roads[i][0];
            int y = roads[i][1];

            Set<Integer> set = new HashSet<>();

            if(map.containsKey(x))
            {
                set = map.get(x);
            }

            set.add(y);

            map.put(x, set);

            set = new HashSet<>();

            if(map.containsKey(y))
            {
                set = map.get(y);
            }

            set.add(x);

            map.put(y, set);

        }

        int max = 0;

        for(int i = 0; i < n; i++)
        {
            if(!map.containsKey(i))continue;

            for(int j = i+1; j < n; j++)
            {
                if(i == j || !map.containsKey(j))continue;

                int k = map.get(i).size();
                int l = map.get(j).size();

                int total = k+l;

                if(map.get(i).contains(j))  total--;

                max = Math.max(max, total);

            }
        }

        return max;

    }

}
