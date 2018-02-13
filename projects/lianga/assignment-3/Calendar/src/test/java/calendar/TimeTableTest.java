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
    public void test01() throws Throwable {
        TimeTable time = new TimeTable();
        LinkedList<Appt> ALists = new LinkedList<Appt>();

        Appt getApt = new Appt(12, 01, 01, 01, 2018, "Title", "Description");
        ALists.add(getApt);

        Appt getApt2 = new Appt(12, 01, 01, 01, 2018, "Title", "Description");
        ALists.add(getApt2);

        Appt getApt3 = new Appt(12, 01, 01, 01, 2018, "Title", "Description");
        ALists.add(getApt3);

        Appt getApt4 = new Appt(12, 01, 01, 01, 2018, "Title", "Description");
        ALists.add(getApt4);

        Appt getApt5 = new Appt(12, 01, 01, 01, 2018, "Title", "Description");
        ALists.add(getApt5);

        Appt getApt6 = new Appt(12, 01, 01, 01, 2018, "Title", "Description");
        ALists.add(getApt6);

        Appt getApt7 = new Appt(12, 01, 01, 01, 2018, "Title", "Description");
        ALists.add(getApt7);

        Appt error = new Appt(26, 01, 13, 01, 01, null, null);
        Appt nothing = new Appt(6, 01, 13, 01, 01, null, null);
        assertNull(time.deleteAppt(null, getApt));


        assertNull(time.deleteAppt(ALists, null));
        assertNull(time.deleteAppt(ALists, error));
        assertNull(time.deleteAppt(ALists, nothing));


    }


    @Test
    public void test02() throws Throwable {
        LinkedList<Appt> ListA = new LinkedList<Appt>();
        LinkedList<Appt> ListA2 = new LinkedList<Appt>();
        TimeTable time = new TimeTable();


        Appt VarA = new Appt(01, 01, 01, 01, 2018, "Title", "Description");
        ListA.add(VarA);

        Appt VarB = new Appt(01, 01, 01, 01, 2018, "Title", "Description");
        ListA.add(VarB);

        Appt VarC = new Appt(01, 01, 01, 01, 2018, "Title", "Description");
        ListA.add(VarC);

        Appt VarD = new Appt(01, 01, 01, 01, 2018, "Title", "Description");
        ListA.add(VarD);

        Appt VarE = new Appt(01, 01, 01, 01, 2018, "Title", "Description");
        ListA.add(VarE);

        int[] array = {2, 4, 6, 8, 10, 12};

        try {
            ListA2 = time.permute(ListA, array);
            fail("Expecting exception: IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }

    }

    @Test
    public void test03() throws Throwable {

        TimeTable time = new TimeTable();
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        LinkedList<Appt> ListA = new LinkedList<Appt>();
        LinkedList<Appt> ListA2 = new LinkedList<Appt>();
        LinkedList<Appt> ListA3 = new LinkedList<Appt>();
        LinkedList<Appt> ListA4 = new LinkedList<Appt>();
        LinkedList<Appt> ListA5 = new LinkedList<Appt>();
        LinkedList<Appt> ListA6 = new LinkedList<Appt>();


        Appt VarA = new Appt(01, 01, 01, 01, 01, "Testing", "Description");
        ListA.add(VarA);

        Appt VarB = new Appt(01, 01, 01, 01, 01, "Testing", "Description");
        ListA.add(VarB);

        Appt VarC = new Appt(01, 01, 01, 01, 01, "Testing", "Description");
        ListA.add(VarC);

        Appt VarD = new Appt(01, 01, 01, 01, 01, "Testing", "Description");
        ListA.add(VarD);

        Appt VarE = new Appt(01, 01, 01, 01, 01, "Testing", "Description");
        ListA.add(VarE);

        Appt VarF = new Appt(01, 01, 01, 01, 01, "Testing", "Description");
        ListA2.add(VarF);

        Appt appt_invalid = new Appt(26, 1, 1, 1, 1, null, null);
        ListA3.add(appt_invalid);
        ListA3.add(VarB);

        int[] s = {0};

        Appt appt_recurMonthly = new Appt(2, 2, 11, 1, 4, "Monthly", "Monthly");
        appt_recurMonthly.setRecurrence(s, appt_recurMonthly.RECUR_BY_MONTHLY, 1, 2);
        ListA4.add(appt_recurMonthly);

        Appt appt_recurWeekly = new Appt(2, 2, 4, 1, 4, "Weekly", "Weekly");
        appt_recurWeekly.setRecurrence(s, appt_recurWeekly.RECUR_BY_WEEKLY, 1, 2);
        ListA5.add(appt_recurWeekly);

        Appt appt_recurYearly = new Appt(2, 2, 11, 2, 3, "Yearly", "Yearly");
        appt_recurYearly.setRecurrence(s, appt_recurYearly.RECUR_BY_YEARLY, 1, 2);
        ListA6.add(VarB);
        ListA6.add(appt_recurYearly);

        GregorianCalendar Day1 = new GregorianCalendar(1, 1, 1);
        GregorianCalendar Day2 = new GregorianCalendar(2, 2, 2);

        try {
            calDays = time.getApptRange(ListA, Day2, Day1);
            fail("Error.");
        } catch (DateOutOfRangeException e) {
        }


    }

    @Test
    public void test04() throws Throwable {
        int startHour = 21;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 01;
        int startYear = 2018;
        String title = "Title";
        String description = "Description.";
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        // assertions
        //assertTrue(appt.getValid());
        assertEquals(21, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(15, appt.getStartDay());
        assertEquals(01, appt.getStartMonth());
        assertEquals(2018, appt.getStartYear());
        assertEquals("Title", appt.getTitle());
        assertEquals("Description.", appt.getDescription());

    }

    @Test
    public void test05() throws Throwable {
        int startHour = 12;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 01;
        int startYear = 2018;
        String title = null;
        String description = null;
        //make a new Appointment object with the initial data
        Appt appt = new Appt(15, 00, 01, 01, 2018, "Title", "Description");

        //change the appointment member variables.
        appt.setStartHour(startHour);
        appt.setStartMinute(startMinute);
        appt.setStartDay(startDay);
        appt.setStartMonth(startMonth);
        appt.setStartYear(startYear);
        appt.setTitle(title);
        appt.setDescription(description);

        // asserting the getting appointment
//        assertTrue(appt.getValid());
        assertEquals(12, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(15, appt.getStartDay());
        assertEquals(01, appt.getStartMonth());
        assertEquals(2018, appt.getStartYear());
        assertEquals("", appt.getTitle());
        assertEquals("", appt.getDescription());
    }

    @Test
    public void test06() throws Throwable {
        Appt isValid = new Appt(12, 00, 13, 8, 2018, "Title", "Description");
        Appt isValid1 = new Appt(12, 00, 11, 01, 2018, "Title", "Description");
        Appt isValid2 = new Appt(12, 00, 13, 8, 1994, "Title", "Description");
        Appt isValid3 = new Appt(-1, 1, 1, 1, 1, "", "");
        Appt isValid4 = new Appt(24, 1, 1, 1, 1, "", "");
        Appt isValid5 = new Appt(1, 60, 1, 1, 1, "", "");
        Appt isValid6 = new Appt(1, 1, -1, 1, 1, "", "");
        Appt isValid7 = new Appt(1, 1, 33, 1, 1, "", "");
        Appt isValid8 = new Appt(1, -1, 1, 1, 1, "", "");

        assertEquals(false, isValid.getValid());
        assertEquals(false, isValid1.getValid());
        assertEquals(false, isValid2.getValid());
        assertEquals(false, isValid3.getValid());
        assertEquals(false, isValid4.getValid());
        assertEquals(false, isValid5.getValid());
        assertEquals(false, isValid6.getValid());
        assertEquals(false, isValid7.getValid());
        assertEquals(false, isValid8.getValid());

    }

    @Test
    public void test07() throws Throwable {
        Appt apptRepresentation = new Appt(12, 30, 13, 8, 2018, "Title", "Description.");
        String str = "\t" + 8 + "/" + 13 + "/" + 2018 + " at " + 12 + ":" + 30 + "pm" + " ," + "Title" + ", " + "Description." + "\n";

        Appt apptRepresentation1 = new Appt(0, 30, 12, 01, 2018, "Title", "Description.");
        String str1 = null;

        Appt apptRepresentation2 = new Appt(21, 30, 15, 01, 2018, "Title", "Description.");
        String str2 = null;

        assertEquals(str, apptRepresentation.toString());
        assertEquals(str1, apptRepresentation1.toString());
        assertEquals(str2, apptRepresentation2.toString());

    }

    @Test
    public void test08() throws Throwable {
        Appt aptComp= new Appt(12, 10, 13, 8, 2018, "Title", "Description.");
        Appt aptComp1 = new Appt(12, 10, 13, 8, 2018, "Title", "Description.");
        Appt aptComp2 = new Appt(1, 1, 1, 1, 1, "", "");
        Appt aptComp3 = new Appt(0, 1, 1, 1, 1, "", "");

        assertEquals(0, aptComp.compareTo(aptComp1));
        assertEquals(1, aptComp2.compareTo(aptComp3));
        assertEquals(aptComp.toString(), aptComp1.toString());
    }


    @Test
    public void test10() throws Throwable {
        Appt appt = new Appt(15, 00, 01, 01, 2018, "Title", "Description");
        int[] RecurDay = {1, 1, 1};
        assertEquals(2, appt.getRecurBy());
        assertEquals(0, appt.getRecurIncrement());
        appt.setRecurrence(RecurDay, 1, 1, 1);
        assertEquals(1, appt.getRecurDays()[0]);
        appt.setRecurrence(null, 1, 1, 0);
        assertEquals(0, appt.getRecurDays().length);
        assertEquals(1, appt.getRecurIncrement());
    }

    @Test
    public void test09() throws Throwable {
        Appt a1 = new Appt(2, 10, 10, 01, 2018, "Title", "Description");
        String str = null;
        assertEquals(str, a1.toString());

        Appt a2 = new Appt(0, 10, 10, 01, 2018, "Title", "Description");
        String str2 = null;
        assertEquals(str2, a2.toString());

        Appt a3 = new Appt(10, 10, 10, 01, 2018, "Title", "Description");
        String str3 = null;
        assertEquals(str3, a3.toString());

        Appt a4 = new Appt(10, 10, 10, 01, 2018, "Title", "Description");
        String str4 = null;
        assertEquals(str4, a4.toString());

        Appt error = new Appt(24, 1, 1, 1, 1, "", "");
        assertEquals(null, error.toString());
    }

}

//add more unit tests as you needed

