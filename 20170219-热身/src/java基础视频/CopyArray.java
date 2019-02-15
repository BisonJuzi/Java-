package java������Ƶ;
/**
 * ���鸴��
 */

import java.util.Arrays;

public class CopyArray {
	public static void main(String[] args) {
		int[] a = new int[10];
		for(int i=0;i<a.length;i++) {
			a[i] = i;
		}
		for(int j=0;j<a.length;j++) {
			System.out.println(a[j]);
		}
	}

	
	/**
	 * ���鸴��
	 * @param src
	 * @param size
	 * @return
	 */
	public static int[] grow(int[] src, int size) {
		// ����һ
		int[] target = new int[src.length+size];
		System.arraycopy(src, 0, target, 0, src.length+size);
		
		// ������
		target = Arrays.copyOf(src, src.length+size);
		return target;
	}

}
