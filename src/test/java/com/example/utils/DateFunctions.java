package com.example.utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DateFunctions {

    public String getMonth(){
        LocalDate currentdate = LocalDate.now();
        int month = currentdate.getMonthValue();

        return getMonthName(month);
    }

    public int getDay(){
        LocalDate currentdate = LocalDate.now();
        return currentdate.getDayOfMonth();
    }

    public int getYear(){
        LocalDate currentdate = LocalDate.now();
        return currentdate.getYear();
    }

    public String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now).toString();
    }

    private static String getMonthName(int month) {
        String monthName = null;
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }
}
