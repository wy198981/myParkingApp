package com.vz.monitor.player;

import java.io.File;

import java.nio.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.media.AudioFormat;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import android.graphics.*;

import java.io.*;


import com.media.MediaConverter;


//import com.monitor.GlobalDefine;
//import com.vz.monitor.service.Callback;
//import com.vz.monitor.service.ConnectionManager;
//import com.example.vzvision.*;
//import com.vz.monitor.util.NumberUtil;


@SuppressWarnings("unused")
public class MediaPlayer extends GLSurfaceView
{  // implements Callback
    public static final int TYPE_INTERNET = 1;
    public static final int TYPE_FILE = 2;
    private static final String TAG = "MediaPlayer";

    private int dataSourceType = TYPE_INTERNET;

    private File file;

    private VideoPlayer videoPlayer;
    private DataService dataService;
    private DataDecoder dataDecoder;

    private Context context;
    private FrameQueue frameQueue = new FrameQueue();
    private FrameQueue videoDecodedQueue = new FrameQueue();
    private FrameQueue audioDecodedQueue = new FrameQueue();

    private boolean isVideoPlaying = false;
    private boolean isAudioPlaying = false;
    private boolean isRecording = false;
    private boolean isPause = false;

    private AudioPlayer audioPlayer;
    private int channel;
    private int encoding;
    private int sampleRateInHz;

    //private GlobalDefine gd;
    private String url = "";
    private String ip;
    private int port;

    private boolean isPtzStop = true;
    private int ptzType = -1;

    public int recvFrameTime = 0;
    public int recvPicTime = 0;

    public MediaPlayer(Context context, int dataSourceType)
    {
        super(context);
        this.context = context;
        this.dataSourceType = dataSourceType;

        this.setEGLContextClientVersion(2); // 使用open gl 2.0版本
        videoPlayer = new VideoPlayer(this);
        this.setRenderer(videoPlayer);
        this.setRenderMode(RENDERMODE_WHEN_DIRTY);
        //this.setOnTouchListener(new OnTouchListener());
        dataService = new DataService(frameQueue);
        dataDecoder = new DataDecoder();

        //	this.gd = (GlobalDefine) context.getApplicationContext();
    }

    public MediaPlayer(Context context, int dataSourceType, AttributeSet attrs)
    {
        super(context, attrs);

        this.context = context;
        this.dataSourceType = dataSourceType;

        this.setEGLContextClientVersion(2); // 使用open gl 2.0版本
        videoPlayer = new VideoPlayer(this);
        this.setRenderer(videoPlayer);
        this.setRenderMode(RENDERMODE_WHEN_DIRTY);
        //this.setOnTouchListener(new OnTouchListener());
        dataService = new DataService(frameQueue);

        dataDecoder = new DataDecoder();
    }

    public MediaPlayer(Context context)
    {
        this(context, TYPE_INTERNET);
    }

    public MediaPlayer(Context context, AttributeSet attrs)
    {
        // super(context, attrs);
        this(context, TYPE_INTERNET, attrs); // 因为要放在布局文件中，所以使用attrs属性
    }

//
//    public MediaPlayer(Context context)
//    {
//        this(context, TYPE_INTERNET);
//    }
//
//
//
//    public MediaPlayer(Context context, int dataSourceType)
//    {
//        super(context);
//        this.context = context;
//        this.dataSourceType = dataSourceType;
//
//        this.setEGLContextClientVersion(2);
//        videoPlayer = new VideoPlayer(this);
//        this.setRenderer(videoPlayer);
//        this.setRenderMode(RENDERMODE_WHEN_DIRTY);
//        //this.setOnTouchListener(new OnTouchListener());
//
//        dataService = new DataService(frameQueue);
//
//        dataDecoder = new DataDecoder();
//
//        //	this.gd = (GlobalDefine) context.getApplicationContext();
//    }
//
//    public MediaPlayer(Context context, AttributeSet attrs)
//    {
//        // super(context, attrs);
//        this(context, TYPE_INTERNET);
//    }

