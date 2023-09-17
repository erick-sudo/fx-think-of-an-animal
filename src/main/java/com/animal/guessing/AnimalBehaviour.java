package com.animal.guessing;

public class AnimalBehaviour implements IBehaviour {

    private IView view;

    public AnimalBehaviour(IView view) {

    }

    @Override
    public Node emptyTree() {
        return null;
    }

    @Override
    public boolean processNonLeafNode(Node n) {
        return false;
    }

    @Override
    public boolean processLeafNode(Node n) {
        return false;
    }
}
