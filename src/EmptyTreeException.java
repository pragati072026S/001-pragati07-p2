// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Pragati Anandarajan
 * @version Oct 6, 2026
 */
public class EmptyTreeException
    extends RuntimeException
{
    // ----------------------------------------------------------
    /**
     * Create a new EmptyTreeException object.
     */

    public EmptyTreeException()
    {
        this("The tree is empty.");
    }


    // ----------------------------------------------------------
    /**
     * Create a new EmptyTreeException object with message.
     * 
     * @param message
     *            description of error
     */
    public EmptyTreeException(String message)
    {
        super(message);
    }

}
