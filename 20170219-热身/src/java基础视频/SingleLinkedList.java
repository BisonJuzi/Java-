package java基础视频;

import java.util.Objects;

import java基础视频.LinkedList.Node;

public class SingleLinkedList<T> implements List<T>{
	private int size;
	private Node<T> head;
	
	public SingleLinkedList() {
		this.head = new Node<T>(null); 
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public T get(int index){
		if(index < 0 || index > size -1) {
		  throw new IndexOutOfBoundsException();
		}
		return search(index).data;
	}

	@Override
	public T set(int index, T o) {
		if(index < 0 || index > size) {
			  throw new IndexOutOfBoundsException();
		}
		Node<T> newNode = new Node<T>(o);
		Node<T> node = null;
		if(index == size) {
			node = search(index-1);
			node.next = newNode;
			newNode.next = null;
			node = newNode;
		}else {
			node = search(index-1);
			node.data = o;
		}
		return node.data;
	}
	
	private Node<T> search(int index) {
		Node<T> node = head;
		for(int i=0;i<=index;i++) {
			node = node.next;
		}
		return node;		
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		int i = 0;
		Node<T> node = head;
		while(node.next != null) {
			node = node.next;
			array[i] = node.data;
			i++;
		}
		return array;
	}

	@Override
	public boolean contains(Object o) {
		Node<T> node = head;
		while(node.next != null) {
			node = node.next;
			if(Objects.equals(node.data, o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		head.next = null;
		size = 0;
	}

	@Override
	public int indexOf(T o) {
		Node<T> node = head;
		int index = 0;
		while(node.next != null) {
			node = node.next;
			if(Objects.equals(node.data, o)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public boolean add(T o) {
		Node<T> node = head;
		Node<T> newNode = new Node<T>(o);
		while(node.next != null) {
			node = node.next;
		}
		node.next = newNode;
		return true;
	}

	@Override
	public void add(int index, T o) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> node = head;
		Node<T> newNode = new Node<T>(o);
		Node<T> preNode = search(index-1);
		if(index == 0) {
			newNode.next = head.next;
			head.next = newNode;
		}else if(index == size) {
			preNode.next = newNode;
		}else {
			newNode.next = preNode.next;
			preNode.next = newNode;
		}
 	}
	
	@Override
	public boolean remove(T o) {
		Node<T> node = head;
		int i = 0;
		Node<T> preNode = null;
		while(node.next != null) {
			node = node.next;
			if(Objects.equals(node.data, o)) {
				if(i == 0) {
					head.next = node.next;
				}else {
					preNode = search(i-1);
					preNode.next = node.next;
				}
				size--;
				return true;
			}
			i++;
		}
		return false;
	}

	@Override
	public T remove(int index) {
		if(index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> node = head;
		Node<T> removeNode = null;
		int i = 0;
		
		if(index == 0) { //ɾ��ͷ���
			removeNode = head;
			head = head.next;
		}else {
			while(node.next != null) {
				node = node.next;
				if(i == index-1) {
					removeNode = node.next;
					if(index == size -1) {
						node.next = null;
					}else {
						node.next = removeNode.next;
					}
				}
				i++;
			}
		}
		size--;
		return removeNode.data;
	}
	
	private static class Node<T>{
		
		T data;
		Node<T> next;
		
		Node(T data){
			this.data = data;
		}
	}
}
