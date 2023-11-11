package com.shaikezr.jalpha;

import java.util.List;
import java.util.ArrayList;

class Jalpha {
	public String stringSort(String input, boolean toLower) {
		// takes a string, returns the string sorted by ascii 
		// char code
		// @param input: string to be sorted. Can be any ascii character
		// @param toLower: boolean. When true, will try to convert the char to lowercase before sorting
		// Return: String sorted by ascii count

		// first: build the hash (ret: List<Integer>)			
		int minValue = -1;
		int maxValue = -1;
		// iterate over the chars in the str
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			// for each char, if toLower, try converting it to lowercase
			if (toLower) {
				try {
					c = Character.toLowerCase(c);
				} catch(Exception e) {
					;
				}
			}
			// convert the char to its ascii hash code 
			int hashCode = c.hashCode();
			if (minValue == -1 || minValue > hashCode) {
				minValue = hashCode;
			}
			if (maxValue == -1 || maxValue > hashCode) {
				maxValue = hashCode;
			}

		}
		int range = maxValue - minValue;
		List<Integer> hash = new ArrayList<Integer>(range);
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			// for each char, if toLower, try converting it to lowercase
			if (toLower) {
				try {
					c = Character.toLowerCase(c);
				} catch(Exception e) {
					;
				}
			}
			// convert the char to its shifted ascii hash code 
			int hashCode = c.hashCode();
			int shiftedCode = hashCode - minValue;
			// increment the count
			if (hash.get(shiftedCode) == null) {
				hash.set(shiftedCode, 1);
			}
			else {
				hash.set(shiftedCode, hash.get(shiftedCode) + 1);
			}

		}
		// next, apply the sort (ret: String):
		StringBuffer sb = new StringBuffer();
		// iterate over the integers in the hash
		for (int ind = 0; i < hash.size(); ind++) {
			Integer i = hash.get(ind);
			if (i != null) {
				for (int j = 0; j < i; j ++) {
					//unshift the hashcode
					int shiftedCode = ind + minValue;
					//convert the hashcode to ascii
					char ch = (char) shiftedCode;
					//add the ascii to the string buffer
					sb.append(Character.toString(ch));
				}
			}
		}
		//return the stringbuffer toString
		return sb.toString();		
	}
//Runtime complexity: 2n + k where n is length of str, k is range hashCodes
//note: if applied to ascii chars only, range is restricted to 255 max, so k is 
//not significantly differentiated from a c constant at that point
}
