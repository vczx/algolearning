package plurasight.dataStructureInJava.tree.ds;

public class BaiscBinaryTree<X extends Comparable<X>> {

    private Node root;
    private int size;

    public BaiscBinaryTree() {
        this.root = null;
    }

    public int size() {
        return size;
    }

    public boolean contains(X item) {
        return getNode(item) == null ? false:true;
    }

    //4 scenarios to delete a node
    public boolean delete(X item){
        boolean isDeleted = false;
        //get the node to be deleted
        Node currentNode = getNode(item);
        // empty tree
        if(root == null){
            return false;
        }
        //delete a node with no child
        if(currentNode.getLeft() == null && currentNode.getRight() == null){
            unlink(currentNode,null);
            isDeleted = true;
        }
        //delete a node with one child
        if(currentNode.getLeft() == null && currentNode.getRight() != null){
            //make the child become the currentNode
            unlink(currentNode,currentNode.getRight());
            isDeleted = true;
        }
        if(currentNode.getLeft() != null && currentNode.getRight() == null){
            unlink(currentNode,currentNode.getLeft());
            isDeleted = true;
        }

        //delete a node with two child
        if(currentNode.getLeft() != null && currentNode.getRight() != null){
            //find the largest value of the value smaller than the current node
            //means the rightmost leaf on the left side
            // or we can do the opposite, find the right side's left most leaf
            Node child = currentNode.getLeft();
            //this does not seem right
            //try 10 7 6 8 70 11 12 71 13 14 15
            // visualize binary tree
            // https://www.cs.usfca.edu/~galles/visualization/BST.html
            while (child.getRight()!= null){
                child = child.getRight();
            }
            child.getParent().setRight(null);
            child.setLeft(currentNode.getLeft());
            child.setRight(currentNode.getRight());
            unlink(child,currentNode);
            isDeleted = true;
        }

        if(isDeleted) {
            this.size--;
        }

        return isDeleted;

    }
    // to swap the position node with another node
    public void unlink(Node currentNode, Node newNode){
        //if it is a root node, the out the root node and replace it with newNode, newNode left and right will equal to the original left/right
        if(currentNode == this.root){
            currentNode.setLeft(root.getLeft());
            currentNode.setRight(root.getRight());
            this.root = currentNode;
        }else if(currentNode.getParent().getRight() == currentNode){
            currentNode.getParent().setRight(newNode);
        }else if(currentNode.getParent().getLeft() == currentNode){
            currentNode.getParent().setLeft(newNode);
        }
    }

    public Node getNode(X item) {
        Node currentNode = root;
        while( currentNode != null){
            int val =item.compareTo(currentNode.getItem());
            if(val < 0){
                currentNode = currentNode.getLeft();
            }else if(val > 0){
                currentNode = currentNode.getRight();
            }else{
                return currentNode;
            }
        }
        // no item found after traversing the entire tree
        return null;
    }

    public void add(X item) {
        Node newNode = new Node(item);
        if (root == null) {
            root = newNode;
            System.out.println("Set root: " + newNode.getItem());
            this.size++;
        } else {
            insert(root, newNode);
        }
    }

    public void insert(Node parent, Node child) {
        //smaller then the parent will go left
        if (child.getItem().compareTo(parent.getItem()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else {
                //if the parent has immediate child, make that child as the new parent and repeat the logic again
                insert(parent.getLeft(), child);
            }
        } else if (child.getItem().compareTo(parent.getItem()) > 0) { //larger than the parent will go righ
            //if the parent has immediate child, make that child as the new parent and repeat the logic again
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.right, child);
            }
        }
    }

    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.item = item;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }
}
