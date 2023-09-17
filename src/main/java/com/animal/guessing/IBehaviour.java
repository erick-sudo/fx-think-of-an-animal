package com.animal.guessing;

public interface IBehaviour {
    Node emptyTree();
    boolean processNonLeafNode(Node n);
    boolean processLeafNode(Node n);
}
