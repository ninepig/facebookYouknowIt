package design;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by yangw on 2019/7/11.
 */
public class logger {
    class TimedMessage {
        public int timestamp;
        public String message;

        public TimedMessage(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }

    Queue<TimedMessage> queue;
    Set<String> messages;

    /** Initialize your data structure here. */
    public logger() {
        queue = new ArrayDeque<>();
        messages = new HashSet<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!queue.isEmpty() && queue.peek().timestamp <= timestamp - 10) {
            String msg = queue.remove().message;
            messages.remove(msg);
        }
        if(messages.contains(message)) {
            return false;
        } else {
            queue.offer(new TimedMessage(timestamp, message));
            messages.add(message);
            return true;
        }
    }
}
