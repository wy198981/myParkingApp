package com.vz.monitor.player;

import android.annotation.SuppressLint;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.media.MP4Recorder;
import com.media.RTSP;
import com.media.RTSP.OnDataReceiver;
//import com.example.vzt.RealTimeActivity;
import java.util.Arrays;


public class DataService implements OnDataReceiver
{
    private FrameQueue frameQueue;
    private RTSP rtsp;
    private MP4Recorder mp4Recorder;
    private String ip;
    //	private String url = "rtsp://182.92.79.136:8554/slamtv60.264";
//	private String url = "rtsp://VisionZenith:147258369@192.168.1.100:8557/h264";
//	private String url  = "rtsp://218.204.223.237:554/live/1/66251FC11353191F/e7ooqwcfbqjoo80j.sdp";
//	private String url = "rtsp://192.168.3.30:8557/h264";
//	private String url = "rtsp://admin:12345@192.168.3.79:554/Streaming/Channels/1?transportmode=unicast&profile=Profile_1";
    private boolean isReceive = false; //閺勵垰鎯侀幒銉︽暪閺佺増宓?
    private boolean isRecording = false; //閺勵垰鎯佸锝呮躬瑜版洖鍩?

    private long lastTime = System.currentTimeMillis();

    /*
     * 閻€劋绨拋锛勭暬閻焦绁﹂柅鐔哄芳閻ㄥ嫪绗佹稉顏勫綁闁插骏绱?.閻胶宸?2.瀵拷顫愰弮鍫曟？ 3.閹恒儲鏁归弫鐗堝祦閹鏆辨惔锟?	 */
    private float dataRate = 0.0f;
    private long startTime = 0L;
    private int totalLength = 0;
    private int handle = -1;
    private Frame innerFrame = null;

    private byte[] recvData = null;

    private CheckDataThread checkThread = null;

    private static int y = 0;

    public DataService(FrameQueue frameQueue)
    {
        this.frameQueue = frameQueue;

        innerFrame = new Frame();

    }

    private Handler handler = null;
    public void setHandler(Handler handler)
    {
        this.handler = handler;
    }

    public void setUrl(String ip)
    {
        this.ip = ip;
    }

