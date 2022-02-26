// The DateTime class uses the Clock class to make a more specific time set
// where the DateTime objects will also account for months, days, and years
// The class also calculates the result when you add times together

public class DateTime
{
    private Clock clock1;
    private int month;
    private int day;
    private int year;
    
    // constructor with parameters
    public DateTime(int h, int m, int s, int d, int mo, int y) {
        clock1 = new Clock(h,m,s);
        month = mo;
        day = d;
        year = y;
    }
    
    // constructor without parameters, all instance variables set to 0, including the Clock object
    public DateTime() {
        clock1 = new Clock(0,0,0);
        month = 1;
        day = 1;
        year = 0;
    }
    
    // returns number of days that overflow
    public int addTime(int h, int m, int s) {
        int hours = clock1.addTime(h,m,s);
        //hours /= 24;
        return hours;
    }
    
    // returns number of months that overflow, using number of days
    public int addDay(int d) {
        day += d;
        int overday;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            overday = day / 31;
            day -= overday*31;
        }
        else if (month == 2) {
            overday = day / 28;
            day -= overday*28;
        }
        else {
            overday = day / 30;
            day -= overday*30;
        }
        return overday;
    }
    
    // returns number of years that overflow
    public int addMonth(int mo) {
        month += mo;
        int overmonth = month/ 12;
        month -= overmonth*12;
        return overmonth;
    }
    
    // takes the number of years added then updates year instance var
    public void addYear(int y) {
        year += y;
    }
    
    // takes days, months, and years and adds those to instance vars
    public void addDate(int d, int mo, int y) {
        int overmonth = addDay(d);
        int overyear = addMonth(mo + overmonth);
        addYear(y + overyear);
    }
    
    // takes hour, min, sec, days, months, and years and adds those to instance vars
    public void addDateTime(int h, int m, int s, int d, int mo, int y) {
        int overday = clock1.addTime(h,m,s);
        addDate(d + overday, mo, y);
    }
    
    // returns in format "month day, year"
    public String getDate() {
        String monthA;
        if (month == 1) {
            monthA = "January";
        }
        else if (month == 2) {
            monthA = "February";
        }
        else if (month ==3) {
            monthA = "March";
        }
        else if (month == 4) {
            monthA = "April";
        }
        else if (month == 5) {
            monthA = "May";
        }
        else if (month == 6) {
            monthA = "June";
        }
        else if (month == 7) {
            monthA = "July";
        }
        else if (month == 8) {
            monthA = "August";
        }
        else if (month == 9) {
            monthA = "September";
        }
        else if (month == 10) {
            monthA = "October";
        }
        else if (month == 11) {
            monthA = "November";
        }
        else {
            monthA = "December";
        }
        return (monthA + " " + day + ", " + year);
    }
    
    // returns format "Hour:Minute:Second on month day, year"
    public String toString() {
        return ("It's " + clock1.toString() + " on " + getDate());
    }
}