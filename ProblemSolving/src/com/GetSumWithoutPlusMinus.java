package com;

public class GetSumWithoutPlusMinus {
	public int getSum(int a, int b) {
		while (b != 0) {
			int carry = a & b;
			/*xor helps to simulate binary addition
			 * for example if we want to add 1+1 we know units place is zero
			 */
			a = a ^ b;
			/* we need to apply carry 1 position left
			 * for example when we add 1+1 the carry needs to be applied left of
			 * units place to get 10
			 */
			b = carry << 1;
		}
		return a;
	}
}
