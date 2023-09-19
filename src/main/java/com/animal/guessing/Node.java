package com.animal.guessing;

public class Node {

    /**
     * Name of the animal (Leaf node)
     * The question to be asked (Non-leaf node)
      */
    private String data;

    /**
     * Used when reading/writing the decision tree from/to a file
     */
    private int label;

    /**
     * Reference to the left subtree
     */
    public Node left;

    /**
     * Reference to the right subtree
     */
    public Node right;

    public Node(String data) {
        this(data, 0);
    }

    public Node(String data, int label) {
        this.data = data;
        this.label = label;
    }

    public Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public String getQuestion() {
        return String.format("Is your animal a(n) %s", this.data);
    }

    public void extend(String data, String leftAnimal, String rightAnimal) {
        this.data = data;
        this.left = new Node(leftAnimal, this.label + 1);
        this.right = new Node(rightAnimal, this.label + 1);
    }

    public boolean isLeaf() {
        return this.left == null || this.right == null;
    }

    public  Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public String getData() {
        return this.data;
    }

    public int getLabel() {
        return this.label;
    }
}