    private final int MSG_LONG_TIME_NO_DATA = 0X01;
    // TODO handler 原来的重新创建
    @SuppressLint("HandlerLeak")
    private Handler localHandler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case MSG_LONG_TIME_NO_DATA:
                {
                    Log.i("debug", "name:" + Thread.currentThread().getName());// 在这里建立重连 //TODO 重连处理
                    stop();
                    start();
                    break;
                }
                default:
                    break;
            }
        }
    };


    public boolean start()
    {
        if (null == rtsp)
        {
            rtsp = RTSP.getInstance();
        }
        if (!"".equals(ip))
        {
            handle = rtsp.startPlay(ip, 8557);
//            Log.i("debug", "return rtsp.startPlay(ip, 8557):" + handle);

            if (handle == -1)
                return false;
            rtsp.setOnDataReceiver(handle, this); // 接收数据


            isReceive = true;
            lastTime = System.currentTimeMillis();
            checkThread = new CheckDataThread();
            checkThread.start();
            //new CheckDataThread().start();
            return isReceive;
        }
        return false;
    }

    public void stop()
    {
        isReceive = false;
        if (null != rtsp)
        {
            if (handle == -1)
                return;
            rtsp.stopPlay(handle);
            rtsp = null;
        }

        try
        {
            checkThread.join(1000);
            checkThread = null;
        }
        catch (InterruptedException e)
        {

        }

    }

    public boolean startRecord(String fileName)
    {
        if (null == mp4Recorder)
        {
            mp4Recorder = new MP4Recorder();
        }
        isRecording = mp4Recorder.startRecorder(fileName);
        return isRecording;
    }

    public void stopRecord()
    {
        isRecording = false;
        if (null != mp4Recorder)
        {
            mp4Recorder.stopRecorder();
        }
    }

    private long lastRecordTime = 0L; //

    private void addToFrameQueue(Frame frame)
    {
        try
        {
            int size = frameQueue.size();
            if (size > 40)
            {
                if (frame.isKey())
                {
                    //frameQueue.getFrameFromQueue();
                    frameQueue.clear();
                }
            }
            if (size > 100)
            {
                frameQueue.clear();
            }
            frameQueue.addFrameToQueue(frame);
        }
        catch (Exception e)
        {
            Log.i("error", "addToFrameQueue faile");
        }

        // TODO 测试rtsp拉流数据帧的变化 最多100帧
        long l = System.currentTimeMillis();
        if (lastRecordTime == 0)
        {
            lastRecordTime = l;
        }
        else
        {
            if (l - lastRecordTime >= 1000)
            {
//                Log.i("debug", "Data Service count:" + frameQueue.size() + ", ip:" + ip);
                lastRecordTime = l;
            }
        }
    }


    @Override
    public void onDataReceive(byte[] data, int length, int width, int height, int fps, int codectype)
    {
        //Log.i( "onDataReceive","start:"+String.valueOf(data.length)+" :codectype:"+codectype);


//		if(y > 50)
//		{
//			System.gc();
//			y=0;
//		}
//		y++;

        //  return;

        lastTime = System.currentTimeMillis();
        if (isReceive && null != data)
        {
            if (null != mp4Recorder && isRecording)
            {
                mp4Recorder.addSample(data, length, MP4Recorder.TYPE_VIDEO);
            }
            countDataRate(length);

            Frame frame = new Frame();
            frame.setKey(true);// 直接设置true？？？
//			if(length >= 5) {
//				byte mark = data[4];
//				if(mark==0x65 || mark==0x25 || mark==0x67 || mark==0x27 || mark==0x68 || mark==0x28) {
//					frame.setKey(true);
//				}
//			}
            //byte [] tempData = Arrays.copyOf(data, data.length);

            //	if( ( recvData == null ) || recvData.length < length )
            //	{
            //	byte [] tempData = new byte[length];

            //}
            //	System.arraycopy(data, 0, tempData, 0, length);

            frame.setType(Frame.TYPE_VIDEO); //这里直接设置video，那么对于视频数据，是没有做处理的;
            frame.setData(data);
            frame.setLength(length);
            //		frame.setTimestamp(timestamp);
            //		frame.setDate(date);
            frame.setDataRate(dataRate);

            MediaInfo mediaInfo = new MediaInfo();
//			mediaInfo.setWidth(width);
//			mediaInfo.setHeight(height);
//			mediaInfo.setFrameRate(fps);
            frame.setMediaInfo(mediaInfo);

            if (codectype == 1)
                frame.setCodecType(Codec.CODEC_H264);
            else
                frame.setCodecType(Codec.CODEC_JPEG);

            //	frameQueue.addFrameToQueue(innerFrame);
            addToFrameQueue(frame);
        }

        //Log.i("error", "onDataReceive end");
    }

    private class CheckDataThread extends Thread
    {
        @Override
        public void run()
        {
            super.run();
            while (isReceive)
            {
//                Log.i("debug", "间隔时间："+ (System.currentTimeMillis() - lastTime));
                if (System.currentTimeMillis() - lastTime > 5 * 1000)// TODO 修改
                {
                    isReceive = false;
                    localHandler.sendEmptyMessage(MSG_LONG_TIME_NO_DATA);
//                    handler.sendEmptyMessage(VedioSetVeiw.LONG_TIME_NO_DATA); //需要重连
                }
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                }
            }
        }
    }

    /**
     * 鐠侊紕鐣婚惍浣圭ウ闁喓宸?
     *
     * @param length 閺佺増宓侀梹鍨
     */
    private void countDataRate(int length)
    {
        totalLength += length;
        if (startTime == 0)
        {
            startTime = System.currentTimeMillis();
        }
        else
        {
            long nowTime = System.currentTimeMillis();
            long diffTime = nowTime - startTime;
            if (diffTime > 1000)
            {
                dataRate = (float) (totalLength * 1000.0 / diffTime / 1024 * 8);
                totalLength = 0;
                startTime = nowTime;
            }
        }
    }
}
