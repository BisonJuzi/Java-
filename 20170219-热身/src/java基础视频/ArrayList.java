package java基础视频;

/**
 * ArrayList 实现数组自增长
 * 基于数组实现
 * @author LJ
 *
 */

public class ArrayList implements List {
	private int size = 0;
	
	private Object[] elementData = new Object[100];
	
	public void add(Object o) {
		
	}
	
	public void add(int index, Object o) {
		
	}
	
	public Object get(int index) {
		return null;
	}
	
	public Object remove(int index) {
		return null;
	}
	
	public int size() {
		return -1;
	}
	
	public Iterator iterator() {
		return new ArrayListIterator(this);
	}
	
	private class ArrayListIterator implements Iterator{
		ArrayList l = null;
		int pos = 0;
		
		private ArrayListIterator(ArrayList l) {
			this.l = l;
		}

		@Override
		public boolean hasNext() {
			pos ++;
			if(pos > size) {
				return false;
			}
			return true;
		}

		@Override
		public Object next() {
			return elementData[pos];
		}

		@Override
		public Object remove() {
			return null;
		}
	}
}
