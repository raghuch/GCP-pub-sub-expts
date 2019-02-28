package com.example.pubsub;

import com.google.cloud.ServiceOptions;
import com.google.pubsub.v1.PubsubMessage;

import java.util.concurrent.*;

class NewSubscriberRunnable implements Runnable {
    private String subscriptionID;
    private String threadNum;
    NewSubscriberRunnable(String subscriptionID, String threadNum) {
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

public class PubSubSubscriberMultiThreaded {

    public static void main(String... args) {
        String subscriptionID = args[0];
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));

        ExecutorService executor = Executors.newFixedThreadPool(20);
        for(int i = 0; i < 20; i++) {
            String threadNum = "thread_"+ i;
            Runnable subscriberWorker = new NewSubscriberRunnable(subscriptionID, threadNum);
            executor.execute(subscriberWorker);
        }
        executor.shutdown();
        //Waiting till all threads have finished
        while(!executor.isTerminated()){
        }
        System.out.println("All the Threads have finished!");
    }

}
