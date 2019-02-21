package java基础视频;

import java.util.EmptyStackException;
import java.util.Objects;


public class Stack<T> {
	private int size;
	private Object[] dataArray = {};
	
	public Stack() {
		
	}
	
	public int size() {
		return size;
	}
	
	public T push(T o) {
		ensureCapacity(size+1);
		this.dataArray[size] = o;
		size++;
		return o;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		T data = (T) this.dataArray[size-1];
		size --;
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		return (T) dataArray[size-1];
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public synchronized int search(Object o) {
		for(int i=0;i<size;i++) {
			if(Objects.equals(dataArray[i], o)) {
				return i;
			}
		}
		return -1;
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
