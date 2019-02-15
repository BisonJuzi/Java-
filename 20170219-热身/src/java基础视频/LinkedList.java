package java基础视频;

/**
 * 基于链表实现
 * @author LJ
 *
 */

public class LinkedList implements List{
	
	private Node head;
	
	public void add(Object o) {
		if(head == null) {
			head = new Node();
			head.next = null;
		}else {
			
		}
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
	
	public Object addFirst(Object o) {
		return null;
	}
	
	public Object removeFirst() {
		return null;
	}
	
	public Object removeLast() {
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static class Node{
		Object data;
		Node next;
		Node prev;
	}
	
}
