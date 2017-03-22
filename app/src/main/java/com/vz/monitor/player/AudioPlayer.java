package com.vz.monitor.player;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;

/**
 * 音频播放器类
 * @author 谭汉�?
 * @date 2012-8-3
 */
public class AudioPlayer {
	private int sampleRateInHz = 8000; //采样速率
	private int channelConfig = AudioFormat.CHANNEL_OUT_MONO; //单声�?
	private int audioEncoding = AudioFormat.ENCODING_PCM_16BIT; //采样深度
	private int streamType = AudioManager.STREAM_MUSIC;
	private int mode = AudioTrack.MODE_STREAM;

	private AudioTrack mAudioTrack = null;
	private MediaPlayer mediaPlayer = null;
	private boolean isAudioPlaying = false;
	private boolean isAlarmPlaying = false;
	private Context context = null;

	private List<byte[]> audioDataLists = new ArrayList<byte[]>();
	private float volume = 0.7f;

	public boolean isAudioPlaying() {
		return isAudioPlaying;
	}

	public boolean isAlarmPlaying() {
		return isAlarmPlaying;
	}

	public AudioPlayer(Context context) {
		this.context = context;
	}

	public AudioPlayer(Context context, int channel, int encoding, int sampleRateInHz) {
		this.context = context;
		this.channelConfig = channel;
		this.audioEncoding = encoding;
		this.sampleRateInHz = sampleRateInHz;
	}

	/**
	 * 设置音频数据
	 * @param data 音频数据
	 */
	public synchronized void addAudioData(byte[] audioData) {
//		if(null != audioData) {
//			audioDataLists.add(audioData);
//		}
		mAudioTrack.write(audioData, 0, audioData.length);
	}

	/**
	 * 获取音频数据列表的头位置数据
	 * @return 如果有音频数据，就返回音频数据，否则返回长度�?的数�?
	 */
	private synchronized byte[] getAudioData() {
		if(audioDataLists.size() > 0) {
			return audioDataLists.remove(0);
		} else {
			return new byte[0];
		}
	}

	/**
	 * 清空音频数据
	 */
	private void clearAudioData() {
		audioDataLists.clear();
	}

	/**
	 * 初始�?
	 */
	private void initAudioTrack() {
		int bufferSizeInBytes = AudioTrack.getMinBufferSize(sampleRateInHz, channelConfig, audioEncoding);
	    mAudioTrack = new AudioTrack(streamType, sampleRateInHz, channelConfig, audioEncoding, bufferSizeInBytes, mode);
	    mAudioTrack.setStereoVolume(volume, volume);
	}

	/**
	 * 播放声音
	 */
	public void play() {
		initAudioTrack();
	    isAudioPlaying = true;
	    mAudioTrack.play();
//	    AudioPlayThread audioPlayThread = new AudioPlayThread();
//	    audioPlayThread.start();
	}

	/**
	 * 停止声音
	 */
	public void stop() {
		isAudioPlaying = false;
		if(null != mAudioTrack) {
			mAudioTrack.stop();
			mAudioTrack.release();
			mAudioTrack = null;
		}
		clearAudioData();
	}

//	/**
//	 * 播放警报声音
//	 */
//	public void playAlarm() {
//		mediaPlayer = MediaPlayer.create(context, com.huanyi.monitor.R.raw.alarm);
//		if(null != mediaPlayer) {
//		    mediaPlayer.start();
//		}
//		isAlarmPlaying = true;
//	}
//
//	/**
//	 * 停止警报声音
//	 */
//	public void stopAlarm() {
//		isAlarmPlaying = false;
//		if (null != mediaPlayer) {
//			mediaPlayer.stop();
//			mediaPlayer.release();
//			mediaPlayer = null;
//		}
//	}

	/**
	 * 音频播放的线程类
	 * @author Administrator
	 */
	private class AudioPlayThread extends Thread
	{
		@Override
		public void run() {
			playing(); 
		}

		private void playing() {
			while(isAudioPlaying) {
				byte[] data = getAudioData();
				if(null != data && data.length > 0) {
					mAudioTrack.write(data, 0, data.length);
				} else {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
					}
				}
				
			}
		}
	}
}
