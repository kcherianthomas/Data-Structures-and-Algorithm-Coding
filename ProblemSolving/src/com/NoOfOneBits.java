package com;
/*
 * Write a function that takes an unsigned integer and return the number of '1' bits 
 * it has (also known as the Hamming weight).
 */
public class NoOfOneBits {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0) {
        	if((n&1)==1) {
        		++count;
        	} 
        	n=n>>1;
        }
        return count;
    }
}
