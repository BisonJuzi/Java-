package com.coderising.download;

import java.io.RandomAccessFile;
import java.util.concurrent.CyclicBarrier;

import com.coderising.download.api.Connection;

public class DownloadThread extends Thread{

	Connection conn;
	int startPos;
	int endPos;
	CyclicBarrier barrier;
	String localFile;
	
	public DownloadThread( Connection conn, int startPos, int endPos, String localFile, CyclicBarrier barrier){
		
		this.conn = conn;		
		this.startPos = startPos;
		this.endPos = endPos;
		this.localFile = localFile;
		this.barrier = barrier;
	}
	
	public void run(){		
		try {
			System.out.println("Begin to read [" + startPos +"-"+endPos+"]");
			
			// 读取指定范围文件
			byte[] data = conn.read(startPos, endPos);		
			
			// 创建随机访问文件流，写入指定名称的文件中
			RandomAccessFile file = new RandomAccessFile(localFile,"rw");
			
			// 找到当前文件指针
			file.seek(startPos); 	
			
			// 将字节数组中的字节写入此文件
			file.write(data); 
			
			// 关闭此随机访问文件流,并释放与该流关联的所有系统资源
			file.close();
			
			conn.close();
			
			barrier.await(); //等待别的线程完成
			
		} catch (Exception e) {			
			e.printStackTrace();			
		} 		
	}
}
