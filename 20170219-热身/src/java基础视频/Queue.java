package java基础视频;

import java.util.NoSuchElementException;

public class Queue<T> {
	private int size;
	private Object[] dataArray = {};
	private int front = 0;
	private int end = -1;
	
	public Queue() {
		
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean offer(T o) {
		ensureCapacity(size+1);
		dataArray[end+1] = o;
		end++;
		size++;
		return true;
	}

	@SuppressWarnings("unchecked")
	public T remove() {
		if(end == -1) {
			throw new NoSuchElementException();
		}
		T data = (T) dataArray[front];
		dataArray[front] = null;
		size -- ;
		front ++;
		if(front == dataArray.length) {
			front = 0;
		}
		if(size == 0) {
			end = -1;
		}
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public T poll() {
		if(end == -1) {
			return null;
		}
		T data = (T) dataArray[front];
		dataArray[front] = null;
		return data;
	}
	
	
	private void ensureCapacity(int minCapacity) {
		if(minCapacity > dataArray.length) {
			int newCapacity = Math.max(minCapacity, dataArray.length*2);
			Object[] newDataArray = new Object[newCapacity];
			System.arraycopy(dataArray, 0, newDataArray, 0, dataArray.length);
			dataArray = newDataArray;
		}			
	}
}
