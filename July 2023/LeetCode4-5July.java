//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
//LeetCode 04

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // int m = nums1.length;
        // int n = nums2.length;

        // List<Integer> list = new ArrayList<>();

        // for(int i = 0; i < m; i++)
        // {
        //     list.add(nums1[i]);
        // }

        // for(int j = 0; j < n; j++)
        // {
        //     list.add(nums2[j]);
        // }

        // if(list.size() == 1)return (double)list.get(0);

        // Collections.sort(list);

        // int start = 0;
        // int end = list.size()-1;

        // if((list.size()&1)==1)
        // {
        //     return (double)list.get(start+(end-start)/2);
        // }
        // else
        // {
        //     int mid = start+(end-start)/2;
        //     return (double)(list.get(mid)+list.get(mid+1))/2;
        // }

        //It gets accepted but we have to do it in TC-log(m+n)

        //TC: O(Max(m, n)+O((m+n)log(m+n)))
        //SC: O(m+n)

        // int m = nums1.length;
        // int n = nums2.length;

        // int arr[] = new int[m+n];
        // int i = 0;
        // int j = 0;
        // int k = 0;

        // while(i < m && j < n)
        // {
        //     if(nums1[i] < nums2[j])
        //     {
        //         arr[k++] = nums1[i++];
        //     }
        //     else
        //     {
        //         arr[k++] = nums2[j++];
        //     }
        // }

        // while(i < m)
        // {
        //     arr[k++] = nums1[i++];
        // }

        // while(j < n)
        // {
        //     arr[k++] = nums2[j++];
        // }

        // if(((m+n)&1)==1)
        // {
        //     return (double)arr[(m+n)/2];
        // }
        // else
        // {
        //     return (double)(arr[(m+n-1)/2]+arr[(m+n-1)/2 + 1])/2;
        // }

        // //TC: O(m+n)
        // //SC: O(m+n)

        // int m = nums1.length;
        // int n = nums2.length;

        // int i = 0;
        // int j = 0;
        // int mid1 = 0;
        // int mid2 = 0;

        // if(((m+n)&1)==1)
        // {
        //     mid1 = (m+n-1)/2;
        //     mid2 = (m+n-1)/2;
        // }
        // else
        // {
        //     mid1 = (m+n-1)/2;
        //     mid2 = (m+n-1)/2+1;
        // }

        // int count = 0;
        // int num1 = 0;
        // int num2 = 0;
        // int num = 0;

        // while(i < m && j < n)
        // {
        //     if(nums1[i] < nums2[j])
        //     {   
        //         num = nums1[i];
        //         i++;
        //     }   
        //     else
        //     {
        //         num = nums2[j];
        //         j++;
        //     }

        //     if(count == mid1)
        //     {
        //         num1 = num;
        //     }
        //     if(count == mid2)
        //     {
        //         num2 = num;
        //     }
        //     count++;
        // }

        // while(i < m)
        // {
        //     num = nums1[i];
        //     i++;
        //     if(count == mid1)
        //     {
        //         num1 = num;
        //     }
        //     if(count == mid2)
        //     {
        //         num2 = num;
        //     }
        //     count++;
        // }

        // while(j < n)
        // {
        //     num = nums2[j];
        //     j++;
        //     if(count == mid1)
        //     {
        //         num1 = num;
        //     }
        //     if(count == mid2)
        //     {
        //         num2 = num;
        //     }
        //     count++;
        // }

        // return (double)(num1+num2)/2;

        // //TC: O(m+n)
        // //SC: O(1)

        int m = nums1.length;
        int n = nums2.length;

        //As we are cutting on array1, so that the first array must be the smaller one.
        //Also, it will give error, if we iterate on the longer array.

        // If the first array is large, then while doing binary search we may come across a case where the place of the partition is not suitable, then also if we try to find the rest half number of elements in the 2nd Array and the length of the second array, itself is smaller then the number of elements that we are trying to pick up from 2nd Array, then it will cross the last index or may go below the 0th index, which may give arror.
        //So, the first array must be the smaller one, because however numbers it may require from the 1st array, they are present there, and will not go out of range.

        //example: [1,2,3,5,6], [4] ;
        //          [4,5,6,8,9], [] ;
        //          [2], []
        
        if(m > n)
        {
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0;
        int end = m;
        int half = (m+n+1)/2;
        boolean odd = false;

        if(((m+n)&1) == 1)
        {
            odd = true;
        }

        // 1 2 3 | 8 9
        // 4 5 | 6 10 12

        // 3 must be smaller than 6, and 5 must be smaller than 8.
        // so that numbers in left side of the group is always smaller than numbers of right side.

        //First array is num1 and second array is num2 and 2 groups are made where each group has equal number of elements or the first group has one extra element than second group.
        // Hence, we are performing binary search on the first array which is smaller in size than the second array.

        while(start <= end)
        {
            int mid = start+(end-start)/2;

            int l1 = mid==0?Integer.MIN_VALUE:nums1[mid-1];
            int r1 = mid==m?Integer.MAX_VALUE:nums1[mid];
            int l2 = half-mid==0?Integer.MIN_VALUE:nums2[half-mid-1];
            int r2 = half-mid==n?Integer.MAX_VALUE:nums2[half-mid];

            if(l1 <= r2 && l2 <= r1)
            {
                if(odd)return (double)Math.max(l1, l2);
                else return (double)(Math.max(l1, l2)+Math.min(r1, r2))/2.0;
            }
            else if(l1 <= r2 && l2 > r1)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }

        return 0.0;

        // TC: O(log(min(m+n)))
        // SC: O(1)

    }
}