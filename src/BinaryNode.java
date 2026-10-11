// -------------------------------------------------------------------------
/**
 * builds the decision tree which is read from a text file. it also learns new
 * questions and answers from the user
 * 
 * @author Pragati Anandarajan
 * @version Oct 6, 2026
 * @param <T>
 *            data stored in the node
 */

public class BinaryNode<T>
{
    // ~ Fields ................................................................

    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    // ~Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Create a new BinaryNode object.
     */
    public BinaryNode()
    {
        this(null);
    }


    // ----------------------------------------------------------
    /**
     * Create a new BinaryNode object.
     * 
     * @param data
     *            inputs the data
     */
    public BinaryNode(T data)
    {
        this(data, null, null);

    }


    // ----------------------------------------------------------
    /**
     * Create a new BinaryNode object.
     * 
     * @param data
     *            inputs the data
     * @param leftNode
     *            inputs the left node
     * @param rightNode
     *            inputs the right node
     */
    public BinaryNode(T data, BinaryNode<T> leftNode, BinaryNode<T> rightNode)
    {
        this.data = data;
        this.leftChild = leftNode;
        this.rightChild = rightNode;

    }


    // ----------------------------------------------------------
    /**
     * gets the data
     * 
     * @return data
     */
    public T getData()
    {
        return data;
    }


    // ----------------------------------------------------------
    /**
     * sets the data equal to data
     * 
     * @param data
     */
    public void setData(T data)
    {
        this.data = data;

    }


    // ----------------------------------------------------------
    /**
     * gets the leftChild value
     * 
     * @return leftChild
     */
    public BinaryNode<T> getLeftChild()
    {
        return leftChild;

    }


    // ----------------------------------------------------------
    /**
     * sets the leftChild value
     * 
     * @param leftChild
     *            inputs lettChild
     */
    public void setLeftChild(BinaryNode<T> leftChild)
    {
        this.leftChild = leftChild;

    }


    // ----------------------------------------------------------
    /**
     * gets teh right child value
     * 
     * @return right child
     */
    public BinaryNode<T> getRightChild()
    {
        return rightChild;

    }


    // ----------------------------------------------------------
    /**
     * sets the rightCHild
     * 
     * @param rightChild
     *            inputs rightChild
     */
    public void setRightChild(BinaryNode<T> rightChild)
    {
        this.rightChild = rightChild;
    }


    // ----------------------------------------------------------
    /**
     * checks if LeftChild is not null
     * 
     * @return true if its not null
     */
    public boolean hasLeftChild()
    {
        return leftChild != null;
    }


    // ----------------------------------------------------------
    /**
     * checks if RightChild is not null
     * 
     * @return true if its not null
     */
    public boolean hasRightChild()
    {
        return rightChild != null;
    }


    // ----------------------------------------------------------
    /**
     * checks if the node has no children
     * 
     * @return true if it has no children
     */
    public boolean isLeaf()
    {
        return !hasLeftChild() && !hasRightChild();
    }


    // ----------------------------------------------------------
    /**
     * Computes the height of the tree rooted at the node
     * 
     * @return the number of levels in the tree
     */
    public int getHeight()
    {
        int leftHeight = 0;
        int rightHeight = 0;

        if (hasLeftChild())
        {
            leftHeight = leftChild.getHeight();
        }
        if (hasRightChild())
        {
            rightHeight = rightChild.getHeight();
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }


    // ----------------------------------------------------------
    /**
     * counts the nodes int he tree
     * 
     * @return the number of nodes in the tree
     */
    public int getNumberOfNodes()
    {
        int leftCount = 0;
        int rightCount = 0;

        if (hasLeftChild())
        {
            leftCount = leftChild.getNumberOfNodes();
        }
        if (hasRightChild())
        {
            rightCount = rightChild.getNumberOfNodes();
        }
        return 1 + leftCount + rightCount;
    }


    // ----------------------------------------------------------
    /**
     * copies the subtree and then new nodes are created so changing the copy
     * wouldn't change the original
     * 
     * @return the root of the copied
     */
    public BinaryNode<T> copy()
    {
        BinaryNode<T> newRoot = new BinaryNode<>(data);

        if (hasLeftChild())
        {
            newRoot.setLeftChild(leftChild.copy());
        }
        if (hasRightChild())
        {
            newRoot.setRightChild(rightChild.copy());
        }
        return newRoot;
    }

}
