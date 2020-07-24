package com.person.utils;

public class LieuHelpers {

	public String conversionLieu(String lieu) {
		String resultat = null;
		String a = String.valueOf(lieu.charAt(0)).toUpperCase();
		String b = (lieu.substring(1, lieu.length())).toLowerCase();
		
		resultat = a+b;
		
		return resultat;
	}
	
}
