// -------------------------------------------------------------------------
/**
 * interface for operations of the generic binary tree
 * 
 * @author Pragati Anandarajan
 * @version Oct 8, 2026
 * @param <T>
 *            data stored in the tree
 */
public interface BinaryTreeInterface<T>
{
    // ----------------------------------------------------------
    /**
     * data of root tree
     * 
     * @return data in root
     * @throws EmptyTreeException
     *             if the tree is empty
     */
    public T getRootData();


    // ----------------------------------------------------------
    /**
     * GEts the root node of the tree.
     *
     * @return the root node, or null if the tree is empty
     */

    public BinaryNode<T> getRootNode();


    /**
     * Sets the root node of the tree.
     *
     * @param rootNode
     *            the node to make the root
     */
    public void setRootNode(BinaryNode<T> rootNode);


    /**
     * Gets the height of the tree.
     *
     * @return rthe height of the tree
     */
    public int getHeight();


    /**
     * Gets the number of nodes in the tree.
     *
     * @return the number of nodes in the tree
     */
    public int getNumberOfNodes();


    /**
     * Checks whether the tree is empty.
     *
     * @return true if the tree is empty
     */
    public boolean isEmpty();


    /**
     * Removes all nodes from the tree.
     */
    public void clear();

}
