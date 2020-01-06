package com;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string s formed by digits ('0' - '9') and '#' . 
 * We want to map s to English lowercase characters as follows:
Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
Return the string formed after mapping.
It's guaranteed that a unique mapping will always exist.
 */
public class DecryptStringAlphabetToInteger {
public String freqAlphabets(String s) {
	if(null==s || s.equals("")) {
		return "";
	}
        Map<String,String> map = new HashMap<>();
        /*
         * Was trying to reduce code size by using ASCII properties to
         * insert key value pair for all mapping
         */
        for(int i=0;i<26;++i) {
        	if(i<9) {
        		map.put(String.valueOf(i+1),String.valueOf(((char)('a'+i))));
        	} else {
        		map.put(String.valueOf(i+1)+'#',String.valueOf(((char)('a'+i))));

        	}
        }
        StringBuilder string = new StringBuilder();
        int i=s.length()-1;
        while(i>=0) {
        	if(s.charAt(i)=='#') {
        		String key = s.substring(i-2, i+1);
        		string.insert(0, map.get(key));
        		i=i-3;
        	} else {
        		String key = String.valueOf(s.charAt(i));
        		string.insert(0, map.get(key));
        		i=i-1;
        	}
        }
        return string.toString();
        
        
        
    }
}
