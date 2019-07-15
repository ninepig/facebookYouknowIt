package binarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yangw on 2019/7/9.
 */
public class intersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return null;
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                arr.add(num);
                set.remove(num);
            }
        }
        int k = 0;
        int[] res = new int[arr.size()];
        for (int num : arr) {
            res[k++] = num;
        }
        return res;
    }
    public int[] intersectionWithBs(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        HashSet<Integer> set = new HashSet<>();//you can use ArrayList here as well
        Arrays.sort(nums1);
        for (int i : nums2) {
            if (!set.contains(i) && binarySearch(nums1, i)) {
                set.add(i);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i++] = num;//remember to i++ !!!
        }
        return res;
    }

    private boolean binarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {//remember to check whether a is null or empty !!!
            return false;
        }
        int start = 0;
        int end = a.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == target) {
                return true;
            } else if (a[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (a[start] == target || a[end] == target) {
            return true;
        }
        return false;
    }
}
