package java������Ƶ;

/**
 * ������
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
	
	
	// д�����γ�����Ķ�������leftChild��ֵ���Ǳȸ��ڵ��ֵС��rightChild��ֵ���Ǳȸ��ڵ��ֵ��
	// ���磺5��2��1��null��,7��6��null����
	// ��������в���ֵ4��8��5��2��1��4��,7��6��8����
	
}
