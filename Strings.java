import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * String Manipulation Utilities
 *
 * @author michael  2/03/16.
 * @version 1.0.1
 */
public class Strings
{

    public static final String joinForPrint(String delim, String... msg)
    {
        String result = "";
        Queue queue = new LinkedList<>();
        Collections.addAll(queue, msg);
        while (!queue.isEmpty())
        {
            result += queue.poll();
            if (!queue.isEmpty())
            {
                result += delim;
            }
        }
        return result;
    }
}
