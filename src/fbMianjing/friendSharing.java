package fbMianjing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yangw on 2019/7/17.
 */
public class friendSharing {
    public int[] shareFriend(int[] nums1, int[] nums2) {

        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        //create int[] for res
        return new int[];
    }

    public class Person {
        int id;
        HashSet<Integer> friends = new HashSet<>();
    }

    private List<Integer> friendsRecommend(Person person, int k) {
        List<Integer> res = new ArrayList<>();
        if (person == null) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int friend : person.friends) {
            for (int recommend : friend.friends) {
                int id = recommend.id;
                if (person.friends.contains(id) || id == person.id) {
                    continue;//if person already has this friend,or this is person himself/herself,continue
                }
                if (!map.containsKey(id)) {//we use hashmap because if friend a has friend c, friend b has friend c
                    map.put(id, 0);
                }
                map.put(id, map.get(id) + 1);
            }
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= map.values().size(); i++) {
            buckets.add(new ArrayList<Integer>());//we use frequency as index, so <= length
        }
        for (int key : map.keySet()) {//unlike heap solution, we only need keySet() here
            buckets.get(map.get(key)).add(key);//get the id(key), add the id to its frequency bucket
        }
        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (int j = 0; j < buckets.get(i).size(); j++) {//start adding the vals at the last bucket's last index
                res.add(buckets.get(i).get(j));
                if (res.size() == k) {
                    return res;//this two loops are O(k) time, when res has k nums, return it
                }
            }
        }
        return res;
    }
}
