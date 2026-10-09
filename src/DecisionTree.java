// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author pragati
 * @version Oct 9, 2026
 */
public class DecisionTree<T>
    extends BinaryTree<T>
    implements DecisionTreeInterface<T>
{
    // ~ Fields ................................................................
    private BinaryNode<T> currentNode;

    // ~ Constructors ..........................................................
    public DecisionTree()
    {
        super();
        currentNode = null;
    }


    public DecisionTree(T rootData)
    {
        super(rootData);
        currentNode = null;
    }

    // ~Public Methods ........................................................


    public boolean isAnswer()
    {
        return currentNode.isLeaf();
    }


    public void moveToNo()
    {
        currentNode = currentNode.getLeftChild();
    }


    public void moveToYes()
    {
        currentNode = currentNode.getRightChild();
    }


    public void resetCurrentNode()
    {
        currentNode = getRootNode();
    }


    public BinaryNode<T> getCurrentNode()
    {
        return currentNode;
    }


    public T getCurrentData()
    {
        return currentNode.getData();
    }


    public void setResponses(T responseForNo, T responseForYes)
    {
        currentNode.setLeftChild(new BinaryNode<>(responseForNo));
        currentNode.setRightChild(new BinaryNode<>(responseForYes));
    }

}