    protected void finalize() throws Throwable
    {
        if (this.isRecording())
        {
            this.stopRecord();
        }

        if (this.isAudioPlaying())
        {
            this.stopAudio();
        }

        if (this.isVideoPlaying())
        {
            this.stopPlay();
        }
    }

    public void setDataSourceType(int dataSourceType)
    {
        this.dataSourceType = dataSourceType;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public void setHandler(Handler handler)
    {
        this.handler = handler;
    }

    public void setUrlip(String ip)
    {
        this.ip = ip;
    }

    public String getUrlip()
    {
        return this.ip;
    }

    public boolean isVideoPlaying()
    {
        return isVideoPlaying;
    }

    public boolean isAudioPlaying()
    {
        return isAudioPlaying;
    }

    public boolean isRecording()
    {
        return isRecording;
    }

    public boolean isPause()
    {
        return isPause;
    }

    public void startPlay()
    {
        isVideoPlaying = true;
        isAudioPlaying = false;
        Log.i(TAG, "ip:" + ip);
        dataService.setUrl(ip);
        Log.i(TAG, "ip:" + ip);
        dataService.setHandler(handler);


        dataService.start();

        Log.i("mediaplayer", "dataService");

        dataDecoder.start();

        Log.i("mediaplayer", "dataDecoder");

        videoPlayer.setFrameQueue(videoDecodedQueue);
        videoPlayer.start();

        Log.i("mediaplayer", "videoPlayer");

        recvFrameTime = 0;
        recvPicTime = 0;
    }

    public void stopPlay()
    {
        this.isVideoPlaying = false;
        this.isAudioPlaying = false;

        if (null != dataService)
        {
            dataService.stop();
        }
        if (null != dataDecoder)
        {
            dataDecoder.stop();
        }
        if (null != videoPlayer)
        {
            videoPlayer.stop();
        }

        frameQueue.clear();
        videoDecodedQueue.clear();
        audioDecodedQueue.clear();
    }


    public void pause()
    {
        if (dataDecoder != null)
            dataDecoder.pause();
        if (videoPlayer != null)
            videoPlayer.pause();
    }

    public void resum()
    {
        if (dataDecoder != null)
            dataDecoder.resum();
        if (videoPlayer != null)
            videoPlayer.resum();
    }

    public boolean snapshot(String fileName)
    {
        if (null != videoPlayer)
        {
            return videoPlayer.snapshot(fileName);
        }
        return false;
    }

    public boolean startRecord(String fileName)
    {
        if (null != dataService)
        {
            isRecording = dataService.startRecord(fileName);
        }
        return isRecording;
    }

    public void stopRecord()
    {
        isRecording = false;
        dataService.stopRecord();
    }

    public static final int LONG_HAVE_NO_DATA = 0x01;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if (LONG_HAVE_NO_DATA == 0x01)
            {

            }
            super.handleMessage(msg);
        }
    };


    public void process()
    {
        if (ptzType != -1 && !isPtzStop)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
            }
            setPtz(ptzType, true);
            isPtzStop = true;
        }
    }

    private class OnTouchListener implements View.OnTouchListener
    {
        private static final int FINGER_NONE = 0;
        private static final int FINGER_ONE = 1;
        private static final int FINGER_TWO = 2;

        private static final int MODE_NONE = 0;
        private static final int MODE_DRAG = 1;
        private static final int MODE_ZOOM = 2;
        private static final int MODE_FOCUS = 3;

        private int finger = FINGER_NONE;
        private int mode = MODE_NONE;
        private PointF startPoint = new PointF();    //缁夎濮╅崜宥嗗閹稿洨鍋ｉ崙鑽ゆ畱閸ф劖鐖?
        private PointF midPoint = new PointF();    //缁夎濮╅崜宥嗗閹稿洨鍋ｉ崙鑽ゆ畱閸ф劖鐖?
        private float startDist = 0f;    //瀵拷顫愰弮鍓佹畱鐠烘繄顬?

        @SuppressLint("FloatMath")
        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
            switch (event.getAction() & MotionEvent.ACTION_MASK)
            {
                case MotionEvent.ACTION_DOWN:
                    finger = FINGER_ONE;
                    mode = MODE_DRAG;
                    startPoint.set(event.getX(), event.getY());
                    break;
                case MotionEvent.ACTION_UP:
                    finger = FINGER_NONE;
                    mode = MODE_NONE;
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    finger = FINGER_TWO;
                    startDist = distance(event);
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    finger = FINGER_ONE;
                    mode = MODE_NONE;
                    break;
                case MotionEvent.ACTION_MOVE:
                    int ptzType = PTZ.NONE;
                    if (finger == FINGER_ONE && mode == MODE_DRAG)
                    {
//					pztTime = System.currentTimeMillis();
                        float dx = event.getX() - startPoint.x;
                        float dy = event.getY() - startPoint.y;
                        int diret = 0;
                        if (dx < -35f)
                        { //閸氭垵褰?
                            ptzType = PTZ.RIGHT;
                        }
                        else if (dx > 35f)
                        { //閸氭垵涔?
                            ptzType = PTZ.LEFT;
                        }
                        else if (dy < -35f)
                        { //閸氭垳绗?
                            ptzType = PTZ.DOWN;
                        }
                        else if (dy > 35f)
                        { //閸氭垳绗?
                            ptzType = PTZ.UP;
                        }
                    }
                    else if (finger == FINGER_TWO)
                    {
                        float dist = distance(event);
                        if (Math.abs(dist - startDist) > 15f)
                        {
                            mode = MODE_ZOOM;
                        }
                        else
                        {
                            mode = MODE_FOCUS;
                        }
                        if (mode == MODE_ZOOM)
                        {
                            if (dist - startDist > 35f)
                            {
                                ptzType = PTZ.ZOOM_OUT;
                            }
                            else if (startDist - dist > 35f)
                            {
                                ptzType = PTZ.ZOOM_IN;
                            }
                        }
                        else if (mode == MODE_FOCUS)
                        {
                            float dx = event.getX() - startPoint.x;
                            float dy = event.getY() - startPoint.y;
                            if (Math.abs(dx) < 15.0f)
                            {
                                if (dy < -35f)
                                {
                                    ptzType = PTZ.FOCUS_IN;
                                }
                                else if (dy > 35f)
                                {
                                    ptzType = PTZ.FOCUS_OUT;
                                }
                            }
                        }
                    }
                    startPoint.set(event.getX(), event.getY());
                    if ((mode == MODE_DRAG || mode == MODE_ZOOM || mode == MODE_FOCUS) && ptzType > 0 && isPtzStop)
                    {
                        isPtzStop = false;
                        setPtz(ptzType, false);
//					process();
                    }
                    break;
            }
            return true;
        }

        /**
         * 鐠侊紕鐣绘稉銈囧仯娑斿澧犻惃鍕獩缁傦拷
         *
         * @param event
         * @return
         */
        @SuppressLint("FloatMath")
        private float distance(MotionEvent event)
        {
            float dx = event.getX(0) - event.getX(1);
            float dy = event.getY(0) - event.getY(1);
            return (float) Math.sqrt(dx * dx + dy * dy);
//            return FloatMath.sqrt(dx*dx + dy*dy);
        }

        private PointF midPoint(MotionEvent event)
        {
            float x = (event.getX(1) + event.getX(0)) / 2;
            float y = (event.getY(1) + event.getY(0)) / 2;
            return new PointF(x, y);
        }
    }

    private void sendPztCommand(final String command)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
