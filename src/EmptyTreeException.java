// -------------------------------------------------------------------------
/**
 * thrown when an OPeration tries to work on an empty tree
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
