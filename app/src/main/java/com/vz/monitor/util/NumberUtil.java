package com.vz.monitor.util;

public class NumberUtil {
	/**
	 * 4字节数组转成整型
	 *
	 * @param b 转换的字节数组
	 * @return 整型
	 */
	public static final int byte2Int(byte b[]) {
		if(null == b || b.length < 4) {
			return 0;
		}
		return b[3] & 0xff | (b[2] & 0xff) << 8 | (b[1] & 0xff) << 16
				| (b[0] & 0xff) << 24;
	}

	/**
	 * 小端字节序的4字节数组转成整型值
	 * @param b 小端字节序的4字节数组
	 * @return 整型值
	 */
	public static final int leByte2Int(byte[] b) {
		if(null == b || b.length < 4) {
			return 0;
		}
		return b[0] & 0xff | (b[1] & 0xff) << 8 | (b[2] & 0xff) << 16
				| (b[3] & 0xff) << 24;
	}

	/**
	 * 把整型转成4字节数组
	 *
	 * @param intValue 转换的整型数
	 * @return 4字节数组
	 */
	public static final byte[] int2Byte(int intValue) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (intValue >> 8 * (3 - i) & 0xFF);
		}
		return b;
	}

	/**
	 * 把整型值转成小端字节序(little-endian)的4字节数组
	 * @param value 整型值
	 * @return 转换后的4字节数组
	 */
	public static final byte[] int2LeByte(int value) {
		byte[] b = new byte[4];
		for(int i = 0; i < 4; i++) {
			b[i] = (byte)(value >> 8 * i & 0xFF);
		}
		return b;
	}

	/**
	 * 保留一位小数
	 * @param num
	 * @return 转换后的字符串格式
	 */
	public static final String limitOneDecimal(float num) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");
		return df.format(num);
	}
}
