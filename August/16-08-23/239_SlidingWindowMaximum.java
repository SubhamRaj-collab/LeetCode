class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int res[] = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();
        // Only useful elements are added in ArrayDeque, i.e., only elements are added that are less than the last element of the Array Deque, if the element in the Deque is less than the current element than it will be thrown out. This will make the deque always resemble an array in descending order.

        for(int i = 0; i < n; i++)
        {
            if(i >= k && dq.peekFirst() == nums[i-k])
            {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && dq.peekLast() < nums[i])
            {
                dq.pollLast();
            }

            dq.offerLast(nums[i]);

            if(i-k+1 >= 0)
            {
                res[i-k+1] = dq.peekFirst();
            }

        }

        return res;

        // ArrayDeque take constant time to offer and poll.
        // One linear time for looping, and one linear time to poll all elements, in worst case.
        // So, Time complexity for worst case will be as follows - 
        // O(2*n) ^

        // int n = nums.length;
        // int nextGre[] = new int[n];
        // Stack<Integer> st = new Stack<>();

        // nextGre[n-1] = n;
        // st.push(n-1);

        // for(int i = n-2; i >= 0; i--)
        // {
        //     while(!st.isEmpty() && nums[st.peek()] < nums[i])
        //     {
        //         st.pop();
        //     }

        //     if(st.isEmpty())
        //     {
        //         nextGre[i] = n;
        //     }
        //     else
        //     {
        //         nextGre[i] = st.peek();
        //     }

        //     st.push(nums[i]);

        // }

        // int res[] = new int[n-k+1];
        // int j = 0;
        // for(int i = 0; i < n-k+1; i++)
        // {
        //     if(j < i)j = i;

        //     while(nextGre[j] < i+k)
        //     {
        //         j = nextGre[j];
        //     }

        //     res[i] = nums[j];
        // }

        // return res;

        //O(4*n) ^

        //O(n((log(n))^3)) \/
        
        // int n = nums.length;
        // int res[] = new int[n-k+1];

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Map<Integer, Integer> map = new HashMap<>();

        // for(int i = 0; i < n; i++)
        // {
        //     pq.offer(nums[i]);
        //     map.put(nums[i], i);
        //     if(i >= k-1)
        //     {
        //         int item = pq.peek();

        //         while(map.get(item) < i-k+1)
        //         {
        //             pq.poll();
        //             item = pq.peek();
        //         }

        //         res[i-k+1] = item;
        //     }
        // }

        // return res;

    }