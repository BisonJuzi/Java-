package com.coderising.basic;

import java.util.Arrays;

public class ArrayUtil {
	/**
	 * 给定一个整形数组a，对该数组的值进行置换
	 */
	public void reverseArray(int[] orgin) {

		// orgin.length == 0：[]
		if (orgin == null || orgin.length == 0) {
			return;
		}

		for (int i = 0, j = orgin.length - 1; i < j; i++, j--) {
			int t = orgin[i];
			orgin[i] = orgin[j];
			orgin[j] = t;
		}
	}

	/**
	 * 现在有如下数组， int oldArr[] = [1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5]
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成新数组
	 */
	public int[] removeZero(int[] oldArr) {
		if (oldArr == null) {
			return null;
		}

		if (oldArr.length == 0) {
			return oldArr;
		}

		int count = 0;
		int[] b = new int[oldArr.length]; // 临时存储
		for (int i = 0; i < oldArr.length; i++) {
			if (oldArr[i] != 0) {
				b[count++] = oldArr[i];
			}
		}
		
		// 初始化一个元素个数为非零元素个数的新数组
//		int[] newArr = new int[count];
//		System.arraycopy(b, 0, newArr, 0, count);
//		return newArr;
		
		return Arrays.copyOf(b, count);
	}
	
	/**
	 * 给定2个已经排序好的整形数组 a1 和 a2，创建一个新的数组a3，使得a3包含a1和a2的所有元素，
	 * 并且仍然不重复的有序排列
	 * 例如 a1 = [3,5,7,8], a2 = [4,5,6,7],则a3 = [3,4,5,6,7,8]
	 */
	public static int[] merge(int[] a1, int[] a2) {
		if(a1 == null && a2 != null) {
			return a2;
		}
		if(a1 != null && a2 == null) {
			return a1;
		}
		if (a1 == null && a2 == null){
			return null;
		}
		
		int[] newArr = new int[a1.length + a2.length];
		int i = 0, j = 0;
		int count = 0;
		while(i<a1.length && j<a2.length) {
			if(a1[i] < a2[j]) {
				newArr[count++] = a1[i++];
			}else if(a1[i] > a2[j]) {
				newArr[count++] = a2[j++];
				j++;
			}else {
				newArr[count++] = a1[i];
				i++;
				j++;
			}
		}
		
		while(i<a1.length) {
		   newArr[count++] = a1[i++];
		}
		while(j<a2.length) {
			newArr[count++] = a2[j++];
		}
		
/*		if(i<a1.length && j == a2.length) {
			System.arraycopy(a1, i, newArr, count, a1.length-i);
			count = count + a1.length - i;
		}
		if(i == a2.length && j<a2.length) {
			System.arraycopy(a2, j, newArr, count, a2.length-j);
			count = count + a2.length - j;
		}*/

		int[] newArr1 = new int[count];
		System.arraycopy(newArr, 0, newArr1, 0, count);
		return newArr1;
	}
	
	public int[] grow(int[] oldArr, int size) {
		if(oldArr == null) {
			return null;
		}
		if(size < 0) {
			throw new IndexOutOfBoundsException("size<0");
		}
		int[] newArr = new int[oldArr.length + size];
		System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
		return newArr;
	}
	
	/**
	 * 菲波那切数列: 1,1,2,3,5,8,13,21...，给定一个最大值，返回小于该值的数列
	 * max = 5：[1,1,2,3]
	 * max = 1: []
	 * @param args
	 */
	public static int[] fibonacci(int max) {
		if(max == 1) {
			return new int[0];
		}
		if(max == 2) {
			return new int[] {1,1};
		}
		
		int[] a = new int[max];
		a[0] = 1;
		a[1] = 1;
		int count = 2;
		
/*		while(a[count-1]<max) {
			int num = a[count-1] + a[count-2];
			if(num >= max ) {
				break;
			}
			a[count] = num;
			count++;
		}*/
		
		for(int i=2;i<max;i++) {
			a[i] = a[i-1] + a[i-2];
			if(a[i] >= max) {
				break;
			}else {
				count++;
			}
		}
		
		return Arrays.copyOf(a, count);
	}
	
	/**
	 * 返回<给定最大值max的所有素数数组
	 * 例如：max=23：[2,3,5,7,11,13,17,19]
	 * @param args
	 */
	public static int[] primesArr(int max) {
		if(max < 2) {
			return new int[0];
		}
		
		int[] arr = new int[max];
		int count = 0;
		for(int i = 2; i<max;i++) {
			boolean flag = true;
			for(int j=2;j<i;j++) {
				if(i%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				arr[count++] = i;
			}
		}
		return Arrays.copyOf(arr, count);
	}
	
	public static void main(String[] args) {
		int[] a1 = {3,5,7,8};
		int[] a2 = {4,5,6,7};
		int[] a3 = merge(a1,a2);
		System.out.println(Arrays.toString(a3));
		System.out.println(Arrays.toString(fibonacci(8)));
		System.out.println(Arrays.toString(primesArr(23)));

	}
	
}
