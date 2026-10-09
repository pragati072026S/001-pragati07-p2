// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author praga
 * @version Oct 9, 2026
 */
public class ProjectTwoTest
{
    public static void main(String[] args)
    {
        testBinaryNode();
        testBinaryTree();
        testDecisionTree();
        testReadData();
        testBuildTree();
    }


    private static void testBinaryNode()
    {
        BinaryNode<String> workout = new BinaryNode<>(
            "workout?",
            new BinaryNode<>("unfit"),
            new BinaryNode<>("fit"));
        BinaryNode<String> root =
            new BinaryNode<>("Age >30?", new BinaryNode<>("fit"), workout);

        System.out.println("Height (expect 3): " + root.getHeight());
        System.out.println("Nodes (expect 5): " + root.getNumberOfNodes());
        System.out.println(
            "Copy nodes (expect 5): " + root.copy().getNumberOfNodes());
        System.out.println("Root is leaf (expect false): " + root.isLeaf());
        System.out.println(
            "Left is leaf (expect true): " + root.getLeftChild().isLeaf());
    }


    private static void testBinaryTree()
    {
        BinaryTree<String> noTree = new BinaryTree<>("fit");
        BinaryTree<String> workoutTree = new BinaryTree<>(
            "workout?",
            new BinaryTree<>("unfit"),
            new BinaryTree<>("fit"));
        BinaryTree<String> tree =
            new BinaryTree<>("Age >30?", noTree, workoutTree);

        System.out.println("Height (expect 3): " + tree.getHeight());
        System.out.println("Nodes (expect 5): " + tree.getNumberOfNodes());
        System.out.println("Root (expect Age >30?): " + tree.getRootData());
        System.out.println("noTree emptied (expect true): " + noTree.isEmpty());
        System.out.print("Inorder (expect fit Age >30? unfit workout? fit): ");
        tree.inorderTraversal();

        tree.clear();
        System.out.println("Cleared (expect true): " + tree.isEmpty());
        try
        {
            tree.getRootData();
            System.out.println("FAIL: no exception thrown");
        }
        catch (EmptyTreeException e)
        {
            System.out
                .println("Exception caught (expected): " + e.getMessage());
        }
    }


    private static void testDecisionTree()
    {
        DecisionTree<String> tree = new DecisionTree<>();
        BinaryNode<String> workout = new BinaryNode<>(
            "workout?",
            new BinaryNode<>("unfit"),
            new BinaryNode<>("fit"));
        tree.setRootNode(
            new BinaryNode<>("Age >30?", new BinaryNode<>("fit"), workout));
        tree.resetCurrentNode();

        System.out
            .println("Current (expect Age >30?): " + tree.getCurrentData());
        System.out.println("Is answer (expect false): " + tree.isAnswer());

        tree.moveToYes();
        System.out
            .println("After yes (expect workout?): " + tree.getCurrentData());
        tree.moveToNo();
        System.out.println("After no (expect unfit): " + tree.getCurrentData());
        System.out.println("Is answer (expect true): " + tree.isAnswer());

        tree.getCurrentNode().setData("Do you eat well?");
        tree.setResponses("unfit", "fit");
        System.out.println(
            "Is answer after learning (expect false): " + tree.isAnswer());
        tree.moveToYes();
        System.out
            .println("New yes leaf (expect fit): " + tree.getCurrentData());

        tree.resetCurrentNode();
        System.out.println("Nodes (expect 7): " + tree.getNumberOfNodes());
        System.out.println("Height (expect 4): " + tree.getHeight());
    }
    
    private static void testReadData()
    {
        SARSCoV3HealthBuilder builder = new SARSCoV3HealthBuilder("data2.txt");
        System.out.println(builder.readData("data2.txt"));
        System.out.println(builder.readData("data3.txt"));
        System.out.println(builder.readData("missing.txt"));
    }
    
    private static void testBuildTree()
    {
        SARSCoV3HealthBuilder builder = new SARSCoV3HealthBuilder("data2.txt");
        DecisionTreeInterface<String> tree = builder.getHealthTree();

        System.out.println("Root (expect Age >30?): " + tree.getRootData());
        System.out.println("Current (expect Age >30?): " + tree.getCurrentData());
        System.out.println("Nodes (expect 5): " + tree.getNumberOfNodes());
        System.out.println("Height (expect 3): " + tree.getHeight());
        System.out.print("Inorder (expect fit Age >30? unfit workout? fit): ");
        ((DecisionTree<String>)tree).inorderTraversal();

        SARSCoV3HealthBuilder empty = new SARSCoV3HealthBuilder("data3.txt");
        System.out.println("data3 empty (expect true): "
            + empty.getHealthTree().isEmpty());

        SARSCoV3HealthBuilder big = new SARSCoV3HealthBuilder("data.txt");
        System.out.println("data.txt root (expect Recently tested?): "
            + big.getHealthTree().getRootData());
        System.out.println("data.txt nodes: " + big.getHealthTree().getNumberOfNodes());
    }
    
    private static void testUpdateTree()
    {
        SARSCoV3HealthBuilder builder = new SARSCoV3HealthBuilder("data2.txt");
        DecisionTreeInterface<String> tree = builder.getHealthTree();

        tree.moveToNo();
        System.out.println("At leaf (expect fit): " + tree.getCurrentData());
        builder.updateTree("Do you have unhealthy eating habits?", "fit", "unfit");

        System.out.println("Nodes (expect 7): " + tree.getNumberOfNodes());
        System.out.println("Height (expect 3): " + tree.getHeight());
        tree.resetCurrentNode();
        tree.moveToNo();
        System.out.println("Question (expect Do you have unhealthy eating habits?): "
            + tree.getCurrentData());
        tree.moveToYes();
        System.out.println("Yes leaf (expect unfit): " + tree.getCurrentData());
    }
}
