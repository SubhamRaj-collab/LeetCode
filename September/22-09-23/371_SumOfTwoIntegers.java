class Solution {
    public int getSum(int a, int b) {

        int s = a;
        int car = b;

        while(car != 0)
        {
            int temp = ((s&car)<<1);
            s = s^car;
            car = temp;
        }

        return s;

        // TC: O(1)
        
    }
}