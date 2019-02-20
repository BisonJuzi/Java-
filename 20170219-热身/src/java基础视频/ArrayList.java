package java基础视频;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * ArrayList 实现数组自增长
 * 基于数组实现
 * @author LJ
 *
 */

public class ArrayList<T> implements List<T> {
	private int size;
	private Object[] dataArray = new Object[0];
	protected static final String PREFIX = "[";
	protected static final String SUFFIX = "]";
	protected static final String SEPERATOR = ",";

	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public boolean contains(Object o) {
		for(Object obj : dataArray) {
			if(Objects.equals(obj, o)) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return (T)dataArray[index];
	}
	
	@Override
	public T set(int index, T o) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		dataArray[index] = o;
		return o;
	}
	
	@Override
	public int indexOf(T o) {
//		int index = 0;
//		for(Object obj: dataArray) {
//			if(Objects.equals(obj, o)) {
//				return index;
//			}
//			index ++;
//		}
		
		for(int i=0;i<size;i++) {
			if(Objects.equals(o, dataArray[i])) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		System.arraycopy(dataArray, 0, array, 0, size);
		return array;
	}
	
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		sb.append(PREFIX);
		for(int i=0;i<size();i++) {
			sb.append(get(i));
			if(i < size()-1) {
				sb.append(SEPERATOR);
			}
		}
		sb.append(SUFFIX);
		return sb.toString();
	}
	
	public boolean add(T o) {
		ensureCapacity(size+1);
		dataArray[size] = o;
		size++;
		return true;
	}
	
	@Override
	public void add(int index, T o) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		ensureCapacity(size+1);
		dataArray[size] = o;
		size++;
	}
	
	@Override
	public boolean remove(T o) {
		int index = indexOf(o);
		if(index < 0) {
			return false;
		}
		System.arraycopy(dataArray, index+1, dataArray, index, size-1-index);
		dataArray[size-1] = null;
		size--;
		return true;
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T remove(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		T removeData = (T) dataArray[index];
		System.arraycopy(dataArray, index+1, dataArray, index, size-1-index);
		dataArray[size-1] = null;
		size--;
		return removeData;
	}
	
	@Override
	public void clear() {
		for(int i=0;i<size;i++) {
			dataArray[i] = null;
		}
		size = 0;
	}

	private void ensureCapacity(int minCapacity) {
		if(minCapacity > dataArray.length) {
			int newCapacity = Math.max(minCapacity, dataArray.length*2);
			Object[] newDataArray = new Object[newCapacity];
			System.arraycopy(dataArray, 0, newDataArray, 0, dataArray.length);
			dataArray = newDataArray;
		}
	}

	
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<T>{
		private int position;
//		private ArrayList<T> list;
		
		private ArrayListIterator() {
//			this.list = list;
		}

		@Override
		public boolean hasNext() {
			// 因为该非静态内部类和静态实例绑定在一起，故可以直接使用方法
			return position < size();
		}

		@Override
		public T next() {
			if(hasNext()) {
				return get(position++);
			}
			return null;
		}

		@Override
		public T remove() {
			if(position == 0) {
				throw new NoSuchElementException();
			}
			return ArrayList.this.remove(--position);
		}
	}
}
