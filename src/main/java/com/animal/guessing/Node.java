package com.animal.guessing;

public class Node {
    private String data;
    private int label;
    private Node left;
    private Node right;

    public Node(String data) {

    }

    public Node(String data, int label) {

    }

    public Node(String data, Node left, Node right) {

    }

    public String getQuestion() {
        return null;
    }

    public void extend(String data, String leftAnimal, String rightAnimal) {

    }

    public boolean isLeaf() {
        return false;
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
