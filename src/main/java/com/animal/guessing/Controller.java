package com.animal.guessing;

public class Controller implements IView{

    private Game game;

    public void bind(Game g) {
        this.game = g;
    }

    @Override
    public void display(String s) {

    }

    @Override
    public void append(String s) {

    }

    @Override
    public String ask(String question) {
        return null;
    }

    @Override
    public boolean choose(String question) {
        return false;
    }

    @Override
    public String choose(String question, String choice1, String choice2) {
        return null;
    }
}
