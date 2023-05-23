package org.java.main;

import java.time.LocalDate;

import org.java.helper.*;

public class Main {
	public static void main(String[] args) {
		LocalDate rnd = Helper.generateRndDate();
		System.out.println(rnd);
	}
}
