package sassy.com.cupidknot.extras;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Nikhil-Pc on 26-Dec-16.
 */

public class NotificationID {
    private final static AtomicInteger c = new AtomicInteger(0);

    public static int getID() {
        return c.incrementAndGet();
    }
}
