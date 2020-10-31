package com;

public class ProductPairsLessThanK {
	public  long distinctProductPairsLessThanK(int[] arr, int k) {

		int left = 0;
		int right = arr.length - 1;
		int count = 0;
		while (left < right) {
			if ((arr[left] * arr[right]) < k) {
				count += (right - left)*2+1;
				left++;
			} else {
				right--;
			}
		}
		System.out.println(count);
		return count;
	}
	public static void main(String [] args) {
		ProductPairsLessThanK d = new ProductPairsLessThanK();
		d.distinctProductPairsLessThanK(new int[]{1,2,3},7);
	}
}
