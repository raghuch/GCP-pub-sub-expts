package com.example.pubsub;

import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
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

    }
}
