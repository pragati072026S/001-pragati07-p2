// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Pragati Anandarajan
 * @version Oct 6, 2026
 */

public class BinaryNode<T>
{
    // ~ Fields ................................................................

    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    // ~Public Methods ........................................................

    public BinaryNode()
    {
        this(null);
    }


    public BinaryNode(T data)
    {
        this(data, null, null);

    }


    public BinaryNode(T data, BinaryNode<T> leftNode, BinaryNode<T> rightNode)
    {
        this.data = data;
        this.leftChild = leftNode;
        this.rightChild = rightNode;

    }


    public T getData()
    {
        return data;
    }


    public void setData(T data)
    {
        this.data = data;

    }


    public BinaryNode<T> getLeftChild()
    {
        return leftChild;

    }


    public void setLeftChild(BinaryNode<T> leftChild)
    {
        this.leftChild = leftChild;

    }


    public BinaryNode<T> getRightChild()
    {
        return rightChild;

    }


    public void setRightChild(BinaryNode<T> rightChild)
    {
        this.rightChild = rightChild;
    }


    public boolean hasLeftChild()
    {
        return leftChild != null;
    }


    public boolean hasRightChild()
    {
        return rightChild != null;
    }


    public boolean isLeaf()
    {
        return !hasLeftChild() && !hasRightChild();
    }


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
