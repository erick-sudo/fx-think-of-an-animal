package com.animal.guessing;

public interface IView {
    void display(String s);
    void append(String s);
    String ask(String question);
    boolean choose(String question);
    String choose(String question, String choice1, String choice2);
}
