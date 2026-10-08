// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author praga
 *  @version Oct 8, 2026
 */
public interface DecisionTreeInterface<T> extends BinaryTreeInterface<T>
{

    public boolean isAnswer();

    public void moveToNo();

    public void moveToYes();

    public void resetCurrentNode();

    public BinaryNode<T> getCurrentNode();

    public T getCurrentData();

    public void setResponses(T responseForNo, T responseForYes);

}
