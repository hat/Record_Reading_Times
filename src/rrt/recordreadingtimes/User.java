package rrt.recordreadingtimes;

import java.util.*;

/**
 * User class to store all the data of each user of the program Record_Reading_Times
 */

public class User
{
    Scanner input = new Scanner(System.in);

    /* declares variables
    * fName: the users first name
    * lName: the users last name
    * minsRead: the amount of minutes the user has read
    * hoursRead: the amount of hours the user has read
    */
    private String name;
    private double minsRead;
    private double hoursRead;
    //end of declarations

    /* Constructor with blank default values */
    User()
    {
        name = "";
        minsRead = 0;
        hoursRead = 0;
    }
    //end of constructor

    /* Constructor method for User */
    public User(String newName, double newMinsRead, double newHoursRead)
    {
        this.name = newName;
        this.minsRead = newMinsRead;
        this.hoursRead = newHoursRead;
    }
    //end of constructor

    /* Accessor methods */
    public String getName()
    {
        return name;
    }

    public double getTimeReadHours()
    {
        //returns the total amount of hours the user read
        return ( minsRead / 60 ) + hoursRead;
    }
    //end of accessor methods

    /* Set methods to set the values of a User */
    public void setName()
    {
        System.out.print("Name: ");
        name = input.nextLine();
    }

    public void setMinsRead(double newMinsRead)
    {
        minsRead = newMinsRead;
    }

    public void setHoursRead(double newHoursRead)
    {
        hoursRead = newHoursRead;
    }
    //end of set methods
}
