// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author praga
 *  @version Oct 8, 2026
 */
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
    //~ Fields ................................................................
    private BinaryNode<T> root;

    //~ Constructors ..........................................................
    public BinaryTree()
    {
        root = null;
    }
    
    public BinaryTree(T rootData)
    {
        root = new BinaryNode<>(rootData);
    }
    
    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        privateSetTree(rootData, leftTree, rightTree);
    }
    
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
        BinaryTreeInterface<T> rightTree)
    {
        privateSetTree(rootData, (BinaryTree<T>)leftTree,
            (BinaryTree<T>)rightTree);
    }
    
    public T getRootData()
    {
        if (isEmpty())
        {
            throw new EmptyTreeException("Cannot get the root data of an empty tree.");
        }
        return root.getData();
    }
    
    public BinaryNode<T> getRootNode()
    {
        return root;
    }
    
    public void setRootNode(BinaryNode<T> rootNode)
    {
        root = rootNode;
    }
    
    public int getHeight()
    {
        int height = 0;
        if (root != null)
        {
            height = root.getHeight();
        }
        return height;
    }
    
    public int getNumberOfNodes()
    {
        int numberOfNodes = 0;
        if (root != null)
        {
            numberOfNodes = root.getNumberOfNodes();
        }
        return numberOfNodes;
    }
    
    public boolean isEmpty()
    {
        return root == null;
    }

    public void clear()
    {
        root = null;
    }

    
    public void inorderTraversal()
    {
        if (isEmpty())
        {
            throw new EmptyTreeException("Cannot traverse an empty tree.");
        }
        StringBuilder output = new StringBuilder();
        inorderHelper(root, output);
        System.out.println(output.toString());
    }
    
    //~Public  Methods ........................................................

    private void inorderHelper(BinaryNode<T> node, StringBuilder output)
    {
        if (node != null)
        {
            inorderHelper(node.getLeftChild(), output);
            if (output.length() > 0)
            {
                output.append(" ");
            }
            output.append(node.getData());
            inorderHelper(node.getRightChild(), output);
        }
    }
    
    private void privateSetTree(T rootData, BinaryTree<T> leftTree,
        BinaryTree<T> rightTree)
    {
        BinaryNode<T> leftRoot = null;
        BinaryNode<T> rightRoot = null;

        if (leftTree != null && !leftTree.isEmpty())
        {
            leftRoot = leftTree.root;
        }
        if (rightTree != null && !rightTree.isEmpty())
        {
            if (rightTree == leftTree)
            {
                rightRoot = rightTree.root.copy();
            }
            else
            {
                rightRoot = rightTree.root;
            }
        }

        root = new BinaryNode<>(rootData, leftRoot, rightRoot);

        if (leftTree != null && leftTree != this)
        {
            leftTree.clear();
        }
        if (rightTree != null && rightTree != this)
        {
            rightTree.clear();
        }
    }
}
