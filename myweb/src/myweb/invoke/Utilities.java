package myweb.invoke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Utilities {
	public static String stringClean(String input) {
		
		ArrayList<Character> list = new ArrayList<Character>();
		Character previous = null;
		
		for(int i=0;i<input.length();i++) {
			Character ch = input.charAt(i);
			if(previous != null && previous == ch) {
				//do nothing
			}else {
				list.add(ch);
			}
			
			previous = ch;
		}
		
		StringBuilder str = new StringBuilder();
	    for (Character character : list) {// put every char into string builder
	        str.append(character);
	    }
	    System.out.println("output string:" + str.toString());
		
		return str.toString();
	}
	
	public static int maxBlock(String input) {
		
		int counter = 1;
		int max_count = 1;
		Character previous = null;
		
		for(int i=0;i<input.length();i++) {
			Character ch = input.charAt(i);
			if(previous != null && previous == ch) {
				counter++;
				
				if(counter>max_count) {
					max_count = counter;
				}
			}else {
				counter=1;
			}
			
			previous = ch;
		}
		
		
	    System.out.println("max block:" + max_count);
		
		return max_count;
	}
	
	public static String reorderBlock(String input) {
		char ch[] = input.toCharArray();
		
		System.out.println("reordering string:" + String.valueOf(ch));

		int count = ch.length;
        
		for(int n=0;n<count;n++) {
		    for(int i=0, j=i+1;i<input.length()-1-n;i++,j++) {
		
		    	boolean i_isUpper=false;
		    	boolean j_isUpper=false;
		    	
				if(Character.isUpperCase(ch[i])){
					i_isUpper = true;
					ch[i]=Character.toLowerCase(ch[i]);
				}
				if(Character.isUpperCase(ch[j])){
					j_isUpper = true;
					ch[j]=Character.toLowerCase(ch[j]);
				}
				
				if(ch[i]>ch[j]) {
					char a = ch[i];
					ch[i] = ch[j];
					ch[j] = a;
					
					if(i_isUpper) {
						ch[j]=Character.toUpperCase(ch[j]); //bug fixed
					}
					if(j_isUpper) {
						ch[i]=Character.toUpperCase(ch[i]); //bug fixed
					}
					
					System.out.println("swap"+ch[i]+"with"+ch[j]);
				}else {
				
					if(i_isUpper) {
						ch[i]=Character.toUpperCase(ch[i]);
					}
					if(j_isUpper) {
						ch[j]=Character.toUpperCase(ch[j]);
					}
				
				}
			
		    }
		}
			
		String r = String.valueOf(ch); 
		
        System.out.println("reordered string:" + r);
		
		return r;
		
		
		
	}
	
	
}
