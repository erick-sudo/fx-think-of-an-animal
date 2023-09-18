package com.animal.guessing;

import java.util.Formatter;

public class DecisionTree {

    private Node root;
    private IBehaviour behaviour;

    public DecisionTree() {}

    public DecisionTree(IBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public boolean execute() {
        if(this.root == null) {
            this.root = behaviour.emptyTree();
        } else {
            return  this.execute(this.root);
        }
        return false;
    }

    private boolean execute(Node n) {
        if(n.isLeaf()) {
            behaviour.processLeafNode(n);
        } else {
            behaviour.processNonLeafNode(n);
        }
        return true;
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        display(sb, 0, "root:", root);
        return sb.toString();
    }

    private void display(StringBuilder sb, int level, String direction, Node node) {
        if(node == null) {
            return;
        }

        level = level + 2;
        for(int i=0;i<level;i++) {
            sb.append("  ");
        }
        sb.append(String.format("%s %s %d\n", node, node.getData(), node.getLabel()));
        display(sb, level, "left: ", node.getLeft());
        display(sb, level, "right: ", node.getRight());
    }

    private int label(Node n, int count) {
        return 0;
    }

    public void save(String name) {

    }

    private void save(Node node, Formatter formatter) {

    }

    public void load(String fname) throws Exception {

    }

    private Node insert(Node n, Node t) {
        return null;
    }
}
