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
	 	//assertEquals(VarB, CDay.getAppts().get(0));

	 }
	 @Test
	  public void test02()  throws Throwable  {

	 	Calendar CD = Calendar.getInstance();
	 	int thisDay;
	 	int thisMonth;
	 	int thisYear;

	 	thisDay=CD.get(Calendar.DAY_OF_MONTH);
	 	thisMonth=CD.get(Calendar.MONTH) +1;
		thisYear=CD.get(Calendar.YEAR);

		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);

		CalDay CD2 = new CalDay(today);

		thisDay=10;
		thisMonth=9;
		thisYear =2018;
		GregorianCalendar date = new GregorianCalendar(thisYear, thisMonth, thisDay);

		CalDay CD1 = new CalDay(date);
		assertEquals(thisYear, CD1.getYear());
		assertEquals(thisMonth, CD1.getMonth());
		assertEquals(thisDay, CD1.getDay());
		CD1.toString();

		int startHour = 12;
		int startMinute =10;
		int startDay = 10;
		int startMonth = 10;
		int startYear = 2018;

		String title = "Title";
		String description = "Description";

		Appt appt = new Appt(startHour, startMinute,startDay,startMonth,startYear,title,description);
		CD2.addAppt(appt);
		assertEquals(12,CD2.getAppts().get(0).getStartHour());
		assertEquals(10,CD2.getAppts().get(0).getStartMinute());
		assertEquals(10,CD2.getAppts().get(0).getStartDay());
		assertEquals(10,CD2.getAppts().get(0).getStartMonth());
		assertEquals(2018,CD2.getAppts().get(0).getStartYear());

		 int startMin = 15;
		 Appt a1 = new Appt(startHour, startMin , startDay , startMonth, startYear , title, description);
		 CD2.addAppt(a1);

		 int testHour1 = 13;
		 Appt a2 = new Appt(testHour1, startMinute , startDay , startMonth , startYear , title, description);
		 CD2.addAppt(a2);
		 assertEquals( 13, CD2.getAppts().get(2).getStartHour());

		 int testHour2 = 19;
		 Appt a3 = new Appt(testHour2, startMinute , startDay , startMonth , startYear , title, description);
		 CD2.addAppt(a3);
		 assertEquals( 19, CD2.getAppts().get(3).getStartHour());

		 int testHour3 = 22;
		 Appt a4 = new Appt(testHour3, startMinute , startDay , startMonth , startYear , title, description);
		 CD2.addAppt(a4);
		 assertEquals( 22, CD2.getAppts().get(4).getStartHour());

		 int testHour4 = 25;
		 Appt a5 = new Appt(testHour4, startMinute , startDay , startMonth , startYear , title, description);

		 CD2.addAppt(a5);
		 assertEquals( 22, CD2.getAppts().get(4).getStartHour());
		 assertEquals(5, CD2.getSizeAppts());
		 assertNotEquals("test", CD2.toString());

		 CalDay CD3 = new CalDay();
		 assertNotEquals("test", CD3.toString());
		 assertNotEquals(null, CD2.iterator());
		 assertEquals(null, CD3.iterator());

	 }

	@Test
	public void test03()  throws Throwable  {
		CalDay CD = new CalDay();
		assertFalse(CD.isValid());
		CD.toString();
		CD.iterator();
		assertEquals("", CD.toString());
	}

	@Test
	public void test04()  throws Throwable  {
		Calendar CD = Calendar.getInstance();
		int thisDay;
		int thisMonth;
		int thisYear;

		thisDay=CD.get(Calendar.DAY_OF_MONTH);
		thisMonth=CD.get(Calendar.MONTH) +1;
		thisYear=CD.get(Calendar.YEAR);

		GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		CalDay CD2 = new CalDay(today);

		thisDay=10;
		thisMonth=9;
		thisYear =2018;
		GregorianCalendar date = new GregorianCalendar(thisYear, thisMonth, thisDay);

		CalDay CD1 = new CalDay(date);
		assertEquals(thisYear, CD1.getYear());
		assertEquals(thisMonth, CD1.getMonth());
		assertEquals(thisDay, CD1.getDay());
		CD1.toString();

		int startHour = 12;
		int startMinute =10;
		int startDay = 10;
		int startMonth = 10;
		int startYear = 2018;

		String title = "Title";
		String description = "Description";

		Appt appt = new Appt(startHour, startMinute,startDay,startMonth,startYear,title,description);
		CD2.addAppt(appt);
		assertEquals(12,CD2.getAppts().get(0).getStartHour());
		assertEquals(10,CD2.getAppts().get(0).getStartMinute());
		assertEquals(10,CD2.getAppts().get(0).getStartDay());
		assertEquals(10,CD2.getAppts().get(0).getStartMonth());
		assertEquals(2018,CD2.getAppts().get(0).getStartYear());

		int startMinute1 = 15;
		Appt a1 = new Appt(startHour, startMinute1 , startDay , startMonth, startYear , title, description);
		CD2.addAppt(a1);
		assertEquals( 10, CD2.getAppts().get(1).getStartDay());
		assertEquals( 10, CD2.getAppts().get(1).getStartMonth());
		assertEquals( 12, CD2.getAppts().get(1).getStartHour());
		assertEquals( 15, CD2.getAppts().get(1).getStartMinute());

		assertNotEquals("test", CD2.toString());

		CalDay CD3 = new CalDay();
		assertNotEquals("test", CD3.toString());
		assertNotEquals(null, CD2.iterator());
		assertEquals(null, CD3.iterator());
	}
	@Test
	public void test05()  throws Throwable  {



	}

	@Test
	public void test06()  throws Throwable  {

	}

	@Test
	public void test07()  throws Throwable  {

	}

}
