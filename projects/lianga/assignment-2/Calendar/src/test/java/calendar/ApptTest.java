package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }

	  @Test //the point of this unit test is to see what happens when I apply for a new appointment with no names or description.
	  public void test02()  throws Throwable  {
	     int startHour=12;
	     int startMinute=12;
	     int startDay=12;
	     int startMonth=12;
	     int startYear=2018;
	     String title=null;
	     String description=null;

	     Appt appt = new Appt(12,
                 12,
                 12,
                 12,
                 2018,
                 "",
                 "");

	     appt.setStartHour(startHour);
	     appt.setStartMinute(startMinute);
	     appt.setStartDay(startDay);
	     appt.setStartMonth(startMonth);
	     appt.setStartYear(startYear);
	     appt.setTitle(title);
	     appt.setDescription(description);
	     //assertions, make the appointments.

          assertEquals(12, appt.getStartHour());
          assertEquals(12, appt.getStartMinute());
          assertEquals(12, appt.getStartDay());
          assertEquals(12, appt.getStartMonth());
          assertEquals(2018, appt.getStartYear());
          assertEquals("", appt.getTitle());
          assertEquals( "", appt.getDescription());
             }
	//testing setting methods




//add more unit tests as you needed


    //testing multiple appointments with one another to see if others exist already.

    @Test
    public void test03() throws Throwable{

        Appt tempCheckForMultiples = new Appt(01, 00, 20, 1, 2018, "Class", "CS362");

        Appt tempCheckForMultiples2 = new Appt(0, 00, 20, 1, 2018, "Class", "PSY340");

        Appt tempCheckForMultiples3 = new Appt(1, 2, 3, 4, 5, "Same", "Same");

        Appt tempCheckForMultiples4 = new Appt(1, 2, 3, 4, 5, "Same", "Same");

        //The test will be false
        assertEquals(1, tempCheckForMultiples.compareTo(tempCheckForMultiples2));

        assertEquals(0, tempCheckForMultiples3.compareTo(tempCheckForMultiples4));


    }



    // Testing if validation is correctly prompted and used.
	 @Test
     public void test04() throws Throwable{
	     //Tests true cases that numbers that are positive and present/future tense will work.
	     Appt isValApt = new Appt(12, 01,13, 8,2018, "Test", "Test");
         assertEquals(true, isValApt.getValid());

         Appt isValApt2 = new Appt(12, 01,17, 9, 2018, "", "Blank Test");
         assertEquals(true, isValApt2.getValid());

         Appt isValApt3 = new Appt(12, 01,14, 7,2018, "Nothing", "");
         assertEquals(true, isValApt3.getValid());

         //Testing negative value to see if its possible. This is wrong. This will be rejected and returned as false.
         Appt isValApt4 = new Appt(-1, 1,1, 1,1, "", "");
         assertEquals(false, isValApt4.getValid());

         //Tests that there is no such thing as a 24 hours. We only accept 23 hours.
         Appt isValApt5 = new Appt(24, 1,1, 1,1, "", "");
         assertEquals(false, isValApt5.getValid());

         // no such thing as 60 minutes. This does not exist therefore is false.
         Appt isValApt6 = new Appt(1, 60,1, 1,1, "", "");
         assertEquals(false, isValApt6.getValid());

         //there is no such thing as a negative day to start. False.
         Appt isValApt7 = new Appt(1, 1,-1, 1,1, "", "");
         assertEquals(false, isValApt7.getValid());

         //there are no 33 days in a month. Only accepts 1-29
         Appt isValApt8 = new Appt(1, 1,33, 1,1, "", "");
         assertEquals(false, isValApt8.getValid());

         //minutes cannot be negative also.
         Appt isValApt9 = new Appt(1, -1,1, 1,1, "", "");
         assertEquals(false, isValApt9.getValid());


     }

    @Test
    public void test05() throws Throwable {
        Appt Rep = new Appt(12, 30, 12, 9, 2018, "Concert", "Kanye");
        String strRep = "\t"+ 9 +"/"+12+"/"+2018+" at "+12+":" + 30 +"pm"+" ,"+"Concert"+", "+"Kanye"+"\n";

        assertEquals(strRep, Rep.toString());

    }

    /*
     * Testing CompareTo method
     */




}
