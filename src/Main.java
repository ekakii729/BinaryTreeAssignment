/*
 * Author: Abhay Manoj
 * Purpose: Reads in a file and can get information about it using binary trees
 * Date of Creation: December 11, 2023
 */

import java.io.*;
import java.util.Scanner;

public class Main {

    /** Method Name: readFileToTree
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Reads the content of the file to the tree
     * @Parameters reader - buffered reader of the text file, tree - the tree that will hold the words
     * @Returns N/A, Data Type: Void
     * Dependencies: BufferedReader
     * Throws/Exceptions: IOException
     */

    private static void readFileToTree(BufferedReader reader, BinaryTree tree) throws IOException {
        String line; // one line of the file
        while (reader.ready()) {
            line = reader.readLine();
            String[] words = line.split("\\s+|/"); // splitting the line into its individual words
            for (String word : words) {
                word = word.trim().toLowerCase().replaceAll("[^a-zA-Z0-9\\s-]", ""); // gets rid of all the stuff around the word, baeldung.com/java-remove-punctuation-from-string
                if (word.isEmpty() || word.equals("-")) continue;
                if (!tree.contains(tree.getRoot(), word)) tree.insert(word);
                else {
                    BinaryTree.Node node = tree.getNode(tree.getRoot(), word); // the node that has the word
                    node.numberOfTimesFound++;
                }
            }
        }
    }

    /** Method Name: createTree
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Creates the tree with all the words of the file
     * @Parameters fileName - the name of the file
     * @Returns A binary tree with all the words of the file, Data Type: BinaryTree
     * Dependencies: BufferedReader, FileReader
     * Throws/Exceptions: IOException
     */

    private static BinaryTree createTree(String fileName) throws IOException {
        BinaryTree tree = new BinaryTree(); // the tree that will be returned
        BufferedReader reader = new BufferedReader(new FileReader(fileName)); // used to read the file
        readFileToTree(reader, tree);
        reader.close();
        return tree;
    }

    /** Method Name: printFile
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Prints out the text file
     * @Parameters fileName - the name of the file
     * @Returns N/A, Data Type: Void
     * Dependencies: BufferedReader, FileReader
     * Throws/Exceptions: IOException
     */

    private static void printFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName)); // used to read the file
        String line; // one line of the file
        while (reader.ready()) {
            line = reader.readLine();
            System.out.println(line);
        } reader.close();
    }

    /** Method Name: runMenu
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Runs the main menu of the program
     * @Parameters input - used to take user input
     * @Returns N/A, Data Type: Void
     * Dependencies: Scanner
     * Throws/Exceptions: IOException
     */

    private static void runMenu(Scanner input) throws IOException {
        System.out.print("Welcome to the Binary Tree App. Please enter the file you wish to read in (ex. myFile.txt): ");
        String fileName = input.nextLine(); // the name of the file
        BinaryTree tree = createTree(fileName); // the tree for the file
        int choice; // the choice that the user makes
        while (true) {
            System.out.println("\nPlease select an option.\n\n1. Read in a file\n2. Print out the file\n3. Search for a word\n4. Print alphabetical list of words\n5. Print total number of words\n6. Exit");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the name of the file: ");
                    fileName = input.nextLine();
                    tree = createTree(fileName);
                    System.out.println("\nFile has been read.");
                } case 2 -> printFile(fileName);
                case 3 -> {
                    System.out.print("Enter the word that you wish to search for in lowercase (ex. java): ");
                    String word = input.nextLine(); // the word that the user is searching for
                    if (tree.contains(tree.getRoot(), word)) System.out.printf("Yes, %s is found in the file.", word);
                    else System.out.printf("No, %s is not found in the file.", word);
                } case 4 -> {
                    System.out.println("WORD\t\t\t\tNUMBER OF OCCURRENCES");
                    tree.display(tree.getRoot());
                } case 5 -> System.out.printf("There are %d words in the text.\n", tree.getNumberOfWords(tree.getRoot()));
                case 6 -> {
                    System.out.println("Program has been closed.");
                    input.close();
                    System.exit(0);
                } default -> System.out.println("\nThat is not a valid option. Please try again.");
            }
        }
    }

    /** Method Name: main
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description main method of the program
     * @Parameters args - arguments to be passed in
     * @Returns N/A, Data Type: Void
     * Dependencies: Scanner
     * Throws/Exceptions: IOException
     */

    public static void main(String[] args) throws IOException {
        runMenu(new Scanner(System.in));
    }
}
