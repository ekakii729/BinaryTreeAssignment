public class BinaryTree {

    private Node root; // the root of the binary tree

    private static class Node {

        String item; // the content of the node
        Node left; // the left branching node
        Node right; // the right branching node

        public Node(String item) { this.item = item; }
    }

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
        System.out.println(node.item);
        display(node.right);
    }

    /** Method Name: getItemCount
     * @Author Abhay Manoj
     * @Date December 11, 2023
     * @Modified December 11, 2023
     * @Description Gets number of items in the tree
     * @Parameters node - the current node being accessed
     * @Returns number of items in the tree, Data Type: Integer
     * Dependencies: N/A
     * Throws/Exceptions: N/A
     */

    public int getItemCount(Node node) {
        if (node == null) return 0;
        int leftCount = getItemCount(node.left); // the count of nodes on left subtree
        int rightCount = getItemCount(node.right); // the count of nodes on right subtree
        return 1 + leftCount + rightCount;
    }

    private Node getRoot() { return root; }
}
