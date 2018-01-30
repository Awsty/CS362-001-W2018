package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable time = new TimeTable();
		 LinkedList<Appt> ALists = new LinkedList<Appt>();

		 Appt getAptData = new Appt(12, 01,01,01,2018,"Title", "Description");
		 ALists.add(getAptData);

		 Appt getAptData2 = new Appt(12, 01,01,01,2018,"Title", "Description");
		 ALists.add(getAptData2);

		 Appt getAptData3 = new Appt(12, 01,01,01,2018,"Title", "Description");
		 ALists.add(getAptData3);

		 Appt getAptData4 = new Appt(12, 01,01,01,2018,"Title", "Description");
		 ALists.add(getAptData4);

		 Appt getAptData5 = new Appt(12, 01,01,01,2018,"Title", "Description");
		 ALists.add(getAptData5);

		 Appt getAptData6 = new Appt(12, 01,01,01,2018,"Title", "Description");
		 ALists.add(getAptData6);

		 Appt getAptData7 = new Appt(12, 01,01,01,2018,"Title", "Description");
		 ALists.add(getAptData7);

		 Appt error = new Appt(26, 01, 13, 01, 01, null, null);
		 Appt blankData = new Appt(6, 01, 13, 01, 01, null, null);
		 assertNull(time.deleteAppt(null, getAptData));



		 assertNull(time.deleteAppt(ALists, null));
		 assertNull(time.deleteAppt(ALists, error));
		 assertNull(time.deleteAppt(ALists, blankData));



	 }


	 @Test
	  public void test02()  throws Throwable  {
		 LinkedList<Appt> ListA = new LinkedList<Appt>();
		 LinkedList<Appt> ListA2 = new LinkedList<Appt>();
		 TimeTable time = new TimeTable();


		 Appt VarA = new Appt(01,01,01,01,2018, "Title", "Description");
		 ListA.add(VarA);

		 Appt VarB = new Appt(01,01,01,01,2018, "Title", "Description");
		 ListA.add(VarB);

		 Appt VarC = new Appt(01,01,01,01,2018, "Title", "Description");
		 ListA.add(VarC);

		 Appt VarD = new Appt(01,01,01,01,2018, "Title", "Description");
		 ListA.add(VarD);

		 Appt VarE = new Appt(01,01,01,01,2018, "Title", "Description");
		 ListA.add(VarE);

		 int[] array = {2,4,6,8,10,12};

		 try {
			 ListA2 = time.permute(ListA, array);
			 fail("Expecting exception: IllegalArgumentException");
		 } catch (IllegalArgumentException e) {}

	 }

	 @Test
	 public void test03()  throws Throwable  {

		 TimeTable time = new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 LinkedList<Appt> ListA = new LinkedList<Appt>();
		 LinkedList<Appt> ListA2 = new LinkedList<Appt>();
		 LinkedList<Appt> ListA3 = new LinkedList<Appt>();
		 LinkedList<Appt> ListA4 = new LinkedList<Appt>();
		 LinkedList<Appt> ListA5 = new LinkedList<Appt>();
		 LinkedList<Appt> ListA6 = new LinkedList<Appt>();



		 Appt VarA = new Appt(01,01,01,01,01, "Testing", "Description");
		 ListA.add(VarA);

		 Appt VarB = new Appt(01,01,01,01,01, "Testing", "Description");
		 ListA.add(VarB);

		 Appt VarC = new Appt(01,01,01,01,01, "Testing", "Description");
		 ListA.add(VarC);

		 Appt VarD = new Appt(01,01,01,01,01, "Testing", "Description");
		 ListA.add(VarD);

		 Appt VarE = new Appt(01,01,01,01,01, "Testing", "Description");
		 ListA.add(VarE);

		 Appt VarF = new Appt(01,01,01,01,01, "Testing", "Description");
		 ListA2.add(VarF);

		 Appt appt_invalid = new Appt(26,1,1,1,1, null, null);
		 ListA3.add(appt_invalid);
		 ListA3.add(VarB);

		 int[] s = {0};

		 Appt appt_recurMonthly = new Appt(2,2,11,1,4, "Monthly", "Monthly");
		 appt_recurMonthly.setRecurrence(s, appt_recurMonthly.RECUR_BY_MONTHLY,1,2);
		 ListA4.add(appt_recurMonthly);

		 Appt appt_recurWeekly = new Appt(2,2,4,1,4, "Weekly", "Weekly");
		 appt_recurWeekly.setRecurrence(s, appt_recurWeekly.RECUR_BY_WEEKLY,1,2);
		 ListA5.add(appt_recurWeekly);

		 Appt appt_recurYearly = new Appt(2,2,11,2,3, "Yearly", "Yearly");
		 appt_recurYearly.setRecurrence(s, appt_recurYearly.RECUR_BY_YEARLY,1,2);
		 ListA6.add(VarB);
		 ListA6.add(appt_recurYearly);

		 GregorianCalendar Day1 = new GregorianCalendar(1,1,1);
		 GregorianCalendar Day2 = new GregorianCalendar(2,2,2);

		 try {
			 calDays = time.getApptRange(ListA, Day2, Day1);
			 fail("Second date specified is not before the first date specified.");
		 } catch(DateOutOfRangeException e) {}



	 }

	 @Test
	 public void test04()  throws Throwable  {

	 }




//add more unit tests as you needed
}
