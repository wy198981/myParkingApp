package com.media;

public class MediaConverter {
	/**
	 * 把YUV420SP转化成RGB565
	 * @param yuv YUV420SP媒体数据
	 * @param rgb RGB565媒体数据
	 * @param width 转化后的RGB565数据的宽度
	 * @param height 转化后的RGB565数据的宽度
	 * @return 转化结果，1：成功；0：失败
	 */
	public native int YUV420SP2RGB565(byte[] yuv, byte[] rgb, int width, int height);
	
	
	static {
		System.loadLibrary("MediaConverter");
	}
}
