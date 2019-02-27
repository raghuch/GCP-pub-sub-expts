package com.example.pubsub;

import com.google.cloud.ServiceOptions;
import com.google.pubsub.v1.PubsubMessage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class SubscriberRunnable implements Runnable {
    private String subscriptionID;
    private String threadNum;
    SubscriberRunnable(String subscriptionID, String threadNum) {
        this.subscriptionID = subscriptionID;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        try {
            mySubscriber.main(subscriptionID, threadNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

public class SubscriberThreaded {
    private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
    private static final BlockingQueue<PubsubMessage> msgQueue = new LinkedBlockingDeque<>();
    //private String subscriptionID;

    public static void main(String... args) {
        String subscriptionID = args[0];

        Thread subscriberThread1 = new Thread(new SubscriberRunnable(subscriptionID, "thread1"), "Thread1");
        subscriberThread1.start();

        Thread subscriberThread2 = new Thread(new SubscriberRunnable(subscriptionID, "thread2"), "Thread2");
        subscriberThread2.start();

        Thread subscriberThread3 = new Thread(new SubscriberRunnable(subscriptionID, "thread3"), "Thread3");
        subscriberThread3.start();

        Thread subscriberThread4 = new Thread(new SubscriberRunnable(subscriptionID, "thread4"), "Thread4");
        subscriberThread4.start();

        Thread subscriberThread5 = new Thread(new SubscriberRunnable(subscriptionID, "thread5"), "Thread5");
        subscriberThread5.start();

        Thread subscriberThread6 = new Thread(new SubscriberRunnable(subscriptionID, "thread6"), "Thread6");
        subscriberThread6.start();

        Thread subscriberThread7 = new Thread(new SubscriberRunnable(subscriptionID, "thread7"), "Thread7");
        subscriberThread7.start();

        Thread subscriberThread8 = new Thread(new SubscriberRunnable(subscriptionID, "thread8"), "Thread8");
        subscriberThread8.start();

        Thread subscriberThread9 = new Thread(new SubscriberRunnable(subscriptionID, "thread9"), "Thread9");
        subscriberThread9.start();

        Thread subscriberThread10 = new Thread(new SubscriberRunnable(subscriptionID, "thread10"), "Thread10");
        subscriberThread10.start();


    }
}
