package rrt.recordreadingtimes;

import java.util.*;

/**
 * Created by tonyhendrick on 1/2/15.
 */
public class Record_Reading_Times
{
    public static void main(String[] args)
    {
        //UNCOMMENT TO MAKE SURE IT IS COMPILING/RUNNING
        //System.out.println( "TEST" );

        //declares a new User
        User firstUser = new User();

        //sets the values of the User firstUser
        firstUser.setName();
        firstUser.setMinsRead(150);
        firstUser.setHoursRead(3);

        //prints the name and amount of hours read for the User firstUser
        System.out.println(firstUser.getName());
        System.out.println(firstUser.getTimeReadHours());

    }
}
