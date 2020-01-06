package com;

public class ExcelSheetColumnNumber {
	/*
	 * Given a column title as appear in an Excel sheet, 
	 * return its corresponding column number.
	 */
public int titleToNumber(String s) {
	int count =0;
	for(int i=0;i<s.length();++i) {
		//setting val of 'A' to 'Z' as 1 to 26
        	int val= s.charAt(0)-'A'+1;
        	count = count*26+val;
        }
        return count;
    }
}
