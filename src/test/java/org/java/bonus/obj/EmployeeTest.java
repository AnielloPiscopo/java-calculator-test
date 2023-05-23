package org.java.bonus.obj;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.LocalDate;
import java.util.Random;

import org.java.helper.Helper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class EmployeeTest {
	private Employee e = new Employee();
	private static final int RND_BOUND = 10;
	private static final int NUM_TESTS = 10;
	private static final String[] ROLES_LIST = {"employee" , "boss"};
	private static String name;
	private static String surname;
	private static LocalDate birthDay;
	private static String role;
	
	@BeforeEach
	public void init() {
		name = Helper.getCapitalizedStr(Helper.generateRandomWord(RND_BOUND));
		surname = Helper.getCapitalizedStr(Helper.generateRandomWord(RND_BOUND));
		birthDay = Helper.generateRndDate();
		setRole();
	}
	
	@RepeatedTest(NUM_TESTS)
	public void setNameTest() {
		assumeTrue(!name.isBlank());
		assertNotEquals("" , name , "Creazione nome per employee");
		
	}
	
	@RepeatedTest(NUM_TESTS)
	public void setNameExTest() {
		assumeTrue(surname.isBlank());
		
		assertThrows(Exception.class,
				() -> e.setName(surname),
				"Deve sollevare eccezione");
	}
	
	@RepeatedTest(NUM_TESTS)
	public void setSurnameTest() {
		assumeTrue(!surname.isBlank());
		assertNotEquals("" , surname , "Creazione cognome per employee");
		
	}
	
	@RepeatedTest(NUM_TESTS)
	public void setSurnameExTest() {
		assumeTrue(surname.isBlank());
		
		assertThrows(Exception.class,
				() -> e.setName(surname),
				"Deve sollevare eccezione");
	}
	
	@RepeatedTest(NUM_TESTS)
	public void setBirthDayTest() {
		assumeTrue(!(birthDay.compareTo(LocalDate.now())>0));
		assertNotEquals(LocalDate.now() , birthDay , "Creazione data di nascita per employee");
	}
	
	@RepeatedTest(NUM_TESTS)
	public void setBirthDayExTest() throws Exception {
		assertTrue(birthDay.compareTo(LocalDate.now())>0);
		assertThrows(Exception.class, () -> e.setBirthDay(birthDay),"Deve sollevare un eccezione");
	}
	
	@RepeatedTest(NUM_TESTS)
	public void setRoleTest() {
		assumeTrue(role == "employee" || role == "boss");
		assertNotEquals("employee" , role , "Creazione data di nascita per employee");
		assertNotEquals("boss" , role , "Creazione data di nascita per employee");
	}
	
	@RepeatedTest(NUM_TESTS)
	public void setRoleExTest() throws Exception {
		assertTrue(!(role == "employee" && role == "boss"));
		assertThrows(Exception.class, () -> e.setRole(role),"Deve sollevare un eccezione");
	}
	
	public void setRole() {
		Random rnd = new Random();
		int longestRoleStrLength = Helper.getFromArrayTheLongestStr(ROLES_LIST).length();
		int rndNum = rnd.nextInt(longestRoleStrLength + RND_BOUND);
		role = ROLES_LIST[rndNum];
	}
}
