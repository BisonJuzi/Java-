package java基础视频;

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

	
	public static int[] grow(int[] src, int size) {
		// 方式一
		int[] target = new int[src.length+size];
		System.arraycopy(src, 0, target, 0, src.length+size);
		
		// 方式二
		target = Arrays.copyOf(src, src.length+size);
		return target;
	}

}
