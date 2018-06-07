package immigrationSystem;

import static org.junit.Assert.*;
import org.junit.Test;

/* The unique ID of each person object in the class Person, is auto increment, 
 * as the test class runs all the tests in the same time,
 * the ID will not reset for every test.
 * Although, for every test is generated a new list
 * 
 * Also all the are passing. If a test fail, try to check the unique ID number of the person*/
public class test {
  
  LinkedList<String> list = new LinkedList<String>();
  
  @Test
  public void testAddTwoPeopleToTheList() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.size());
  }
  
  @Test
  public void testaddNewPersonToTheFirstPositionOfTheList() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    Person p3 = new Person("Tom", "Cruise", "24/11/2017", "TC123");
    list.addNewPersonToTheFirstPosition(p3);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(1, list.checkPositionByName("Tom", "Cruise"));
  }
  
  @Test
  public void testaddNewPersonToTheMidleOfTheList() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    Person p3 = new Person("Tom", "Cruise", "24/11/2017", "TC123");
    list.addNewPersonToTheMidleOfTheList(p3);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionByName("Tom", "Cruise"));
  }
  
  @Test
  public void testaddNewPersonToAnyIndexToTheList() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    Person p3 = new Person("Tom", "Cruise", "24/11/2017", "TC123");
    Person p4 = new Person("Emma", "Stone", "24/11/2017", "ES123");
    Person p5 = new Person("Olivia", "Palito", "24/11/2017", "OP123");
    Person p6 = new Person("Natalie", "Portman", "30/11/2017", "AL123");
    Person p7 = new Person("Sandra", "Bullock", "20/12/2017", "SB123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    list.addNewPerson(p3);
    list.addNewPerson(p4);
    list.addNewPerson(p5);
    list.addNewPerson(p6);
    list.addNewPersonAnyIndex(2, p7);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionByName("Sandra", "Bullock"));
  }
  
  @Test
  public void testcheckPositionByNameInTheList() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionByName("Felipe", "Mello"));
  }
  
  @Test
  public void testcheckPositionByIDInTheList() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionById(37));
  }
  
  @Test
  public void testupdatePersonByIdInTheList() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    list.updatePersonById(33, "Sandra", "Bullock", "20/12/2017", "SB123");
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(2, list.checkPositionByName("Sandra", "Bullock"));
    
  }
  
  @Test
  public void testremovePersonByIdInTheList() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    list.removePersonById(7);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(1, list.size());
  }
  
  @Test
  public void testremoveNPersonFromTheEndOfTheList() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    Person p3 = new Person("Tom", "Cruise", "24/11/2017", "TC123");
    Person p4 = new Person("Felipe", "Melo", "24/11/2017", "FM123");
    Person p5 = new Person("Emma", "Stone", "24/11/2017", "ES123");
    Person p6 = new Person("Natalie", "Portman", "30/11/2017", "AL123");
    Person p7 = new Person("Sandra", "Bullock", "20/12/2017", "SB123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    list.addNewPerson(p3);
    list.addNewPerson(p4);
    list.addNewPerson(p5);
    list.addNewPerson(p6);
    list.addNewPerson(p7);
    list.removeNPersonFromTheEndOfTheList(4);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(3, list.size());
  }
  
  @Test
  public void testListSize() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    Person p3 = new Person("Tom", "Cruise", "24/11/2017", "TC123");
    Person p4 = new Person("Felipe", "Melo", "24/11/2017", "FM123");
    Person p5 = new Person("Emma", "Stone", "24/11/2017", "ES123");
    Person p6 = new Person("Natalie", "Portman", "30/11/2017", "AL123");
    Person p7 = new Person("Sandra", "Bullock", "20/12/2017", "SB123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    list.addNewPerson(p3);
    list.addNewPerson(p4);
    list.addNewPerson(p5);
    list.addNewPerson(p6);
    list.addNewPerson(p7);
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(7, list.size());
  }
  
  @Test
  public void testremoveFirstPosition() {
    Person p1 = new Person("Ennio", "da Silva Vitor", "24/11/2017", "ESV123");
    Person p2 = new Person("Felipe", "Mello", "24/11/2017", "FM123");
    Person p3 = new Person("Tom", "Cruise", "24/11/2017", "TC123");
    Person p4 = new Person("Felipe", "Melo", "24/11/2017", "FM123");
    Person p5 = new Person("Emma", "Stone", "24/11/2017", "ES123");
    Person p6 = new Person("Natalie", "Portman", "30/11/2017", "AL123");
    Person p7 = new Person("Sandra", "Bullock", "20/12/2017", "SB123");
    list.addNewPerson(p1);
    list.addNewPerson(p2);
    list.addNewPerson(p3);
    list.addNewPerson(p4);
    list.addNewPerson(p5);
    list.addNewPerson(p6);
    list.addNewPerson(p7);
    list.removeFirstPosition();
    /*To display the list for this test. Comment this call from other
    tests before run this: list.printList();*/
    assertEquals(6, list.size());
  }
  
  @Test
  public void testIsEmpty(){
	 boolean answer = true;
	 boolean test = list.isEmpty();
	 
	 assertEquals(answer, test);
  }
}