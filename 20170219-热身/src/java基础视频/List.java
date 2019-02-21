package java基础视频;

public interface List<T> {
	public int size();
	public boolean isEmpty();
	public int indexOf(T o);
	public boolean add(T o);
	public void add(int index, T o);
	public T get(int index);
	public T set(int index, T o);
	public boolean remove(T o);
	public T remove(int index);
	public Object[] toArray();
	public boolean contains(Object o);
	public void clear();

}
