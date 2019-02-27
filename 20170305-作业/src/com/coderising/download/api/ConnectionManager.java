package com.coderising.download.api;

public interface ConnectionManager {
	/**
	 * 给定一个url , 打开一个连接
	 * 通过Connection可以读取其中的一段（用startPos, endPos来指定）
	 * @param url
	 * @return Connection对象
	 */
	public Connection open(String url) throws ConnectionException;	
}
