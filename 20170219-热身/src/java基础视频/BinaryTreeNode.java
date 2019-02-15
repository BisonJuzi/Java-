package java基础视频;

/**
 * 二叉树
 * @author LJ
 *
 */

public class BinaryTreeNode {

	private Object data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	public BinaryTreeNode insert(Object o) {
		return null;
	}
	
	
	// 写代码形成下面的二叉树，leftChild的值总是比父节点的值小，rightChild的值总是比父节点的值大
	// 比如：5（2（1，null）,7（6，null））
	// 向二叉树中插入值4和8：5（2（1，4）,7（6，8））
	
}
