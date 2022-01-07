package com.siesta.hodgepodge.es.incr;

import com.siesta.hodgepodge.es.EsClient;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EsConsumer {
    private final Lock lock = new ReentrantLock();
    private final BlockingQueue<List<IndexRequest>> requestQueue = new ArrayBlockingQueue<>(10);

    public boolean consume() {


        return true;
    }

    private void bulk() {
        lock.lock();
        try {
            List<IndexRequest> indexRequests = requestQueue.take();
            BulkRequest bulkRequest = new BulkRequest();
            RestHighLevelClient client = EsClient.getRestHighLevelClient();
            for (int i = 1; i <= indexRequests.size(); i++) {
                bulkRequest.add(indexRequests.get(0));
                if (i % 100 == 0) {
                    client.bulk(bulkRequest, RequestOptions.DEFAULT);
                    bulkRequest = new BulkRequest();
                }
            }
            client.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
