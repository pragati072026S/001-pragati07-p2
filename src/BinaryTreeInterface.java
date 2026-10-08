// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author praga
 *  @version Oct 8, 2026
 */
public interface BinaryTreeInterface<T>
{
    public T getRootData();
    
    public BinaryNode<T> getRootNode();
    
    public void setRootNode(BinaryNode<T> rootNode);

    public int getHeight();

    public int getNumberOfNodes();

    public boolean isEmpty();

    public void clear();

}
