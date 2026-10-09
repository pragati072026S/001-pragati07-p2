import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author praga
 *  @version Oct 9, 2026
 */
public class SARSCoV3HealthBuilder
{
    //~ Fields ................................................................
    private DecisionTreeInterface<String> healthTree;

    //~ Constructors ..........................................................
    public SARSCoV3HealthBuilder(String fileName)
    {
        healthTree = new DecisionTree<String>();
        ArrayList<String> contents = readData(fileName);
        healthTree.setRootNode(buildTree(contents, new BinaryNode<String>(), 0));
        healthTree.resetCurrentNode();
    }
    //~Public  Methods ........................................................

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
    
    public BinaryNode<String> buildTree(ArrayList<String> contents,
        BinaryNode<String> node, int index)
    {
        BinaryNode<String> result = null;

        if (index < contents.size() && !contents.get(index).equals("null"))
        {
            node.setData(contents.get(index));
            node.setLeftChild(buildTree(contents, new BinaryNode<String>(),
                2 * index + 1));
            node.setRightChild(buildTree(contents, new BinaryNode<String>(),
                2 * index + 2));
            result = node;
        }
        return result;
    }
    
    public DecisionTreeInterface<String> getHealthTree()
    {
        return healthTree;
    }
    
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
    public void learn()
    {
        // temporary stub, replaced in the next step
    }
}
