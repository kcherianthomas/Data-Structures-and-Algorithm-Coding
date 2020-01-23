package com;
/*Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num 
 * calculate the number of 1's in their binary representation and return them as an array.
 */
public class CountBits {
	public int[] countBits(int num) {
		int[] outArray = new int[num + 1];
		for (int i = 0; i <= num; ++i) {
			outArray[i] = oneBitCount(i);
		}
		return outArray;
	}

	//Function to count 1's for given num
	public int oneBitCount(int num) {
		if (num == 0) {
			return 0;
		}
		int count = 0;
		while (num != 0) {
			if ((num & 1) == 1) {
				count++;
			}
			num = num >> 1;
		}
		return count;
	}
}
