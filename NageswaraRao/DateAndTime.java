package NageswaraRao;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class DateAndTime {
    public static void main(String[] args) {
        String date = findDate(11,2,2020);
        System.out.println(date);
        Currency();

    }
    public static String findDate(int month, int day, int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.YEAR, year);
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();

    }
    public static void DateNow(){
        Calendar cl = Calendar.getInstance();
        //Displaying Date
        System.out.println("Current date: ");
        int dd = cl.get(Calendar.DATE);
        int mm = cl.get(Calendar.MONTH);
        ++mm;
        int yy = cl.get(Calendar.YEAR);
        System.out.println(dd + "-" + mm + "-" + yy);

        //Displaying Time
        System.out.println("Current Time: ");
        int h = cl.get(Calendar.HOUR);
        int m = cl.get(Calendar.MINUTE);
        int s = cl.get(Calendar.SECOND);
        System.out.println(h + ":" + m + ":" + s);
        int x = cl.get(Calendar.AM_PM);
        if (x==0) System.out.println("GOOD MORNING");
        System.out.println("GOOD EVENING");
    }
    public static void Currency(){

        Scanner sc = new Scanner(System.in);
        double payment = sc.nextDouble();
        sc.close();
        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat in = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        /* Print output */
        System.out.println("US: "     + us.format(payment));
        System.out.println("India: "  + in.format(payment));
        System.out.println("China: "  + china.format(payment));
        System.out.println("France: " + france.format(payment));


    }

}
