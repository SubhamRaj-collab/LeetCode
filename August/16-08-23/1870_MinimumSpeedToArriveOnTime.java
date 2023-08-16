public class 1870_MinimumSpeedToArriveOnTime {
    
    public int minSpeedOnTime(int[] dist, double hour) {

        int start = 1;
        int end = 10000000;
        int res = -1;

        while(start <= end)
        {
            int mid = start+(end-start)/2;

            if(isPossible(mid, dist, hour))
            {
                res = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }

        return res;

    }

    public boolean isPossible(int speed, int dist[], double hour)
    {
        double time = 0;

        for(int i = 0; i < dist.length; i++)
        {
            double tc = dist[i]/(double)speed;

            if(i != dist.length-1 && tc != (int)tc)
            {
                tc = (int)tc+1;
            }

            time += tc;
        }

        return (time <= hour);
    }

}
