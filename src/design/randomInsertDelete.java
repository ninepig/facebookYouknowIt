package design;

import java.util.*;

/**
 * Created by yangw on 2019/7/
 * 用hashmap 来保存 val 和 list中位置的 key pair
 * remove的时候把这个值找出来 和最后一个值交换，更新最后一个值的位置。删除最后一个值
 */
public class randomInsertDelete {
    HashMap<Integer,Integer> helperMap;
    ArrayList<Integer> helpList;
    Random random;

    public randomInsertDelete(){
        helperMap = new HashMap<>();
        helpList = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val){
        if (helperMap.containsKey(val))return false;
        helperMap.put(val,helpList.size());
        helpList.add(val);
        return true;
    }

    public boolean remove(int val){
        if (!helperMap.containsKey(val))return false;
        int location = helperMap.get(val);
        if (location < helpList.size() - 1){
            int lastValue = helpList.get(helpList.size() - 1);
            helpList.set(location, lastValue);
            helperMap.put(lastValue,location);
        }
        helpList.remove(helpList.size() - 1);
        helperMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        // 返回 0---n 之间的某个数
        return helpList.get(random.nextInt(helpList.size()));
    }


    //381 duplicated 难啊
    class RandomizedCollection {

        HashMap<Integer,Set<Integer>> locMap;
        ArrayList<Integer> nums;
        Random random;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            locMap = new HashMap<>();
            nums = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(!locMap.containsKey(val)){
                locMap.put(val,new HashSet<>());
            }
            locMap.get(val).add(nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!locMap.containsKey(val)){
                return false;
            }
            //get the location of val
            int location = locMap.get(val).iterator().next();
            //remove this location in set
            locMap.get(val).remove(location);

            if(location<nums.size()-1){
                //if val is not the last one,replace the targetone with lastOne,and change the location in map
                int lastOne = nums.get(nums.size()-1);
                nums.set(location,lastOne);
                //remove the orignal postion,add the new location
                locMap.get(lastOne).remove(nums.size()-1);
                locMap.get(lastOne).add(location);
            }
            nums.remove(nums.size()-1);
            if(locMap.get(val).isEmpty()){
                locMap.remove(val);
            }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
