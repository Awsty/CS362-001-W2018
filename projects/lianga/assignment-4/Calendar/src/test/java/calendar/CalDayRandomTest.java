package calendar;


import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

import jdk.nashorn.internal.ir.CatchNode;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {


		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...");

		 try {
			 long randomseed =System.currentTimeMillis();
			 Random random = new Random(randomseed);

			 int day = 26;
			 int month = 2;
			 int year = 2018;

			 GregorianCalendar gc = new GregorianCalendar(year, month, day);
			 CalDay cal = new CalDay(gc);


			 for(int i = 0; i<NUM_TESTS ; i++){
				 int startHour = ValuesGenerator.RandInt(random);

				 Appt test1 = new Appt(startHour, 02, 26, 2, 2018, "Title", "Description");
				 Appt test2 = new Appt(startHour, 00, 26, 2, 2018, "Title2", "Description2");


				 cal.addAppt(test1);
				 cal.addAppt(test2);

			 }
		 }
		 catch(NullPointerException e){

		 }




	 }


	
}
