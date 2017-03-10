package com.roman.util;
import java.util.*;

public class Arrays {
	private Arrays() {}
	
	@SafeVarargs
	public static <T> String toString(T... array, boolean index) {
		String s = "[";
		for (int i = 0; i < array.length; i ++) {
			s += (!index ? (i != array.length - 1 ? array[i] + ", " : array[i]) : (i != array.length - 1 ? array[i] + " " + i + ", " : array[i] + " " + i + "]"));
		}
		return s;
	}
}
