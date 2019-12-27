package com;

public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        String temp = "";
        for(int i=0;i<address.length();++i) {
            if(address.charAt(i) == '.') {
                temp+="[.]";
            } else {
                temp+= address.charAt(i);
            }
        }
        return temp;
    }
}
