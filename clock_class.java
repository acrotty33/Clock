// the Clock class creates clock-like objects with hours, minutes, and seconds
// as instance variables
// the Clock class can also add two Clock objects together and adjust for overflowing
// time

public class Clock {
    private int hour;
    private int min;
    private int sec;
    
    // constructor with hours, months, and seconds as parameters
    public Clock(int h, int m, int s) {
        hour = h;
        min = m;
        sec = s;
    }
    
    // constructor with no parameters, instant vars set to 0
    public Clock() {
        hour = 0;
        min = 0;
        sec = 0;
    }
    
    // adds times together using the addHour(int h), addMinute(int m), and addSecond(int s) methods
    public int addTime(int h, int m, int s) {
        int oversec = addSecond(s);
        int overmin = addMinute(m + oversec);
        return addHour(h + overmin);
    }
  
    // returns the number of days overflowing
    public int addHour(int h) {
        hour += h;
        int overflow = hour / 24;
        hour -= overflow*24;
        return overflow;
    }
    
    // returns the number of hours overflowing
    public int addMinute(int m) {
        min += m;
        int overflow = min / 60;
        min -= overflow*60;
        return overflow;
    }
    
    // returns the number of minutes overflowing
    public int addSecond(int s) {
        sec += s;
        int overflow = sec / 60;
        sec -= overflow*60;
        return overflow;
    }
    
    // returns the time in a String format, adding zeroes when the digits for the
    // hours, minutes, or seconds are not two digits long
    public String toString() {
        String hour_str = "" + hour;
        String min_str = "" + min;
        String sec_str = "" + sec;
        // returns after adding a 0 to the beginning of hours, minutes, and seconds
        if ((hour_str.length() == 1) && (min_str.length() == 1) && (sec_str.length() == 1)) {
            hour_str = "0" + hour;
            min_str = "0" + min;
            sec_str = "0" + sec;
            return hour_str + ":" + min_str + ":" + sec_str;
        }
        // returns after adding a 0 to the beginning hours and minutes
        else if ((hour_str.length() == 1) && (min_str.length() == 1)) {
            hour_str = "0" + hour;
            min_str = "0" + min;
            return hour_str + ":" + min_str + ":" + sec;
        }
        // returns after adding a 0 to the beginning of hours and seconds
        else if ((hour_str.length() == 1) && (sec_str.length() == 1)) {
            hour_str = "0" + hour;
            sec_str = "0" + sec;
            return hour_str + ":" + min + ":" + sec_str;
        }
        // returns after adding a 0 to the beginning of hours only
        else if (hour_str.length() == 1) {
            hour_str = "0" + hour;
            return hour_str + ":" + min + ":" + sec;
        }
        // returns after ading a 0 to the beginning of minutes and seconds
        else if ((min_str.length() == 1) && (sec_str.length() == 1)) {
            min_str = "0" + min;
            sec_str = "0" + sec;
            return hour + ":" + min_str + ":" + sec_str;
        }
        // returns after adding a 0 to the beginning of minutes only
        else if(min_str.length() == 1) {
            min_str = "0" + min;
            return hour + ":" + min_str + ":" + sec;
        }
        // returns after adding a 0 to the beginning of seconds only
        else {
            sec_str = "0" + min;
            return hour + ":" + min + ":" + sec_str;
        }
    }
}