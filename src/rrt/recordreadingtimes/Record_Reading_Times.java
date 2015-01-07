package rrt.recordreadingtimes;

import java.util.*;

/**
 * Created by tonyhendrick on 1/2/15.
 */

public class Record_Reading_Times
{
    public static int NUM_USERS = 100;
    public static int MAIN_MENU_EXIT = 4;
    public static int USER_MENU_EXIT = 4;

    public static void main(String[] args)
    {
        //UNCOMMENT TO MAKE SURE IT IS COMPILING/RUNNING
        //System.out.println( "TEST" );

        //declares a new User
        User[] userList = new User[NUM_USERS];

        //Declares int variable
        int mainSelection = 0;
        int userSelection = 0;
        int userIndex = 0;

        //Sets all elements of the array to a User
        for( int i = 0; i < NUM_USERS; i++ )
        {
            userList[i] = new User();
        }

        //Do loop based on menu selection (ends if mainMenu() returns MAIN_MENU_EXIT)
        do
        {
            //Calls mainMenu() function
            mainSelection = mainMenu();

            //If-Else based on mainMenu() function
            if(mainSelection == 1)
            {
                //Calls register function and sets userIndex to return value
                userIndex = registerNewUser(userList, NUM_USERS);
                //Sets userSelection to 0
                userSelection = 0;
            }
            else if(mainSelection == 2)
            {
                //Calls findUser function and sets userIndex to return value
                userIndex = findUser(userList, NUM_USERS);
                //Sets userSelection to 0
                userSelection = 0;
            }
            else if(mainSelection == 3)
            {
                displayAllUsers(userList, NUM_USERS);
            }
            else if(mainSelection == MAIN_MENU_EXIT)
            {
                //Do nothing
            }
            else
            {
                //Prints if error in if-else
                System.out.println("SYSTEM ERROR: CODE 1");
            }

            //While loop runs until userMenu() returns MAIN_MENU_EXIT
            while( userSelection != USER_MENU_EXIT && mainSelection != MAIN_MENU_EXIT )
            {

                //Calls userMenu function
                userSelection = userMenu(userList, userIndex);

                //If-Else to check return value of userMenu
                if (userSelection == 1 || userSelection == 2)
                {
                    //Calls setTimeRead function
                    setTimeRead(userList, userIndex, userSelection);
                }
                else if (userSelection == 3)
                {
                    //Calls displayTimeRead function
                    displayTimeRead(userList, userIndex);
                }
                else if(userSelection == USER_MENU_EXIT)
                {
                    //Do nothing
                }
                else
                {
                    //Prints if error in if-else
                    System.out.println("SYSTEM ERROR: CODE 2");
                }
            }//End of while loop

        }while(mainSelection != MAIN_MENU_EXIT);//end of While loop

    }

    public static int mainMenu()
    {
        //Declare new Scanner
        Scanner input = new Scanner(System.in);

        //Declare int variable
        int selection = 0;

        //Print the menu
        System.out.println( "\tRecord Reading Times\t" +
                "\n 1) Register New User" +
                "\n 2) Previous User Log In" +
                "\n 3) Display All Users" +
                "\n 4) Exit");

        //Get the input from Scanner
        selection = input.nextInt();

        //Return the input
        return selection;
    }

    public static int registerNewUser(User[] userList, int numUsers)
    {
        int userIndex = 0;
        boolean found = false;

        for( userIndex = 0; userIndex < numUsers && !found; userIndex++ )
        {
            if( userList[userIndex].getName().equals("") )
            {
                userList[userIndex].setName();
                found = true;
            }
        }

        return userIndex - 1;
    }

    public static int findUser(User[] userList, int numUsers)
    {
        //Declare new Scanner
        Scanner input = new Scanner(System.in);

        //Declare int variable
        int index = 0;

        //Declare String variable
        String userName = "";

        //Print the instructions
        System.out.println( "\tUser Log-In\t" +
                "Enter the user name: ");

        //Get the input from Scanner
        userName = input.nextLine();

        //For loop to cycle through the userList to try to find input
        for( int i = 0; i < numUsers; i++ )
        {
            //If input matches name in userList return index
            if( userList[i].getName().equals(userName) )
            {
                //Set index
                index = i;
            }
        }

        //Return the index(0 if not found)
        return index;
    }

    public static int userMenu(User[] userList, int userIndex)
    {
        //Declare new Scanner
        Scanner input = new Scanner(System.in);

        //Declare int variable
        int selection = 0;

        //Print menu
        System.out.println( "\tWelcome, " + userList[userIndex].getName() + "\t" +
                "\n 1) Enter minutes read" +
                "\n 2) Enter hours read" +
                "\n 3) Print out total time read" +
                "\n 4) Exit");

        //Get menu selection
        selection = input.nextInt();

        //Return selection
        return selection;
    }

    public static void setTimeRead(User[] userList, int userIndex, int selection)
    {
        //Declare new scanner
        Scanner input = new Scanner(System.in);

        //Declare double variable
        double timeRead = 0;

        //If statements to check what selection was made

        //Allows user to enter minutes read
        if( selection == 1 )
        {
            System.out.println( "Enter the amount of minutes you read: " );

            //Gets user input
            timeRead = input.nextDouble();

            //Add the minutes read to the User
            userList[userIndex].setMinsRead(timeRead);
        }

        //Allows user to enter hours read
        if( selection == 2 )
        {
            System.out.println( "Enter the amount of hours you read: " );

            //Gets user input
            timeRead = input.nextDouble();

            //Adds hours read to the user
            userList[userIndex].setHoursRead(timeRead);
        }
    }

    public static void displayTimeRead(User[] userList, int userIndex)
    {
        System.out.println("Total time read for " + userList[userIndex].getName()
                + " is " + userList[userIndex].getTimeReadHours() + " hours.");
    }

    public static void displayAllUsers(User[] userList, int numUsers)
    {
        //Prints header
        System.out.println( "\tCurrent Users\t" );

        //For loop that runs through the users
        for( int i = 0; i < numUsers && !userList[i].getName().equals(""); i++ )
        {
            //Prints name of user
            System.out.println( userList[i].getName() );
        }
    }
}
