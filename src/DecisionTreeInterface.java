// -------------------------------------------------------------------------
/**
 * interface for desicion tree
 * 
 * @author pragati Anandarajan
 * @version Oct 8, 2026
 * @param <T>
 *            data in tree
 */
public interface DecisionTreeInterface<T>
    extends BinaryTreeInterface<T>
{
    /**
     * Checks whether the current node holds a final decision. In a decision
     * tree, only leaves hold answers.
     *
     * @return true if the current node is a leaf, false otherwise
     */
    public boolean isAnswer();


    /**
     * Moves the current node to its left child (the "no" branch). The current
     * node must not be null.
     */
    public void moveToNo();


    /**
     * Moves the current node to its right child (the "yes" branch). The current
     * node must not be null.
     */
    public void moveToYes();


    /**
     * Sets the current node back to the root of the tree.
     */
    public void resetCurrentNode();


    /**
     * Gets the current node.
     *
     * @return the current node
     */
    public BinaryNode<T> getCurrentNode();


    /**
     * Gets the data stored in the current node.
     *
     * @return the data in the current node
     */
    public T getCurrentData();


    /**
     * Sets the data in the left and right children of the current node.
     *
     * @param responseForNo
     *            the data for the left child
     * @param responseForYes
     *            the data for the right child
     */
    public void setResponses(T responseForNo, T responseForYes);

}