//					ConnectionManager manager = ConnectionManager.getInstance();
//					manager.setServerInfo(gd.getServer().getIp(), gd.getServer().getPort());
//					boolean isLogin = gd.isLogin();
//					if(!isLogin) {
//						isLogin = manager.login(gd.getUserName(), gd.getPassword());
//						gd.setLogin(isLogin);
//					}
//					if(isLogin) {
//						manager.controlPtz(command);
//					}
                }
                catch (Exception e)
                {
                }
                process();
            }
        });
        thread.start();
    }

    private void setPtz(int type, boolean isStop)
    {
        int nLeft = 0, nUp = 0, nZoom = 0, nFoucs = 0, nIris = 0, nSpeedX = 0, nSpeedY = 0;
        if (isStop)
        {
            if (type == PTZ.LEFT)
            {
                nLeft = -1;
                nSpeedX = 7;
            }
            else if (type == PTZ.RIGHT)
            {
                nLeft = -1;
                nSpeedX = 7;
            }
            else if (type == PTZ.UP)
            {
                nUp = -1;
                nSpeedY = 7;
            }
            else if (type == PTZ.DOWN)
            {
                nUp = -1;
                nSpeedY = 7;
            }
            else if (type == PTZ.ZOOM_IN)
            {
                nZoom = -1;
            }
            else if (type == PTZ.ZOOM_OUT)
            {
                nZoom = -1;
            }
            else if (type == PTZ.FOCUS_IN)
            {
                nFoucs = -1;
            }
            else if (type == PTZ.FOCUS_OUT)
            {
                nFoucs = -1;
            }
            else if (type == PTZ.IRIS_IN)
            {
                nIris = -1;
            }
            else if (type == PTZ.IRIS_OUT)
            {
                nIris = -1;
            }
        }
        else
        {
            if (type == PTZ.LEFT)
            {
                nLeft = 2;
                nSpeedX = 7;
            }
            else if (type == PTZ.RIGHT)
            {
                nLeft = -2;
                nSpeedX = 7;
            }
            else if (type == PTZ.UP)
            {
                nUp = 2;
                nSpeedY = 7;
            }
            else if (type == PTZ.DOWN)
            {
                nUp = -2;
                nSpeedY = 7;
            }
            else if (type == PTZ.ZOOM_IN)
            {
                nZoom = 2;
            }
            else if (type == PTZ.ZOOM_OUT)
            {
                nZoom = -2;
            }
            else if (type == PTZ.FOCUS_IN)
            {
                nFoucs = 2;
            }
            else if (type == PTZ.FOCUS_OUT)
            {
                nFoucs = -2;
            }
            else if (type == PTZ.IRIS_IN)
            {
                nIris = 2;
            }
            else if (type == PTZ.IRIS_OUT)
            {
                nIris = -2;
            }
        }

        String s = String.format("%d:%d:%d:%d:%d:%d:%d", nLeft, nUp, nZoom, nFoucs, nIris, nSpeedX, nSpeedY);
        Log.i("Command", s);
        String pztCmd = new String(Base64.encode(s.getBytes(), Base64.DEFAULT));
        Log.i("Command", pztCmd);
        sendPztCommand(pztCmd);

        ptzType = type;
        if (isStop)
        {
            ptzType = PTZ.NONE;
        }
    }

    class PTZ
    {
        public static final int NONE = 0;
        public static final int LEFT = 1;
        public static final int RIGHT = 2;
        public static final int UP = 3;
        public static final int DOWN = 4;
        public static final int ZOOM_IN = 5;
        public static final int ZOOM_OUT = 6;
        public static final int FOCUS_IN = 7;
        public static final int FOCUS_OUT = 8;
        public static final int IRIS_IN = 9;
        public static final int IRIS_OUT = 10;
    }

    class DataDecoder
    {
        private boolean isFindKey = false; // 閺勵垰鎯侀幍鎯у煂閸忔娊鏁敮锟?
        private MediaInfo mediaInfo = null;

        private Codec codec = null;

        private boolean isDecode = false;

        private byte[] mPixel = null;
        private byte[] mAudio = null;

        private int isInitVideoDecode = 0;
        private int isInitAudioDecode = 0;
        private DecodeThread decodeThread = null;

        private MediaConverter converter = new MediaConverter();

        private Frame frame = new Frame();

        private ByteBuffer recvBuffer = null;

        public DataDecoder()
        {
            //	if( mPixel == null || width*height*3/2 > mPixel.length )
            mPixel = new byte[1920 * 1080 * 3 / 2];// 3 * 8 / 2 = 12


        }

        public void start()
        {
            Log.i("mediaplayer", "dataDecoder start start");
            isDecode = true;

            codec = new Codec();
            codec.setVideoCodecType(Codec.CODEC_H264);
            int result = codec.initVideoDecoder(0, 0);

            decodeThread = new DecodeThread();
            decodeThread.start();

            Log.i("mediaplayer", "dataDecoder start end");
        }

        public void stop()
        {
//			try
//			{
//				decodeThread.notify();
//			}
//			catch (IllegalMonitorStateException  e)
//			{
//				
//			}

            isDecode = false;

            isInitVideoDecode = 0;


//			mediaInfo = null;
            try
            {
                decodeThread.join(1000);

            }
            catch (InterruptedException e)
            {
                Log.i("mediaplayer", "close decodeThread fail");
            }


            decodeThread = null;

            codec.releaseVideoDecoder();
            //decodeThread.stop();
            //  mPixel = null;
        }

        public void pause()
        {
            if (decodeThread.isAlive())
            {
                try
                {
                    decodeThread.wait();

                }
                catch (InterruptedException e)
                {

                }
            }

        }

        public void resum()
        {
            if (decodeThread.isAlive())
            {
                decodeThread.notify();
            }
        }


        private class DecodeThread extends Thread
        {
            @Override
            public void run()
            {
                super.run();
                while (isDecode)
                {
                    try
                    {
                        if (isPause && dataSourceType == MediaPlayer.TYPE_FILE)
                        {
                            Thread.sleep(10);
                            continue;
                        }
                        decode();

                        Thread.sleep(30);
                    }
                    catch (Exception e)
                    {
                        int a;
                        a = 0;   //lkb

                        e.printStackTrace();
                    }
                }

            }
        }

        private long lastRecordTime = 0L;

        public void decode() throws Exception
        {
            int iTemp = 0;

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
//                    Log.i("debug", "Data Decoder rtsp 数据流队列帧数:" + frameQueue.size());
//                    Log.i("debug", "Data Decoder 解码之后放到视频队列中队列帧数:" + videoDecodedQueue.size());
                    lastRecordTime = l;
                }
            }

            Frame frame = frameQueue.getFrameFromQueue();

            if (frame == null)
            {//!frameQueue.getFrameFromQueue(frame)) {
                return;
            }
            recvFrameTime++;


            byte[] data = frame.getData();

            //frame.getData(recvBuffer );
            MediaInfo info = frame.getMediaInfo();
            if (null == info)
            {//|| recvBuffer == null || recvBuffer.position() == 0 ) {
                return;
            }
            if (Frame.TYPE_VIDEO == frame.getType())
            {

                int width = info.getWidth();
                int height = info.getHeight();

                if (!isFindKey)
                {
                    isFindKey = frame.isKey();
                }

                if (isFindKey)
                {
                    int baseTime = 1000 / info.getFrameRate(); //这里写死的25帧数据 40
                    long startTime = System.currentTimeMillis();
                    int[] wah = {0, 0};
                    //  Log.i("mediaplayer","dataDecoder decode begin");

                    // 解码数据的库
                    iTemp = decodeVideo(data, data.length, wah, frame.getCodecType());
                    //Log.i("mediaplayer","dataDecoder decode end");

                    long endTime = System.currentTimeMillis();
                    long sleepTime = (baseTime - 5) - (endTime - startTime);
                    if (sleepTime > 0)
                    {
                        Thread.sleep(sleepTime);
                    }

                    if (iTemp > 0)
                    {
                        //	byte [] tempData = Arrays.copyOf(mPixel, mPixel.length);

                        frame.setData(mPixel);// 数据如果大于1080p，会出现空间不够
                        if (wah[0] != width || wah[1] != height)
                        {
                            info.setWidth(wah[0]);
                            info.setHeight(wah[1]);
                        }


                        frame.setMediaInfo(info);

                        try
                        {
                            videoDecodedQueue.addFrameToQueue(frame);
                        }
                        catch (UnsupportedOperationException e)
                        {
                            Log.i("error", e.getMessage());
                        }

                    }
                }
            }
            else if (Frame.TYPE_AUDIO == frame.getType())
            {
                if (!isAudioPlaying)
                {
                    return;
                }
                if (0 == isInitAudioDecode || null == mediaInfo || mediaInfo.getChannels() != info.getChannels()
                        || mediaInfo.getAudioFormat() != info.getAudioFormat()
                        || mediaInfo.getSampleRate() != info.getSampleRate())
                {
                    mediaInfo = info;
                    if (null != codec && isInitAudioDecode > 0)
                    {
                        codec.releaseAudioDecoder();
                        isInitAudioDecode = 0;
                    }

                    codec.setAudioCodecType(frame.getCodecType());
                    int result = codec.initAudioDecoder(mediaInfo.getChannels(), mediaInfo.getAudioFormat(), mediaInfo.getSampleRate());
                    if (result <= 0)
                    {
                        return;
                    }
                    isInitAudioDecode = 1;

                    if (Codec.CODEC_G711 == frame.getCodecType())
                    {
                        mediaInfo.setChannels(AudioFormat.CHANNEL_OUT_MONO);
                        mediaInfo.setAudioFormat(AudioFormat.ENCODING_PCM_16BIT);
//						mediaInfo.setSampleRate(8000);

                        mAudio = new byte[512];
                    }
                    channel = mediaInfo.getChannels();
                    encoding = mediaInfo.getAudioFormat();
                    sampleRateInHz = mediaInfo.getSampleRate();
                }

                //	iTemp = decodeAudio(dataBuf);
                if (iTemp > 0)
                {
                    frame.setData(mAudio);
//					audioDecodedQueue.addFrameToQueue(frame);
                    //閹绢厽鏂?
                    if (null == audioPlayer)
                    {
                        audioPlayer = new AudioPlayer(context, channel, encoding, sampleRateInHz);
                        audioPlayer.play();
                    }
                    if (null != audioPlayer && audioPlayer.isAudioPlaying())
                    {
                        audioPlayer.addAudioData(mAudio);
                    }
                }
            }
        }

        /**
         * 鐟欙絿鐖滅憴鍡涱暥
         *
         * @param data 閺堫亣袙閻胶娈戠憴鍡涱暥閺佺増宓?
         * @return 鐟欙絿鐖滅紒鎾寸亯
         * @throws Exception
         */
        private int decodeVideo(byte[] data, int length, int[] wah, int codetype)
        {
            if (null == data || data.length <= 0)
            {
                return 0;
            }
            return codec.decodeVideo(data, length, mPixel, wah, codetype);
        }

        /**
         * 鐟欙絿鐖滈棅鎶筋暥
         *
         * @param data 閺堫亣袙閻胶娈戦棅鎶筋暥閺佺増宓?
         */
        private int decodeAudio(byte[] data)
        {
            if (null == data || data.length <= 0)
            {
                return 0;
            }
            return codec.decodeAudio(data, data.length, mAudio);
        }

        void saveImage(final int Width, final int Height)
        {

            YuvImage image = new YuvImage(this.mPixel, ImageFormat.NV21, Width, Height, null);

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

                Log.e("tag", "保存图片");
                File f = new File("/sdcard/namecard/", "pic.png");
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
                    Log.i("tag", "已经保存");
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

    public void startAudio()
    {
        isAudioPlaying = true;
    }

    public void stopAudio()
    {
        isAudioPlaying = false;
        if (null != audioPlayer)
        {
            audioPlayer.stop();
        }
        audioPlayer = null;
    }


}
