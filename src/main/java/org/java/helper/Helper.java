package org.java.helper;

import java.time.LocalDate;
import java.util.Random;

public abstract class Helper {
	public static String generateRandomWord(int wordLength) {
	    Random r = new Random(); // Intialize a Random Number Generator with SysTime as the seed
	    StringBuilder sb = new StringBuilder(wordLength);
	    for(int i = 0; i < wordLength; i++) { // For each letter in the word
	        char tmp = (char) ('a' + r.nextInt('z' - 'a')); // Generate a letter between a and z
	        sb.append(tmp); // Add it to the String
	    }
	    return sb.toString();
	}
	
	public static void isStrBlank(String str) throws Exception {
		if(str.isBlank()) throw new Exception("La stringa non pùò essere vuota");
	}
	
	public static void isDateTakedPlace(LocalDate d) throws Exception {
		if(d.compareTo(LocalDate.now())>0) throw new Exception("La data non è ancora venuta");
	}
	
	public static void isStrContainsWhiteSpaces(String str) throws Exception {
		if(str.contains("\\s")) throw new Exception("La stringa non può contenere spazi bianchi all'interno");
	}
	
	public static String getCapitalizedStr(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	public static String getFromArrayTheLongestStr(String[] list) {
		String longestStr = "";
		for(String element : list) {
			if(element.length() > longestStr.length()) longestStr = element; 
		}
		return longestStr;
	}
	
	public static LocalDate generateRndDate() {
		Random rnd = new Random();
		int minYear = 1900;
		int maxyear = LocalDate.now().getYear();
		int minDay = (int) LocalDate.of(minYear, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(maxyear, 1, 1).toEpochDay();
		long randomDay = minDay + rnd.nextInt(maxDay - minDay);

		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		return randomDate;
	}
}
