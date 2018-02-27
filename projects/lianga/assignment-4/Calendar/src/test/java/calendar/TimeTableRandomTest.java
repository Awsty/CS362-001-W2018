package calendar;

import java.util.Calendar;
import java.util.Random;
import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final int NUM_TESTS=100;



	/**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long randomseed =System.currentTimeMillis();
		 Random random = new Random(randomseed);

		 int Day0=1;

		 int Day= 5;
		 int startMonth = 02;
		 int startYear = 2018;

		 int Day2=27;
		 int startMonth2=03;
		 int startYear2=2018;

		 int[] recur = new int[]{1};
		 TimeTable t = new TimeTable();



		 for(int i =0; i < NUM_TESTS; i++){
		 	int startHour=ValuesGenerator.RandInt(random);
		 	int startHour2=ValuesGenerator.RandInt(random);

		 	int startDay=ValuesGenerator.RandInt(random);
		 	int startDay2=ValuesGenerator.RandInt(random);
		 	int startDay3=ValuesGenerator.RandInt(random);


		 	String defaultTitle="Title";
		 	String defaultDesc="Description";

		 	Appt test1= new Appt(startHour, 02, startDay,02,2018,defaultTitle,defaultDesc);
		 	Appt test2= new Appt(startHour2, 02, startDay2,02,2018,defaultTitle,defaultDesc);
		 	Appt test3= new Appt(startHour, 02, startDay3,02,2018,defaultTitle,defaultDesc);
		 	Appt test4= new Appt(startHour2, 01, startDay3,02,2018,defaultTitle,defaultDesc);


		 	test1.setRecurrence(recur,2,2,test1.RECUR_NUMBER_FOREVER);
		 	test2.setRecurrence(recur,1,2,test2.RECUR_NUMBER_FOREVER);
		 	test3.setRecurrence(recur,3,2,test3.RECUR_NUMBER_FOREVER);
		 	test4.setRecurrence(recur,3,2,test4.RECUR_NUMBER_FOREVER);


			 LinkedList<Appt> list2 = null;
			 LinkedList<Appt> list = new LinkedList<Appt>();


		 	GregorianCalendar gc = new GregorianCalendar(startYear, startMonth, Day);
		 	GregorianCalendar gc2 = new GregorianCalendar(startYear2, startMonth2, Day2);
		 	GregorianCalendar gc3 = new GregorianCalendar(startYear2, startMonth2, Day0);


			 list.add(test1);
			 list.add(test2);
			 list.add(test3);
			 list.add(test4);//another test num?


			 try{
		 		t.getApptRange(list, gc, gc2);
		 		t.getApptRange(list, gc2, gc3);

				 //t.getApptRange(list2, gc, gc2);
			 }
			 catch(DateOutOfRangeException e){
			 	continue;
			 }

			 t.deleteAppt(list,test1);
			 t.deleteAppt(list,test3);
			 t.deleteAppt(list2,test1);
			 t.deleteAppt(list,null);
		 }



	 }



}
