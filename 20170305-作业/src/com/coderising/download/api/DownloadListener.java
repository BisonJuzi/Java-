package com.coderising.download.api;

/**
 * 由于是多线程下载， 调用这个类的客户端不知道什么时候结束，
 * 所以你需要实现:当所有线程都执行完以后， 调用listener的notifiedFinished方法，
 * 这样客户端就能收到通知。
 * @author LJ
 */
public interface DownloadListener {
	public void notifyFinished(); // 回调
}
