import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Builds the decision tree used by the SARS-CoV-3 health check and uses it to
 * advise the user. leanrs questions from the user
 * 
 * @author pragati anandarajan
 * @version Oct 9, 2026
 */
public class SARSCoV3HealthBuilder
{
    // ~ Fields ................................................................
    private DecisionTreeInterface<String> healthTree;

    // ----------------------------------------------------------
    /**
     * Create a new SARSCoV3HealthBuilder object.
     * 
     * @param fileName
     *            name of the file
     */
    // ~ Constructors ..........................................................
    public SARSCoV3HealthBuilder(String fileName)
    {
        healthTree = new DecisionTree<String>();
        ArrayList<String> contents = readData(fileName);
        healthTree
            .setRootNode(buildTree(contents, new BinaryNode<String>(), 0));
        healthTree.resetCurrentNode();
    }
    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * reads the file properly and formats it as well
     * 
     * @param fileName
     *            name of the file
     * @return every item in the file
     */
    public ArrayList<String> readData(String fileName)
    {
        ArrayList<String> contents = new ArrayList<String>();

        try
        {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                if (!line.trim().isEmpty())
                {
                    String[] items = line.split(",");
                    for (String item : items)
                    {
                        contents.add(item.trim());
                    }
                }
            }
            fileScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + fileName);
        }
        return contents;
    }


    // ----------------------------------------------------------
    /**
     * Recursively builds a decision tree from the items read from the file. The
     * items are in level order with "null" marking missing nodes
     *
     * @param contents
     *            the items read from the file, in level order
     * @param node
     *            an empty node that is filled in if the item at index is not
     *            null
     * @param index
     *            the position in contents of the item for this node
     * @return the root of the subtree built, or null if there is no node here
     */
    public BinaryNode<String> buildTree(
        ArrayList<String> contents,
        BinaryNode<String> node,
        int index)
    {
        BinaryNode<String> result = null;

        if (index < contents.size() && !contents.get(index).equals("null"))
        {
            node.setData(contents.get(index));
            node.setLeftChild(
                buildTree(contents, new BinaryNode<String>(), 2 * index + 1));
            node.setRightChild(
                buildTree(contents, new BinaryNode<String>(), 2 * index + 2));
            result = node;
        }
        return result;
    }


    /**
     * Gets the decision tree used by this health check.
     *
     * @return the health tree
     */
    public DecisionTreeInterface<String> getHealthTree()
    {
        return healthTree;
    }


    // ----------------------------------------------------------
    /**
     * ASks the user a series of yes or no questions by walking down the health
     * tree from the root, then displays the decision reached.
     */
    public void decide()
    {
        if (healthTree.isEmpty())
        {
            System.out.println("There is no decision tree to use.");
            return;
        }

        healthTree.resetCurrentNode();

        while (!healthTree.isAnswer())
        {
            System.out.println(healthTree.getCurrentData());
            if (Driver.isUserResponseYes())
            {
                healthTree.moveToYes();
            }
            else
            {
                healthTree.moveToNo();
            }
        }

        System.out.println(healthTree.getCurrentData());
        System.out.println();
        System.out.println("Satisfied by my intelligence ?");

        if (!Driver.isUserResponseYes())
        {
            learn();
        }
    }


    // ----------------------------------------------------------
    /**
     * Asks the user for the correct answer and for a question that
     * distinguishes it from the old answer, then updates the tree.
     */
    public void learn()
    {
        String oldAnswer = healthTree.getCurrentData();

        System.out.println("What should be the answer?");
        String newAnswer = Driver.getUserResponse();

        System.out.println(
            "Give me a question whose answer is yes for " + newAnswer
                + "  but no for  " + oldAnswer);
        String question = Driver.getUserResponse();

        updateTree(question, oldAnswer, newAnswer);
    }


    // ----------------------------------------------------------
    /**
     * Replaces the current leaf with a new question and gives two new leaves
     * 
     * @param question
     *            the new question to store in the current node
     * @param noAnswer
     *            the answer for the left ("no") child
     * @param yesAnswer
     *            the answer for the right ("yes") child
     */
    public void updateTree(String question, String noAnswer, String yesAnswer)
    {
        healthTree.getCurrentNode().setData(question);
        healthTree.setResponses(noAnswer, yesAnswer);
    }
}
