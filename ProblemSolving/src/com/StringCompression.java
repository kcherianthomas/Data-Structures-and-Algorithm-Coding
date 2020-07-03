package com;

public class StringCompression {
	public int compress(char[] chars) {
		if(chars.length==1) {
			return 1;
		}
       int count=1;
       StringBuilder bld= new StringBuilder();
       for(int i=1;i<chars.length;++i) {
           if(chars[i]==chars[i-1]) {
               count++;
           } else {
        	   if(count!=1) {
        		   bld.append(String.valueOf(chars[i-1])+ String.valueOf(count));
        	   } else {
        		   bld.append(String.valueOf(chars[i-1])) ;
        	   }
               count =1;
           }
       } 
       if(count!=1) {
    	   bld.append(String.valueOf(chars[chars.length-1])+ String.valueOf(count));
    	   } else {
    		   bld.append(String.valueOf(chars[chars.length-1]));
    	   }
       for(int i=0;i<bld.length();++i) {
      	   chars[i] = bld.charAt(i);
         }
      // char [] charsNew =  str.toCharArray();
       return bld.length();
    }
}
