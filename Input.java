package util;

import java.util.Scanner;

/**
 * Utility Class for receiving input from the user in cli applications.
 *
 * @author michael  1/03/16.
 * @version 1.0.2
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
    public static final String getUnsafeString(String msg)
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
    public static final String getString(String msg)
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
    public static final Integer getInteger(String msg)
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
    public static final Double getDouble(String msg)
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
    public static final Float getFloat(String msg)
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
    public static final Integer getBoundInteger(String msg, int min, int
            max)
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
     * the input is a double and satisfies the min/max bounds.
     * <p>
     * Format "message :input"
     *
     * @param msg The message to be displayed.
     * @param min The minimum value of the double, inclusive.
     * @param max The maximum value of the double, inclusive.
     * @return The double entered by the user between the min/max
     */
    public static final Double getBoundDouble(String msg, double min,
                                              double max)
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
            } catch (IndexOutOfBoundsException ioobe)
            {
                System.out.println(ioobe.getMessage());
            }
        }
        return result;
    }

    /**
     * Displays a message then gets a float input that is between the
     * specified minimum and maximum limits. Will continue asking until
     * the input is a float and satisfies the min/max bounds.
     * <p>
     * Format "message :input"
     *
     * @param msg The message to be displayed.
     * @param min The minimum value of the float, inclusive.
     * @param max The maximum value of the float, inclusive.
     * @return The float entered by the user between the min/max
     */
    public static final Float getBoundFloat(String msg, float min, float
            max)
    {

        boolean haveFloat = false;
        Float result = null;

        while (!haveFloat)
        {
            try
            {
                result = getFloat(msg);
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
                    haveFloat = true;
                }
            } catch (IndexOutOfBoundsException ioobe)
            {
                System.out.println(ioobe.getMessage());
            }
        }
        return result;
    }

    public static boolean getBoolean(String msg)
    {
        boolean haveResult = false;

        while (!haveResult)
        {
            String strTemp = getString(msg);

            switch (strTemp)
            {
                case "yes":
                case "true":
                    return true;
                case "no":
                case "false":
                    return false;
                default:
                    System.out.println("Not a valid response, please " +
                            "enter yes/no or true/false");
            }
        }
        return false;
    }

    /**
     * Main entry point for this program. However only to be used for
     * testing. Will run through all of the utilities and allow them to
     * be tested.
     */
    public static void main(String[] args)
    {
        System.out.println("Unsafe String " + getUnsafeString("Unsafe " +
                "String Entry") + '\n');
        System.out.println("Unsafe String " + getUnsafeString("Unsafe " +
                "String Entry") + '\n');
        System.out.println("String " + getString("String") + '\n');
        System.out.println("Integer " + getInteger("Integer") + '\n');
        System.out.println("Double " + getDouble("Double") + '\n');
        System.out.println("BoundInteger " + getBoundInteger("Integer " +
                "1/10", 1, 10) + '\n');
        System.out.println("BoundDouble " + getBoundDouble("Double 1" +
                ".2/5.6", 1.2d, 5.6d) + '\n');
        System.out.println("Bound Float " + getBoundFloat("Float 1.2/5" +
                ".6", 1.2f, 5.6f));
    }
}
