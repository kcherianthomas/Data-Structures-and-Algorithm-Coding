package com;
/*
 * Given five positive integers, find the minimum and maximum values that can 
 * be calculated by summing exactly four of the five integers. 
 * Then print the respective minimum and maximum values as a single line of 
 * two space-separated long integers. 
 */
public class MiniMaxSum {
	/*
	 * Get min and max value delete from total sum
	 * Time complexity =0(arr.length())
	 */
	static void miniMaxSum(int[] arr) {
        int maxVal=arr[0];
        int minVal=arr[0];
        long sum=arr[0];
        for(int i=1;i<5;++i) {
            if(arr[i]<minVal) {
                minVal = arr[i];
            } else if(arr[i]>maxVal) {
                maxVal = arr[i];
            }
            sum+=arr[i];
            
        }
        System.out.println((sum-maxVal)+ " " + (sum-minVal));
    }
}
