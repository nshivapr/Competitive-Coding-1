/* Problem #11 : Find Missing Number in a sorted array
Time Complexity: O(log n) using Binary search
Space Complexity: O(1)
Algorithm: if the difference between the element and the index of low and mid are same, then there is not missing number
in left half of array
GFG Question: https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
*/

import java.io.*;

class GFG {
    public static int search(int[] a, int size){
        int low = 0, high = size-1;
        int mid = 0;
        while(high-low >= 2){
            mid = low + (high-low)/2; //to prevent integer Overflow
            int mid_diff = a[mid] - mid;
            int low_diff = a[low] - low;
            if(mid_diff != low_diff)
                high = mid;
            else
                low = mid;
        }
        return (a[low]+a[high])/2;
    }
    public static void main (String[] args) {
        int ar[] = { 3, 4, 5, 7, 8 };
        int size = ar.length;
        System.out.println("Missing number: " + search(ar, size));
    }
}