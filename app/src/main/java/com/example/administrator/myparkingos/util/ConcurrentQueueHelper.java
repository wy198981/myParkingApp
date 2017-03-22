package com.example.administrator.myparkingos.util;

import com.example.administrator.myparkingos.model.ModelNode;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2017-03-09.
 */
public class ConcurrentQueueHelper
{
    private static volatile ConcurrentQueueHelper concurrentQueueHelper = null;

    private ConcurrentLinkedQueue<ModelNode> container = new ConcurrentLinkedQueue<ModelNode>();

    private ConcurrentQueueHelper()
    {

    }

    public static ConcurrentQueueHelper getInstance()
    {
        if (concurrentQueueHelper == null)
        {
            synchronized (ConcurrentQueueHelper.class)
            {
                if (concurrentQueueHelper == null)
                {
                    concurrentQueueHelper = new ConcurrentQueueHelper();
                }
            }
        }
        return concurrentQueueHelper;
    }

    public void put(ModelNode node)
    {
        container.offer(node);
    }

    public ModelNode get()
    {
        return container.poll();
    }
}
