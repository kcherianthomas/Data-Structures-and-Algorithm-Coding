package com;

/* Given an integer n, return the number of trailing zeroes in n!.
 */
public class FactorialTrailingZeroes {
	/* The logic is if we have 27!. We divide it with 5,25,125..
	 * this keeps happening until we get a value less than 1 when we divide.
	 * now we add up all the quotients we got to get the answer.
	 */
	 public int trailingZeroes(int n) {
	        if(n<5) {
	            return 0;
	        }
	        // There was some overflow for factor when we use int
	        long factor=5;
	        int ans=0;
	        do{
	            int remainder = (int)Math.floor(n/factor);
	            if(remainder<1) {
	                break;
	            } else {
	                ans+=remainder;
	            }
	            factor*=5;
	        } while(true);
	        return ans;
	    }
}
