package java基础视频;

import java.util.Objects;

/**
 * 二叉树
 * 要求：左节点<中间节点<右节点
 * @author LJ
 *
 */

public class BinaryTreeNode<T extends Comparable> {

	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private int size;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	@SuppressWarnings("unchecked")
	public BinaryTreeNode<T> insert(T o) {
		if(this.data == null) {
			this.data = o;
			return this;
		}
		int compareResult = this.data.compareTo(o);
		if(compareResult > 0) {
			if(this.left == null) {
				this.left = new BinaryTreeNode<T>();
				this.left.data = o;
				return this.left;
			}else {
				return this.left.insert(o);
			}
		}else if(compareResult < 0) {
			if(this.right == null) {
				this.right = new BinaryTreeNode<T>();
				this.right.data = o;
				return this.right;
			}else {
				return this.right.insert(o);
			}
		}else {
			return this;
		}
	}
	
	
	// 未完成
	@SuppressWarnings("unchecked")
	public BinaryTreeNode<T> delete(T o) {
		BinaryTreeNode<T> node = search(o);
		if(node == null) {
			return null;
		}
		int compareResult = this.data.compareTo(o);
		if(compareResult > 0) {
			return this.left.delete(o);
		}else if(compareResult < 0) {
			return this.right.delete(o);
		}else {
			if(node.right == null) {
				if(node.left == null) {
					this.data = null;
				}else {
					this.left = this;
				}
			}
			return null;
		}
	}
	
	@SuppressWarnings("unused")
	private BinaryTreeNode<T> findMin(){
		if(this.data == null) {
			return null;
		}
		if(this.left == null) {
			return this;
		}
		return this.left.findMin();
	}
	
	@SuppressWarnings("unused")
	private BinaryTreeNode<T> findMax(){
		if(this.data == null) {
			return null;
		}
		if(this.right == null) {
			return this;
		}
		return this.right.findMax();
	}
	
	@SuppressWarnings("unchecked")
	private BinaryTreeNode<T> search(T o) {
		if(this.data == null) {
			return null;
		}
		int compareResult = this.data.compareTo(o);
		if(compareResult > 0) {
			if(this.left == null) {
				return null;
			}else {
				return this.left.search(o);
			}
		}else if(compareResult < 0){
			if(this.right == null) {
				return null;
			}else {
				return this.right.search(o);
			}
		}else {
			return this;
		} 
	}
	
	
	// 写代码形成下面的二叉树，leftChild的值总是比父节点的值小，rightChild的值总是比父节点的值大
	// 比如：5（2（1，null）,7（6，null））
	// 向二叉树中插入值4和8：5（2（1，4）,7（6，8））
	
}
