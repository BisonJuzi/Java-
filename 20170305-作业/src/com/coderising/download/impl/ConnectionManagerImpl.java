package com.coderising.download.impl;

/**
 * 可以打开一个连接，通过Connection可以读取其中的一段（用startPos, endPos来指定）
 */

import com.coderising.download.api.Connection;
import com.coderising.download.api.ConnectionException;
import com.coderising.download.api.ConnectionManager;

public class ConnectionManagerImpl implements ConnectionManager {

	@Override
	public Connection open(String url) throws ConnectionException {
		
		return new ConnectionImpl(url);
	}

}
