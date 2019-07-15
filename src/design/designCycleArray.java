package design;

/**
 * Created by yangw on 2019/7/11.
 * 2个pointer 一个size 来做
 * 对于插入
 *      front 就只会插在头上，如果一开始没有，就从尾部开始插入 （特殊情况），或者就是font - 1
 *      last 只能查末尾，也就是rear + 1
 * 对于删除 一样。 作弊作弊
 */
public class designCycleArray {
//    private final int[] ary;
//    private int size;
//    private int front;
//    private int rear;
//
//    /** Initialize your data structure here. Set the size of the deque to be k. */
//    public designCycleArray(int k) {
//        ary = new int[k];
//        size = 0;
//        front = 0;
//        rear = 0;
//    }
//
//    /** Adds an item at the front of Deque. Return true if the operation is successful. */
//    public boolean insertFront(int value) {
//        if(isFull()) {
//            return false;
//        }
//        front = front == 0 ? ary.length - 1 : front - 1;
//        ary[front] = value;
//        size++;
//        return true;
//    }
//
//    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
//    public boolean insertLast(int value) {
//        if(isFull()) {
//            return false;
//        }
//        ary[rear] = value;
//        rear = (rear + 1) % ary.length;
//        size++;
//        return true;
//    }
//
//    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
//    public boolean deleteFront() {
//        if(isEmpty()) {
//            return false;
//        }
//        front = (front + 1) % ary.length;
//        size--;
//        return true;
//    }
//
//    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
//    public boolean deleteLast() {
//        if(isEmpty()) {
//            return false;
//        }
//        rear = rear == 0 ? ary.length - 1 : rear - 1;
//        size--;
//        return true;
//    }
//
//    /** Get the front item from the deque. */
//    public int getFront() {
//        if(isEmpty()) {
//            return -1;
//        }
//        return ary[front];
//    }
//
//    /** Get the last item from the deque. */
//    public int getRear() {
//        if(isEmpty()) {
//            return -1;
//        }
//        return ary[rear == 0 ? ary.length - 1 : rear - 1];
//    }
//
//    /** Checks whether the circular deque is empty or not. */
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    /** Checks whether the circular deque is full or not. */
//    public boolean isFull() {
//        return size == ary.length;
//    }

    int[] queue;
    int size;
    int front;
    int rear;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public designCycleArray(int k) {
        queue = new int[k];
        size = 0;
        front = 0;
        rear = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        // 因为是插在前面 所以要避免覆盖，所以要先确定好坐标
        front = front == 0 ? queue.length - 1 : front - 1;
        queue[front] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        //插在后面就不需要，直接往后怼即可
        queue[rear] =value;
        rear = (rear + 1) %  queue.length;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front  = (front + 1) &queue.length;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = rear == 0 ? queue.length - 1 : rear -1 ;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return queue[rear == 0 ? queue.length - 1 : rear - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;

    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }
}
