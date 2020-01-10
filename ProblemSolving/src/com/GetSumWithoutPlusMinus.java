package com;

public class GetSumWithoutPlusMinus {
	public int getSum(int a, int b) {
        int carry=0;
        int sum=0;
        carry=(a^b);
        sum = a&b;
        int total = (sum<<1*(log2(carry)))|(carry);
        return total;
    }
	
	public int log2(int x)
	{
	    return (int) (Math.log(x) / Math.log(2));
	}
}
