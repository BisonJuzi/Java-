package java基础视频;

/**
 * List接口
 * 因为ArrayList和LinkedList都可以随机访问（通过index）
 * @author LJ
 *
 */

public interface List {
	public void add(Object o);
	public void add(int index, Object o);
	public Object get(int index);
	public Object remove(int index);
	public int size();
}
