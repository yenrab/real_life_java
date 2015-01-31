package com.real.java.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BusinessTest {
	Business testBusiness;
	Person bob, jose, sven, ingabrit, noFirstName, noLastName;
	@Before
	public void setUp() throws Exception {
		testBusiness = new Business();
		bob = new Person("Bob","Jones",23,"(208)555-1818");
		jose = new Person("Jose","Gomez",19,"(208)888-1900");
		sven = new Person("Sven","Anderson",19,"(208)888-1598");
		ingabrit = new Person("Ingabrit","Anderson", 19,"(208)888-1599");
		noFirstName = new Person(null,"Anderson",19,"(208)888-1599");
		noLastName = new Person("Joe",null,19,"(208)888-1599");
	}
    
	@Test
	public void testAddEmployee() {
		testBusiness.addEmployee(bob);
		int numEmployees = testBusiness.employees.size();
		assertEquals(1, numEmployees);
		
		testBusiness.addEmployee(jose);
		testBusiness.addEmployee(sven);
		testBusiness.addEmployee(ingabrit);
		numEmployees = testBusiness.employees.size();
		assertEquals(4,numEmployees);
		
		testBusiness.addEmployee(null);
		numEmployees = testBusiness.employees.size();
		assertEquals(4,numEmployees);
		
		testBusiness.addEmployee(noLastName);
		numEmployees = testBusiness.employees.size();
		assertEquals(4,numEmployees);
        
		testBusiness.addEmployee(noFirstName);
		numEmployees = testBusiness.employees.size();
		assertEquals(4,numEmployees);
		
		testBusiness.employees.clear();
	}
    
	@Test
	public void testGetEmployee() {
		testBusiness.employees.put("Jones, Bob", bob);
		testBusiness.employees.put("Gomez, Jose",jose);
		testBusiness.employees.put("Anderson, Sven",sven);
		testBusiness.employees.put("Anderson, Ingabrit", ingabrit);
		
		Person bobFromMap = testBusiness.getEmployee("Jones, Bob");
		assertEquals(bob, bobFromMap);
		Person joseFromMap = testBusiness.getEmployee("Gomez, Jose");
		assertEquals(jose, joseFromMap);
		Person svenFromMap = testBusiness.getEmployee("Anderson, Sven");
		assertEquals(sven, svenFromMap);
		Person ingabritFromMap = testBusiness.getEmployee("Anderson, Ingabrit");
		assertEquals(ingabrit, ingabritFromMap);
		
		Person notEmployee = testBusiness.getEmployee("Body, No");
		assertNull(notEmployee);
        
		testBusiness.employees.clear();
	}

    @Test
    public void testAddCustomer() {
        
        testBusiness.addCustomer(bob);
        int numEmployees = testBusiness.customerPhoneBook.size();
        assertEquals(1, numEmployees);
		
        testBusiness.addCustomer(jose);
        testBusiness.addCustomer(sven);
        testBusiness.addCustomer(ingabrit);
        numEmployees = testBusiness.customerPhoneBook.size();
        assertEquals(4,numEmployees);
		
        testBusiness.addCustomer(null);
        numEmployees = testBusiness.customerPhoneBook.size();
        assertEquals(4,numEmployees);
		
        testBusiness.addCustomer(noLastName);
        numEmployees = testBusiness.customerPhoneBook.size();
        assertEquals(4,numEmployees);
        
        testBusiness.addCustomer(noFirstName);
        numEmployees = testBusiness.customerPhoneBook.size();
        assertEquals(4,numEmployees);
		
        testBusiness.customerPhoneBook.clear();
    }
    @Test
    public void testGetCustomerPhoneNumber() {
        
        testBusiness.customerPhoneBook.put("Jones, Bob", bob.phoneNumber);
        testBusiness.customerPhoneBook.put("Gomez, Jose", jose.phoneNumber);
        testBusiness.customerPhoneBook.put("Anderson, Sven", sven.phoneNumber);
        testBusiness.customerPhoneBook.put("Anderson, Ingabrit", ingabrit.phoneNumber);
		
        String bobPhone = testBusiness.getCustomerPhoneNumber("Jones, Bob");
        assertEquals("(208)555-1818", bobPhone);
        
        String svenPhone = testBusiness.getCustomerPhoneNumber("Anderson, Sven");
        assertEquals("(208)888-1598", svenPhone);
        
        String nullPhone = testBusiness.getCustomerPhoneNumber(null);
        assertNull(nullPhone);
        
        String notCustomer = testBusiness.getCustomerPhoneNumber("Body, No");
        assertNull(notCustomer);
        testBusiness.customerPhoneBook.clear();
    }
    
    @Test
    public void testGetAllCustomerPhoneNumbers() {
        testBusiness.customerPhoneBook.put("Jones, Bob", bob.phoneNumber);
        testBusiness.customerPhoneBook.put("Gomez, Jose",jose.phoneNumber);
        testBusiness.customerPhoneBook.put("Anderson, Sven" , sven.phoneNumber);
        testBusiness.customerPhoneBook.put("Anderson, Ingabrit", ingabrit.phoneNumber);
		
        String phoneBook = testBusiness.getAllCustomerPhoneNumbers();
        String expected = "Anderson, Ingabrit - (208)888-1599; Anderson, Sven - (208)888-1598; Gomez, Jose - (208)888-1900; Jones, Bob - (208)555-1818; ";
        assertEquals(expected, phoneBook);
        testBusiness.customerPhoneBook.clear();
    }