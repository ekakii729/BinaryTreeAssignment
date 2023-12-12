/*
 * Author: Abhay Manoj
 * Purpose: A binary tree class
 * Date of Creation: December 12, 2023
 */

public class BinaryTree {

    private Node root; // the root of the binary tree

    public static class Node {

        String item; // the content of the node
        Node left; // the left branching node
        Node right; // the right branching node
        int numberOfTimesFound; // the number of times the item is found

        public Node(String item) {
            this.item = item;
            this.left = null;
            this.right = null;
            numberOfTimesFound = 1;
        }
    }

    public BinaryTree() {}

    /** Method Name: insert
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Inserts the given string into the tree
     * @Parameters item - string to add to the tree
     * @Returns N/A, Data Type: Void
     * Dependencies: N/A
     * Throws/Exceptions: N/A
     */

    public void insert(String item) {
        if (root == null) {
            root = new Node(item);
            return;
        } Node current = root; // node to traverse the tree
        while (true) {
            if (item.compareTo(current.item) < 0)  {
                if (current.left == null) {
                    current.left = new Node(item);
                    return;
                } current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(item);
                    return;
                } current = current.right;
            }
        }
    }

    /** Method Name: contains
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Checks if the given string is in the tree
     * @Parameters node - the node in the tree that is being accessed, item - string to add to tree
     * @Returns if the given string is in the tree, Data Type: Boolean
     * Dependencies: N/A
     * Throws/Exceptions: N/A
     */

    public boolean contains(Node node, String item) {
        if (node == null) return false;
        else if (item.equals(node.item)) return true;
        else if (item.compareTo(node.item) < 0) return contains(node.left, item);
        else return contains(node.right, item);
    }

    /** Method Name: getNode
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Returns the node with a specific item
     * @Parameters node - current node being looked at, item - string to find
     * @Returns The node with the wanted string, Data Type: Node
     * Dependencies: N/A
     * Throws/Exceptions: N/A
     */

    public Node getNode(Node node, String item) {
        if (node == null || node.item.equals(item)) return node;
        Node left = getNode(node.left, item);
        Node right = getNode(node.right, item);
        return (left != null) ? left : right;
    }

    /** Method Name: display
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Prints all contents of tree to screen
     * @Parameters node - current node being accessed
     * @Returns N/A, Data Type: Void
     * Dependencies: N/A
     * Throws/Exceptions: N/A
     */

    public void display(Node node) {
        if (node == null) return;
        display(node.left);
        System.out.printf("%-20s%s%n", node.item, node.numberOfTimesFound);
        display(node.right);
    }

    /** Method Name: getNumberOfWords
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Gets number of words in the tree
     * @Parameters node - the current node being accessed
     * @Returns number of words in the tree, Data Type: Integer
     * Dependencies: N/A
     * Throws/Exceptions: N/A
     */

    public int getNumberOfWords(Node node) {
        if (node == null) return 0;
        int leftCount = getNumberOfWords(node.left);
        int rightCount = getNumberOfWords(node.right);
        return node.numberOfTimesFound + leftCount + rightCount;
    }

    public Node getRoot() { return root; }
}
