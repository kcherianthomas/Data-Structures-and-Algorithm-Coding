package com;

/*
 * Given an integer number n, 
 * return the difference between the product 
 * of its digits and the sum of its digits. 
 */
public class SubtractProductMinusSum {
	/*
	 * The below solution has a time complexity
	 * O(logN)
	 */
	public int subtractProductAndSum(int n) {
        if(n==0) {
            return 0;
        }
       int product =1;
       int sum =0;
       while(n!=0) {
           int remainder = n%10;
           sum +=remainder;
           product*=remainder;
           n/=10;
           
       }
        return (product - sum);
    }
}
