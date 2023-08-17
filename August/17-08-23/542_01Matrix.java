class Solution {
    public int[][] updateMatrix(int[][] mat) {

        // Multi - BFS
        
        int dirs[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        Queue<int[]> q = new ArrayDeque<>();
        int m = mat.length;
        int n = mat[0].length;

        int result[][] = new int[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.offer(new int[]{i, j});
                    result[i][j] = 0;
                }
                else
                {
                    result[i][j] = -1;
                }
            }
        }        

        int i = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            i++;

            while(size-- > 0)
            {
                int[] top = q.poll();

                for(int[] way: dirs)
                {
                    int newX = top[0]+way[0];
                    int newY = top[1]+way[1];

                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && result[newX][newY] == -1)
                    {
                        result[newX][newY] = i;

                        q.offer(new int[]{newX, newY});
                    }
                }
            }

        }

        return result;

        //TC: O(2*m*n)

    }
}