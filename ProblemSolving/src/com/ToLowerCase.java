package com;
/*
 * function ToLowerCase() that has a string parameter str, and 
 * returns the same string in lowercase.
 */
public class ToLowerCase {
	/*
	 * The code finds ascii of upper case characters in string  
	 * (65 to 90)and convert those to lower by adding 32
	 */
	public String toLowerCase(String str) {
		StringBuilder bld = new StringBuilder();
		for(int i=0;i<str.length();++i) {
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				char temp = (char) (str.charAt(i)+32);
				bld.append(temp);
			} else {
				bld.append(str.charAt(i));
			}
		}
		return bld.toString();

	}
}
