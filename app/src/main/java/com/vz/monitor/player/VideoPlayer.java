package com.vz.monitor.player;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

//import com.vz.monitor.ui.RealtimePlayActivity;


import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;

import android.util.Log;

public class VideoPlayer implements Renderer
{

    public static final int TYPE_RGB_565 = 1;
    public static final int TYPE_YUV_420SP = 2;

    private GLImage image = null;
    private boolean isPlay = false;

    private FrameQueue frameQueue;
    private Handler handler;
    private boolean isInit = false;

    private GLSurfaceView view;

    //private FontImage fontImage = null;

    private DrawThread drawThread = null;

    private Frame frame = new Frame();
    private ByteBuffer drawData = null;
    private static int num = 1;

    public VideoPlayer(GLSurfaceView view)
    {
        this.view = view;

        //	fontImage = new FontImage();

        //drawThread = new DrawThread();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        // Set the background frame color
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);


    }


    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height)
    {

        GLES20.glViewport(0, 0, width, height);


    }


    @Override
    public void onDrawFrame(GL10 gl)
    {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

        if (null != image && isPlay)
        {
            image.draw();
        }
        else
        {

            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);//| GLES20.GL_DEPTH_BUFFER_BIT);

//			fontImage.init();
//			fontImage.setFont("����ͼ");
//			
//			fontImage.draw();
        }
    }


    public boolean init(int type, int width, int height)
    {
        if (image == null)
        {
            image = null;

            switch (type)
            {
                case TYPE_RGB_565:
                    image = new RGB565Image();
                    break;
                case TYPE_YUV_420SP:
                    image = new YUV420Image();
                    break;
            }
        }


        if (null != image)
        {
            image.setResolution(width, height);
            image.init();

            return true;
        }

        return false;
    }

    public void start()
    {
        isPlay = true;
//		Thread t = new Thread(new DataObtainer());
//		t.start();
        //new DrawThread().start();
        drawThread = new DrawThread();
        drawThread.start();
    }

    public void stop()
    {

//		try
//		{
//			drawThread.notify();
//		}
//		catch (IllegalMonitorStateException  e)
//		{
//			
//		}


        isPlay = false;
        try
        {
            drawThread.join(1000);

        }
        catch (InterruptedException e)
        {

        }
        //	drawThread.stop();

        drawThread = null;
        //image = null;
        //isInit = false;
        view.requestRender();
//		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
//		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }

    public void pause()
    {
        if (drawThread.isAlive())
        {
            try
            {
                drawThread.wait();

            }
            catch (InterruptedException e)
            {

            }
        }
    }

    public void resum()
    {
        if (drawThread.isAlive())
            drawThread.notify();
    }

    public void setFrameQueue(FrameQueue frameQueue)
    {
        this.frameQueue = frameQueue;
    }

    public void setHandler(Handler handler)
    {
        this.handler = handler;

    }

    private long lastRecordTime = 0L;

    private synchronized void draw()
    {


        try
        {
            // TODO test
            long l = System.currentTimeMillis();
            if (lastRecordTime == 0)
            {
                lastRecordTime = l;
            }
            else
            {
                if (l - lastRecordTime >= 1000)
                {
//                    Log.i("debug", "Video Player��Ƶ��ʾ�Ķ���֡��:" + frameQueue.size());
                    lastRecordTime = l;
                }
            }

            //Frame
            frame = frameQueue.getFrameFromQueue();

            if (frame != null)
            {
                MediaInfo mi = frame.getMediaInfo();
                //frame.getMediaInfo(mi);
                int width = mi.getWidth();
                int height = mi.getHeight();
                int imageWidth = 0;
                int imageHeight = 0;
                if (null != image)
                {
                    imageWidth = image.getWidth();
                    imageHeight = image.getHeight();
                }

                byte[] data = frame.getData();
                if (null == image || imageWidth != width || imageHeight != height)
                {
                    int initType = TYPE_YUV_420SP;

                    isInit = init(initType, width, height);

                }


                if (null != data && data.length > 0 && null != image)
                {
                    image.put(data);//���ϵĸ�����
                    view.requestRender();//���ϵ���������
                }


            }
        }
        catch (Exception e)
        {
            int a;
            a = 0;
        }
    }

    private class DataObtainer implements Runnable
    {
        @Override
        public void run()
        {
            while (isPlay)
            {
                draw();

            }
            frameQueue.clear();
        }
    }

    private class DrawThread extends Thread
    {
        @Override
        public void run()
        {
            super.run();
            while (isPlay)
            {
                try
                {
                    draw();
                    Thread.sleep(30);
                }
                catch (Exception e)
                {

                }

            }
            frameQueue.clear();
        }
    }

    public boolean snapshot(String path)
    {
        if (null != image)
        {
            return image.saveToJpeg(path);
        }
        return false;
    }

    void saveImage(byte[] disData, final int Width, final int Height)
    {
        YuvImage image = new YuvImage(disData, ImageFormat.NV21, Width, Height, null);

        if (image != null)
        {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            image.compressToJpeg(new Rect(0, 0, Width, Height), 80, stream);
            //Bitmap bmp = BitmapFactory.decodeByteArray(stream.toByteArray(), 0, stream.size());
            Bitmap bmp = BitmapFactory.decodeByteArray(stream.toByteArray(), 0, stream.size());

            try
            {
                stream.close();
            }
            catch (IOException e)
            {

            }

            String title = "display" + num + ".png";

            num++;

            Log.e("tag", "����ͼƬ");
            File f = new File("/sdcard/namecard/", title);
            if (f.exists())
            {
                f.delete();
            }
            try
            {
                FileOutputStream out = new FileOutputStream(f);
                bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
                out.flush();
                out.close();
                Log.i("tag", "�Ѿ�����");
            }
            catch (FileNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}



