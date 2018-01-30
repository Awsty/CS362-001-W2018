package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	int startHour = 10;
	 	int startMinute = 10;
	 	int startDay = 10;
	 	int startMonth = 10;
	 	int startYear = 2018;
	 	String title = "Title";
	 	String description = "Testing";
	 	GregorianCalendar Cal = new GregorianCalendar(1,1,1);
	 	CalDay CDay = new CalDay(Cal);
	 	Appt VarA = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
	 	Appt VarB = new Appt(10,10,10,10,2018,"Title","Testing");
	 	CDay.addAppt(VarA);
	 	CDay.addAppt(VarB);
	 	assertEquals(VarB, CDay.getAppts().get(0));
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
