// -------------------------------------------------------------------------
/**
 * a generic descion tree that has a quesiton for each internal node and each
 * question hold n answer
 * 
 * @author pragati Anandarajan
 * @version Oct 9, 2026
 * @param <T>
 *            data stored in the tree
 */
public class DecisionTree<T>
    extends BinaryTree<T>
    implements DecisionTreeInterface<T>
{
    // ~ Fields ................................................................
    private BinaryNode<T> currentNode;

    // ----------------------------------------------------------
    /**
     * Create a new DecisionTree object.
     */
    // ~ Constructors ..........................................................
    public DecisionTree()
    {
        super();
        currentNode = null;
    }


    // ----------------------------------------------------------
    /**
     * Create a new DecisionTree object.
     * 
     * @param rootData
     *            data for root
     */
    public DecisionTree(T rootData)
    {
        super(rootData);
        currentNode = null;
    }

    // ~Public Methods ........................................................


    /**
     * Checks whether the current node holds a final decision. In a decision
     * tree, only leaves hold answers.
     *
     * @return true if the current node is a leaf, false otherwise
     */
    public boolean isAnswer()
    {
        return currentNode.isLeaf();
    }


    /**
     * Moves the current node to its left child (the "no" branch). The current
     * node must not be null.
     */
    public void moveToNo()
    {
        currentNode = currentNode.getLeftChild();
    }


    /**
     * Moves the current node to its right child (the "yes" branch). The current
     * node must not be null.
     */
    public void moveToYes()
    {
        currentNode = currentNode.getRightChild();
    }


    /**
     * Sets the current node back to the root of the tree.
     */
    public void resetCurrentNode()
    {
        currentNode = getRootNode();
    }


    /**
     * Gets the current node.
     *
     * @return the current node
     */
    public BinaryNode<T> getCurrentNode()
    {
        return currentNode;
    }


    /**
     * Gets the data stored in the current node.
     *
     * @return the data in the current node
     */
    public T getCurrentData()
    {
        return currentNode.getData();
    }


    /**
     * Sets the data in the left and right children of the current node. Any
     * existing children of the current node are replaced.
     *
     * @param responseForNo
     *            the data for the left child
     * @param responseForYes
     *            the data for the right child
     */
    public void setResponses(T responseForNo, T responseForYes)
    {
        currentNode.setLeftChild(new BinaryNode<>(responseForNo));
        currentNode.setRightChild(new BinaryNode<>(responseForYes));
    }

}
