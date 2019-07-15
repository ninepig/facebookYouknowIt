package Array;

/**
 * Created by yangw on 2019/7/13.
 */
public class findCelebrity {
    public int findCeleberity(int n){
        if(n == 0) return -1;
        int candidate = 0;
        for (int i = 1 ; i < n ; i++){
            //if candidate konow i ,set i to candidate
            if (knows(candidate,i)){
                candidate = i;
            }
        }
        for (int i = 0 ; i<n;i++){
            //if candidate know anyone or anyone don't know candidate
            if (candidate!=i&&(knows(candidate,i))||!knows(i,candidate)){
                return -1;
            }
        }
        return candidate;
    }

    public boolean knows(int a, int b){
        return  true;
    }
}
