package com.media;

public class H264Decoder {
	
	 private static H264Decoder uniqueInstance = null;
	 
	    private H264Decoder() {
	       // Exists only to defeat instantiation.
	    }
	 
	    public static H264Decoder getInstance() {
	       if (uniqueInstance == null) {
	           uniqueInstance = new H264Decoder();
	           int result = uniqueInstance.init();
	           int a;
	           a = 0;
	       }
	       return uniqueInstance;
	    }
	
	/**
	 * 鍒濆鍖?
	 * @return
	 */
	public native int init();


	public native int add(int decodeType);

	/**
	 * 瑙ｇ爜
	 * @param src 鍘熷H264缂栫爜鐨勮棰戞暟鎹?
	 * @param length 鍘熷H264缂栫爜鐨勮棰戞暟鎹殑闀垮害
	 * @param dst 瑙ｇ爜鍚庣殑yuv瑙嗛鏁版嵁
	 * @param wah 瑙嗛鐨勫疄闄呭銆侀珮搴︽暟缁?
	 * @return
	 */
	public native synchronized  int decode(int handle,byte[] src, int length, byte[] dst,int[] wah,int codetype);

	/**
	 * 閲婃斁
	 */
	public native void release(int handle);
	
	static {
		System.loadLibrary("H264Decoder");
	}
}
