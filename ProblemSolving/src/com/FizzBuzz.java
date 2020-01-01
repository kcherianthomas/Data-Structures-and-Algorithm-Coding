package com;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and 
 * for the multiples of five output “Buzz”. For numbers which are multiples of 
 * both three and five output “FizzBuzz”.
 */
public class FizzBuzz {
public List<String> fizzBuzz(int n) {
        List<String> s = new ArrayList<>();
        for(int i=1;i<=n;++i) {
        	if(i%3==0 && i%5==0) {
        		s.add("FizzBuzz");
        	} else if (i%3==0) {
        		s.add("Fizz");
        	} else if(i%5==0) {
        		s.add("Buzz");
        	} else {
        		s.add(Integer.toString(i));
        	}
        }
        return s;
        
    }
}
