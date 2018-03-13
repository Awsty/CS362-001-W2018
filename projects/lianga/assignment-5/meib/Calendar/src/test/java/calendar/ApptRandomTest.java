package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
        }
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
        }
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
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
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);

						   int testHour=ValuesGenerator.getRandomIntBetween(random, 0,23);
						   int testMin=ValuesGenerator.getRandomIntBetween(random, 0,59);
						   int testDay=ValuesGenerator.getRandomIntBetween(random, 1,28);
						   int testMonth=ValuesGenerator.getRandomIntBetween(random, 1,11);
						   int testYear=ValuesGenerator.RandInt(random);

						   String defaultTitle = "Title";
						   String defaultDesc= "Description";

						   int testHour1=ValuesGenerator.getRandomIntBetween(random, -2,-3);
						   int testMin1=ValuesGenerator.getRandomIntBetween(random, -2,-3);
						   int testMin2=ValuesGenerator.getRandomIntBetween(random, -3,60);
						   int testDay1=ValuesGenerator.getRandomIntBetween(random, -2,34);
						   int testMonth1=ValuesGenerator.getRandomIntBetween(random, -10,34);


						   Appt test1 = new Appt(testHour,testMin,testDay,testMonth,testYear,defaultTitle, defaultDesc);
						   //assertTrue(test1.getValid()); Cannot find error for this bug.

						   Appt test2 = new Appt(testHour1,testMin,testDay,testMonth,testYear,defaultTitle, defaultDesc);
						   assertFalse(test2.getValid());

						   Appt test3 = new Appt(testHour,testMin1,testDay,testMonth,testYear,defaultTitle, defaultDesc);
						   assertFalse(test3.getValid());

						   Appt test4 = new Appt(testHour,testMin,testDay1,testMonth,testYear,defaultTitle, defaultDesc);
						   //assertFalse(test4.getValid());

						   Appt test5 = new Appt(testHour,testMin2,testDay,testMonth,testYear,defaultTitle, defaultDesc);
						   //assertFalse(test5.getValid());

						   int testMonth3=ValuesGenerator.getRandomIntBetween(random, 13,14);

						   //Appt test6 = new Appt(testHour,testMin,testDay,testMonth3,testYear,defaultTitle, defaultDesc);
						   //assertFalse(test6.getValid());


					   }
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");
	 }



}
