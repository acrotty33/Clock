// The DateTime tester class takes in user input for the current time
// and also takes in the amount of time the user wants to add to the current time
// Then, the program tells the user the final time after adding the current time with the adding time

import java.util.Scanner;
public class DateTimeTester
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        // gets starting inputs from user
        System.out.print("Enter current hour: ");
        int hour = input.nextInt();
        System.out.print("Enter current minute: ");
        int min = input.nextInt();
        System.out.print("Enter current second: ");
        int sec = input.nextInt(); 
        System.out.print("Enter current day: ");
        int day = input.nextInt();
        System.out.print("Enter current month: ");
        int month = input.nextInt();
        System.out.print("Enter current year: ");
        int year = input.nextInt();
        System.out.println("");
        
        //creates starting clock
        DateTime date1 = new DateTime(hour, min, sec, day, month, year);
        
        //prints out starting clock with tostring()
        System.out.println(date1.toString());
        System.out.println("");
        
        // gets inputs from user to add to the starting clock
        System.out.print("Enter hour(s) to add: ");
        int h = input.nextInt();
        System.out.print("Enter minute(s) to add: ");
        int mi = input.nextInt();
        System.out.print("Enter second(s) to add: ");
        int s = input.nextInt(); 
        System.out.print("Enter day(s) to add: ");
        int d = input.nextInt();
        System.out.print("Enter month(s) to add: ");
        int mo = input.nextInt();
        System.out.print("Enter year(s) to add: ");
        int y = input.nextInt();
        System.out.println("");
        
        // add the new inputs to the starting clock and
        // prints out the "new" clock with tostring()
        date1.addDateTime(h, mi, s, d, mo, y);
        System.out.println(date1.toString());
        
    }
}