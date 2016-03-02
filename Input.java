package util;

import java.util.Scanner;

/**
 * Utility Class for receiving input from the user in cli applications.
 *
 * @author michael  1/03/16.
 * @version 0.0.1
 */
@SuppressWarnings("Duplicates")
public class Input
{

    /**
     * The scanner from System.in to get cli input
     */
    private static final Scanner scanner;

    /** Initialise the fields on first class load */
    static
    {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays a message to the user and accepts
     * a single line of input.
     * <p>
     * Format "message :input"
     *
     * @param msg The message to be displayed.
     * @return single line string.
     */
    public static String getUnsafeString(String msg)
    {
        System.out.print(msg + " :");
        return scanner.nextLine();
    }

    /**
     * Displays a message then gets a single line non empty string input
     * from the user. This will keep asking until it gets an input string.
     * <p>
     * Format "message :input"
     *
     * @param msg The message to be displayed.
     * @return Single line non empty string.
     */
    public static String getString(String msg)
    {
        boolean haveString = false;
        String result = "";
        while (!haveString)
        {
            result = getUnsafeString(msg);
            if (result.isEmpty())
            {
                System.out.println("Please enter a non empty value");
            } else
            {
                haveString = true;
            }
        }

        return result;
    }

    /**
     * Displays a message then gets an integer input from the user.
     * Will continue asking until a valid Integer is entered.
     * <p>
     * Format "message :input"
     *
     * @param msg The message to be displayed.
     * @return Integer input.
     */
    public static Integer getInteger(String msg)
    {
        boolean haveInt = false;
        Integer result = null;

        while (!haveInt)
        {
            try
            {
                result = Integer.parseInt(getString(msg));
                haveInt = true;
            } catch (NumberFormatException nfe)
            {
                System.out.println("That wasn't an integer, please try " +
                        "again");
            }
        }
        return result;
    }

    /**
     * Displays a message then gets a double input from the user.
     * Will continue asking until a valid Double is entered.
     * <p>
     * Format "message :input"
     *
     * @param msg The message to be displayed.
     * @return Double input.
     */
    public static Double getDouble(String msg)
    {
        boolean haveInt = false;
        Double result = null;

        while (!haveInt)
        {
            try
            {
                result = Double.parseDouble(getString(msg));
                haveInt = true;
            } catch (NumberFormatException nfe)
            {
                System.out.println("That wasn't an number, please try " +
                        "again");
            }
        }
        return result;
    }

    /**
     * Displays a message then gets a float input from the user.
     * Will continue asking until a valid Float is entered.
     * <p>
     * Format "message :input"
     *
     * @param msg The message to be displayed.
     * @return Float input.
     */
    public static Float getFloat(String msg)
    {
        boolean haveInt = false;
        Float result = null;

        while (!haveInt)
        {
            try
            {
                result = Float.parseFloat(getString(msg));
                haveInt = true;
            } catch (NumberFormatException nfe)
            {
                System.out.println("That wasn't an number, please try " +
                        "again");
            }
        }
        return result;
    }

    /**
     * Displays a message then gets an integer input that is between the
     * specified minimum and maximum limits. Will continue asking until
     * the input is an integer and satisfies the min/max bounds.
     * <p>
     * Format "message :input"
     *
     * @param msg The message to be displayed.
     * @param min The minimum value of the integer, inclusive.
     * @param max The maximum value of the integer, inclusive.
     * @return The integer entered by the user between the min/max
     */
    public static Integer getBoundInteger(String msg, int min, int max)
    {
        boolean haveInt = false;
        Integer result = null;

        while (!haveInt)
        {
            try
            {
                result = getInteger(msg);
                if (result < min)
                {
                    throw new IndexOutOfBoundsException("Input was less " +
                            "than min of " + min);
                } else if (result > max)
                {
                    throw new IndexOutOfBoundsException("Input was " +
                            "greater than max of " + max);
                } else
                {
                    haveInt = true;
                }
            } catch (NumberFormatException nfe)
            {
                System.out.println("That wasnt an integer, please try " +
                        "again");
            } catch (IndexOutOfBoundsException ioobe)
            {
                System.out.println(ioobe.getMessage());
            }
        }
        return result;
    }

    /**
     * Displays a message then gets a double input that is between the
     * specified minimum and maximum limits. Will continue asking until
     * the input is an integer and satisfies the min/max bounds.
     * <p>
     * Format "message :input"
     *
     * @param msg The message to be displayed.
     * @param min The minimum value of the double, inclusive.
     * @param max The maximum value of the double, inclusive.
     * @return The double entered by the user between the min/max
     */
    public static Double getBoundDouble(String msg, double min, double
            max)
    {

        boolean haveDouble = false;
        Double result = null;

        while (!haveDouble)
        {
            try
            {
                result = getDouble(msg);
                if (result < min)
                {
                    throw new IndexOutOfBoundsException("Input was less " +
                            "than min of " + min);
                } else if (result > max)
                {
                    throw new IndexOutOfBoundsException("Input was " +
                            "greater than max of " + max);
                } else
                {
                    haveDouble = true;
                }
            } catch (NumberFormatException nfe)
            {
                System.out.println("That wasn't a double, please try " +
                        "again");
            } catch (IndexOutOfBoundsException ioobe)
            {
                System.out.println(ioobe.getMessage());
            }
        }
        return result;
    }

}
