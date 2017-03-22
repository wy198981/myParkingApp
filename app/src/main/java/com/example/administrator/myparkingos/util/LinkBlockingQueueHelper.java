package com.example.administrator.myparkingos.util;

import com.example.administrator.myparkingos.model.ModelNode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2017-03-09.
 */
public class LinkBlockingQueueHelper
{
    private static volatile LinkBlockingQueueHelper linkBlockingQueueHelper = null;

    private BlockingQueue<ModelNode> container = new LinkedBlockingQueue<ModelNode>();
    private LinkBlockingQueueHelper()
    {

    }

    public static LinkBlockingQueueHelper getInstance()
    {
        if (linkBlockingQueueHelper == null)
        {
            synchronized (LinkBlockingQueueHelper.class)
            {
                if (linkBlockingQueueHelper == null)
                {
                    linkBlockingQueueHelper = new LinkBlockingQueueHelper();
                }
            }
        }
        return linkBlockingQueueHelper;
    }

    public void put(ModelNode node)
    {
        try
        {
            container.put(node);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public ModelNode get()
    {
        try
        {
            return container.take();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
