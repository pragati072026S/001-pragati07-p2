// -------------------------------------------------------------------------
/**
 * a binary tree made of BinaryNode objects. The only way to get in the through
 * the root
 * 
 * @author Pragati Anandarajan
 * @version Oct 8, 2026
 * @param <T>
 *            data stored in the tree
 */
public class BinaryTree<T>
    implements BinaryTreeInterface<T>
{
    // ~ Fields ................................................................
    private BinaryNode<T> root;

    // ----------------------------------------------------------
    /**
     * Create a new BinaryTree object.
     */
    // ~ Constructors ..........................................................
    public BinaryTree()
    {
        root = null;
    }


    // ----------------------------------------------------------
    /**
     * Create a new BinaryTree object.
     * 
     * @param rootData
     *            data for root of tree
     */
    public BinaryTree(T rootData)
    {
        root = new BinaryNode<>(rootData);
    }


    // ----------------------------------------------------------
    /**
     * Create a new BinaryTree object.
     * 
     * @param rootData
     *            data for root of tree
     * @param leftTree
     *            the tree for left subtree
     * @param rightTree
     *            the tree for right subtree
     */
    public BinaryTree(
        T rootData,
        BinaryTree<T> leftTree,
        BinaryTree<T> rightTree)
    {
        privateSetTree(rootData, leftTree, rightTree);
    }


    // ----------------------------------------------------------
    /**
     * creates a tree from root data and two subtrees
     * 
     * @param rootData
     *            data for root of tree
     * @param leftTree
     *            the tree for left subtree
     * @param rightTree
     *            the tree for right subtree
     */
    public void setTree(
        T rootData,
        BinaryTreeInterface<T> leftTree,
        BinaryTreeInterface<T> rightTree)
    {
        privateSetTree(
            rootData,
            (BinaryTree<T>)leftTree,
            (BinaryTree<T>)rightTree);
    }


    /**
     * Gets the data in the root of the tree.
     *
     * @return the data in the root
     * @throws EmptyTreeException
     *             if the tree is empty
     */
    public T getRootData()
    {
        if (isEmpty())
        {
            throw new EmptyTreeException(
                "Cannot get the root data of an empty tree.");
        }
        return root.getData();
    }


    /**
     * Gets the root node of the tree.
     *
     * @return the root node, or null if the tree is empty
     */
    public BinaryNode<T> getRootNode()
    {
        return root;
    }


    /**
     * Sets the root node of the tree.
     *
     * @param rootNode
     *            the node to make the root
     */
    public void setRootNode(BinaryNode<T> rootNode)
    {
        root = rootNode;
    }


    /**
     * Gets the height of the tree.
     *
     * @return the height of the tree, or 0 if it is empty
     */
    public int getHeight()
    {
        int height = 0;
        if (root != null)
        {
            height = root.getHeight();
        }
        return height;
    }


    /**
     * Gets the number of nodes in the tree.
     *
     * @return the number of nodes, or 0 if the tree is empty
     */
    public int getNumberOfNodes()
    {
        int numberOfNodes = 0;
        if (root != null)
        {
            numberOfNodes = root.getNumberOfNodes();
        }
        return numberOfNodes;
    }


    /**
     * Checks whether the tree is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return root == null;
    }


    /**
     * Removes all nodes from the tree.
     */
    public void clear()
    {
        root = null;
    }


    /**
     * Displays the contents of the tree using an inorder traversal
     *
     * @throws EmptyTreeException
     *             if the tree is empty
     */
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

    // ~Public Methods ........................................................


    /**
     * Recursively adds the contents of the subtree rooted at the given node to
     * the output
     *
     * @param node
     *            the root of the subtree
     * @param output
     *            the text so far
     */
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


    /**
     * Builds this tree from root data and two subtrees, then empties the
     * subtrees so that their nodes are not shared with this tree.
     *
     * @param rootData
     *            the data for new root
     * @param leftTree
     *            the left subtree
     * @param rightTree
     *            the right subtree
     */
    private void privateSetTree(
        T rootData,
        BinaryTree<T> leftTree,
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
