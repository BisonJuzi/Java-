package java基础视频;

public class Queue1<T>{
	private LinkedList<T> list;
	
	public Queue1() {
		this.list = new LinkedList<T>();
	}
	
	public int size() {
		return list.size();
	}
	
	public void enQueue(T o) {
		list.add(o);
	}
	
	public T deQueue() {
		if(size() == 0) {
			return null;
		}
		return list.remove(size()-1);
	} 
	
	public T get(int index) {
		if(index < 0 || index > size()-1) {
			throw new IndexOutOfBoundsException();
		}
		return list.get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queue1 other = (Queue1) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}
	
	

}
