package com;
/*Reverse bits of a given 32 bits unsigned integer.
 * 
 */
public class ReverseBits {
	 // you need treat n as an unsigned value
	public int reverseBits(int n) {
        int newBit=0;
        for(int i=0;i<32;++i) {
        	//right shift current value and or it with the current leftmost bit
        	newBit=(newBit<<1)|(n&1);
        	//For getting next left bit
        	n=n>>1;
        }
        return newBit;
    }
}
