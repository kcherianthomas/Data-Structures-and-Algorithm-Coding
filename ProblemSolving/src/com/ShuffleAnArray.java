package com;

import java.util.Random;

public class ShuffleAnArray {
	int [] arr;
	 public ShuffleAnArray(int[] nums) {
	        arr = nums; 
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return arr;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	    	int length = arr.length;
	        int []output = new int [length];
	        int []temp = new int [length];
	        for(int i=0;i<temp.length;++i) {
	        	temp[i] = arr[i];
	        }
	        Random rand = new Random(); 
	        for(int i=0;i<length;++i) {
	        int random = rand.nextInt(length-i);
	        int tempVal = temp[random];
			temp[random] = temp[length-i-1];
			temp[length-i-1] = tempVal;
	        }
	        return temp;
	    }

}
